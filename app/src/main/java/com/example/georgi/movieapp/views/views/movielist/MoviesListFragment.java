package com.example.georgi.movieapp.views.views.movielist;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;

public class MoviesListFragment extends Fragment implements
        MoviesListContracts.View {

    @BindView(R.id.lv_movies)
    ListView mMovieListView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.et_search)
    EditText mSearchEditText;

    @Inject
    MovieListAdapter mMovieListAdapter;

    private String mPurpose;
    private MoviesListContracts.Presenter mPresenter;
    private MoviesListContracts.Navigator mNavigator;
    private static final String SHOW_ERROR = "Error: ";
    private static final String NO_MOVIES_FOUND = "No movies were found";
    private static final String SHOW_DELETE_MESSAGE = "You successfully deleted ";
    private static final String SHOW_WARNING_PART_ONE = "You are about to delete ";
    private static final String SHOW_WARNING_PART_TWO = "Are you sure about that ?";

    @Inject
    public MoviesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        ButterKnife.bind(this, view);

        mPurpose = mPresenter.getIntentPurpose();
        if (mPurpose == null || mPurpose.equals("")) {
            mPurpose = "show";
            mPresenter.setIntentPurpose(mPurpose);
        }
        mMovieListView.setAdapter(mMovieListAdapter);

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
        mMovieListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(),
                SHOW_ERROR + e.getMessage(), Toast.LENGTH_LONG).show();
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
        Toast.makeText(getContext(), NO_MOVIES_FOUND, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMovieDetails(Movie movie) {
        if (mPurpose.equals("show")) {
            mNavigator.navigateWith(movie);
        }
    }


    @Override
    public void getMovieToRedact(Movie movie) {
        mNavigator.navigateWith(movie);
    }

    @Override
    public void showDeleteMessage(String movieName) {
        Toast.makeText(getContext(),
                SHOW_DELETE_MESSAGE + movieName, Toast.LENGTH_LONG).show();
        mPresenter.loadMovies();
    }

    @Override
    public void deleteAnotherOrGoBack(String intention) {
        mNavigator.navigateWith(intention);
    }

    @OnTextChanged(R.id.et_search)
    public void onTextChanged() {
        String pattern = mSearchEditText.getText().toString();
        mPresenter.filterMovies(pattern);
    }

    @OnItemClick(R.id.lv_movies)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Movie movie = mMovieListAdapter.getItem(position);

        if (mPurpose.equals("show")) {
            mPresenter.selectMovie(movie);
        }

        if(mPurpose.equals("redact")) {
            mPresenter.selectMovie(movie);
        }

        if (mPurpose.equals("delete")) {
            AlertDialog.Builder mDeleteAlertBuilder = new AlertDialog.Builder(getContext());
            View mDeleteView = View.inflate(getContext(), R.layout.dialog_delete, null);
            TextView mWarningTextView = mDeleteView.findViewById(R.id.tv_delete_warning);
            TextView mDeleteTextView = mDeleteView.findViewById(R.id.tv_delete_film);

            if (movie != null) {
                setDeleteMessage(mDeleteTextView, movie.getName());
            }

            Button mYesButton = mDeleteView.findViewById(R.id.btn_delete_yes);
            Button mNoButton = mDeleteView.findViewById(R.id.btn_delete_no);

            mDeleteAlertBuilder.setView(mDeleteView);
            AlertDialog deleteDialog = mDeleteAlertBuilder.create();
            deleteDialog.show();

            getYesClick(mYesButton, movie, deleteDialog);
            getNoClick(mNoButton,deleteDialog);
        }
    }

    private void getYesClick(Button mYesButton, Movie movie, AlertDialog deleteDialog) {
        mYesButton.setOnClickListener(v -> {
            mPresenter.selectMovie(movie);
            deleteDialog.hide();
            AlertDialog.Builder mDeleteAnotherDialogBuilder = new AlertDialog.Builder(getContext());
            View mDeleteAnotherView = View.inflate(getContext()
                    ,R.layout.dialog_delete_continued,null);
            TextView mDeleteChangesTextView = mDeleteAnotherView.findViewById(R.id.tv_changes_delete);
            TextView mDeleteThanksTextView = mDeleteAnotherView.findViewById(R.id.tv_thank_you_delete);
            Button mDeleteAnotherButton = mDeleteAnotherView.findViewById(R.id.btn_delete_another);
            Button mToListButton = mDeleteAnotherView.findViewById(R.id.btn_go_back_delete);

            mDeleteAnotherDialogBuilder.setView(mDeleteAnotherView);
            AlertDialog deleteAnotherDialog = mDeleteAnotherDialogBuilder.create();
            deleteAnotherDialog.show();

            getDeleteAnotherClick(mDeleteAnotherButton,deleteAnotherDialog);
            getToListClick(mToListButton,deleteAnotherDialog);
        });
    }

    private void getToListClick(Button mToListButton, AlertDialog deleteAnotherDialog) {
        mToListButton.setOnClickListener(v -> {
            deleteAnotherDialog.hide();
            mPresenter.deleteOrShowList("show");
        });
    }

    private void getDeleteAnotherClick(Button mDeleteAnotherButton, AlertDialog deleteAnotherDialog) {
        mDeleteAnotherButton.setOnClickListener(v -> {
            deleteAnotherDialog.hide();
            mPresenter.deleteOrShowList("delete");
        });
    }

    private void getNoClick(Button mNoButton, AlertDialog deleteDialog) {
        mNoButton.setOnClickListener(v -> deleteDialog.hide());

    }

    private void setDeleteMessage(TextView mDeleteTextView, String name) {
        String message = SHOW_WARNING_PART_ONE + name + "\n" + SHOW_WARNING_PART_TWO;
        mDeleteTextView.setText(message);
        mDeleteTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

}
