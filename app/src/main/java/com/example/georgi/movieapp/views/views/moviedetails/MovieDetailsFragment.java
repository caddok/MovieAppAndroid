package com.example.georgi.movieapp.views.views.moviedetails;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment implements MovieDetailsContracts.View, RatingBar.OnRatingBarChangeListener {
    @BindView(R.id.iv_movie_poster)
    ImageView mMoviePosterImageView;

    @BindView(R.id.tv_title)
    TextView mTitleTextView;

    @BindView(R.id.tv_genre)
    TextView mGenreTextView;

    @BindView(R.id.tv_year)
    TextView mYearTextView;

    @BindView(R.id.tv_duration)
    TextView mDurationTextView;

    @BindView(R.id.tv_movie_rating)
    TextView mMovieRatingTextView;

    @BindView(R.id.tv_description)
    TextView mDescriptionTextView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.rating_bar)
    RatingBar mRatingBar;

    private MovieDetailsContracts.Presenter mPresenter;
    private Movie mMovie;                                //
    private static final String SHOW_ERROR = "Error: ";


    @Inject
    public MovieDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this,view);

        mRatingBar.setOnRatingBarChangeListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMovie();
    }

    @Override
    public void showMovie(Movie movie) {
        Picasso.get()
                .load(movie.getImgUrl())
                .into(mMoviePosterImageView);
        mTitleTextView.setText(movie.getName().toUpperCase());
        mGenreTextView.setText(movie.getGenre());
        String duration = "" + movie.getDuration() + " minutes";
        mDurationTextView.setText(duration);
        String year = String.valueOf(movie.getYear());
        mYearTextView.setText("Premiere " + year);
        String rating = String.valueOf(movie.getRating());
        rating = rating.substring(0, 3);
        mMovieRatingTextView.setText("Vote - " + rating);
        mDescriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        mDescriptionTextView.setText(movie.getMovieDescription());
    }

    @Override
    public void setPresenter(MovieDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(),
                SHOW_ERROR + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mLoadingView.setVisibility(View.VISIBLE);
        mTitleTextView.setVisibility(View.GONE);
        mGenreTextView.setVisibility(View.GONE);
        mYearTextView.setVisibility(View.GONE);
        mMoviePosterImageView.setVisibility(View.GONE);
        mDurationTextView.setVisibility(View.GONE);
        mMovieRatingTextView.setVisibility(View.GONE);
        mDescriptionTextView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mLoadingView.setVisibility(View.GONE);
        mTitleTextView.setVisibility(View.VISIBLE);
        mGenreTextView.setVisibility(View.VISIBLE);
        mYearTextView.setVisibility(View.VISIBLE);
        mMoviePosterImageView.setVisibility(View.VISIBLE);
        mDurationTextView.setVisibility(View.VISIBLE);
        mMovieRatingTextView.setVisibility(View.VISIBLE);
        mDescriptionTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setMovie(Movie movie) {       //
        this.mMovie = movie;
    }

    @Override
    public void showUpdate(Movie movie) {                 //
        Toast.makeText(getContext(),
                "You have voted for " + movie.getName() + " !", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        rating = mRatingBar.getRating();
        Movie movie = mMovie;
        movie.setVotes(movie.getVotes() + 1);
        movie.setVoteSum(movie.getVoteSum() + rating);
        movie.setRating(movie.getVoteSum() / movie.getVotes());

        mPresenter.updateMovie(movie);
    }
}
