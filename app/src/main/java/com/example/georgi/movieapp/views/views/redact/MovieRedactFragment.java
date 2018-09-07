package com.example.georgi.movieapp.views.views.redact;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieRedactFragment extends Fragment implements MovieRedactContracts.View {
    @BindView(R.id.tv_name_to_redact)
    TextView mNameTextView;

    @BindView(R.id.et_redact_name)
    EditText mNameEditText;

    @BindView(R.id.tv_add_or_redact_genre)
    TextView mGenreTextView;

    @BindView(R.id.et_redact_genre)
    EditText mGenreEditText;

    @BindView(R.id.tv_redact_year)
    TextView mYearTextView;

    @BindView(R.id.et_redact_year)
    EditText mYearEditText;

    @BindView(R.id.tv_redact_duration)
    TextView mDurationTextView;

    @BindView(R.id.et_redact_duration)
    EditText mDurationEditText;

    @BindView(R.id.tv_redact_description)
    TextView mDescriptionTextView;

    @BindView(R.id.et_redact_description)
    EditText mDescriptionEditText;

    @BindView(R.id.btn_save_changes)
    Button mSaveChangesButton;

    @BindView(R.id.loading_redact)
    ProgressBar mRedactLoading;

    private Movie movie;
    private MovieRedactContracts.Presenter mPresenter;
    private static final String SHOW_ERROR = "Error: ";
    private static final String SHOW_SUCCESS_MESSAGE = "You have successfully updated ";

    @Inject
    public MovieRedactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_redact, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMovieToRedact();
    }

    @Override
    public void setPresenter(MovieRedactContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLoading() {
        mRedactLoading.setVisibility(View.VISIBLE);
        mDescriptionEditText.setVisibility(View.GONE);
        mDurationEditText.setVisibility(View.GONE);
        mGenreEditText.setVisibility(View.GONE);
        mNameEditText.setVisibility(View.GONE);
        mYearEditText.setVisibility(View.GONE);
        mSaveChangesButton.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mRedactLoading.setVisibility(View.GONE);
        mDescriptionEditText.setVisibility(View.VISIBLE);
        mDurationEditText.setVisibility(View.VISIBLE);
        mGenreEditText.setVisibility(View.VISIBLE);
        mNameEditText.setVisibility(View.VISIBLE);
        mYearEditText.setVisibility(View.VISIBLE);
        mSaveChangesButton.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(),
                SHOW_ERROR + e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMovieToRedact(Movie movie) {
        String year = String.valueOf(this.movie.getYear());
        String duration = String.valueOf(this.movie.getDuration());
        mYearEditText.setText(year, TextView.BufferType.EDITABLE);
        mNameEditText.setText(this.movie.getName(), TextView.BufferType.EDITABLE);
        mGenreEditText.setText(this.movie.getGenre(), TextView.BufferType.EDITABLE);
        mDurationEditText.setText(duration, TextView.BufferType.EDITABLE);
        mDescriptionEditText.setText(this.movie.getMovieDescription(), TextView.BufferType.EDITABLE);
    }

    @Override
    public void showSuccessMessage(Movie updatedMovie) {
        Toast.makeText(getContext(),
                SHOW_SUCCESS_MESSAGE + updatedMovie.getName(), Toast.LENGTH_SHORT).show();
        //TODO: Research about alert dialogs/dialog fragments and add one to either go to redact
        //TODO: another movie or return to the movie list
    }

    @Override
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @OnClick(R.id.btn_save_changes)
    public void onClick(View v) {
        replaceChangedValuesOfMovie();
        mPresenter.updateRedactedMovie(movie);
    }

    private void replaceChangedValuesOfMovie() {
        String newDuration = String.valueOf(mDurationEditText.getText());
        movie.setDuration(Integer.parseInt(newDuration));

        String newYear = String.valueOf(mYearEditText.getText());
        movie.setYear(Integer.parseInt(newYear));

        String newName = String.valueOf(mNameEditText.getText());
        movie.setName(newName);

        String newGenre = String.valueOf(mGenreEditText.getText());
        movie.setGenre(newGenre);

        String newDescription = String.valueOf(mDescriptionEditText.getText());
        movie.setMovieDescription(newDescription);
    }
}
