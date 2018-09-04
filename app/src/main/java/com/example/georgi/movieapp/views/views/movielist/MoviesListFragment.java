package com.example.georgi.movieapp.views.views.movielist;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesListFragment extends Fragment implements
        MoviesListContracts.View{
    private static final String NO_MOVIES_FOUND = "No movies were found";
    @BindView(R.id.lv_movies)
    ListView mMovieListView;

    @BindView(R.id.circle_loading_view)
    AnimatedCircleLoadingView mLoadingView;

    @BindView(R.id.et_search)
    EditText mSearchEditText;

    @Inject
    MovieListAdapter mMovieListAdapter;

    private MoviesListContracts.Presenter mPresenter;
    private static final String SHOW_ERROR = "Error: ";
    private MoviesListContracts.Navigator mNavigator;

    @Inject
    public MoviesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMovies();
    }

    @Override
    public void setPresenter(MoviesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(MoviesListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showMovies(List<Movie> moviesList) {
        mMovieListAdapter.notifyDataSetChanged();
        mMovieListAdapter.clear();
        mMovieListAdapter.addAll(moviesList);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), SHOW_ERROR + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mLoadingView.startDeterminate();
    }

    @Override
    public void hideLoading() {
        mLoadingView.stopOk();
    }

    @Override
    public void showEmptyMovieList() {
        Toast.makeText(getContext(), NO_MOVIES_FOUND, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMovieDetails(Movie movie) {
        mNavigator.navigateWith(movie);
    }

    @OnTextChanged(R.id.et_search)
    public void onTextChanged() {
        String pattern = mSearchEditText.getText().toString();
        mPresenter.filterMovies(pattern);
    }

}
