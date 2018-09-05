package com.example.georgi.movieapp.views.views.movielist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;

public class MoviesListFragment extends Fragment implements
        MoviesListContracts.View {
    private static final String NO_MOVIES_FOUND = "No movies were found";
    @BindView(R.id.lv_movies)
    ListView mMovieListView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

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

        mMovieListView.setAdapter(mMovieListAdapter);     //

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
        mMovieListAdapter.clear();
        mMovieListAdapter.addAll(moviesList);
        mMovieListAdapter.notifyDataSetChanged();  //
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), SHOW_ERROR + e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mMovieListView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingView.setVisibility(View.GONE);
        mMovieListView.setVisibility(View.VISIBLE);
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

    @OnItemClick(R.id.lv_movies)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Movie hero = mMovieListAdapter.getItem(position);
        mPresenter.selectMovie(hero);
    }

}
