package com.example.georgi.movieapp.views.views.moviedetails;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment implements MovieDetailsContracts.View {
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

    private MovieDetailsContracts.Presenter mPresenter;
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
        mTitleTextView.setText(movie.getName());
        mGenreTextView.setText(movie.getGenre());
<<<<<<< HEAD
        String year = "" + movie.getYear();
        mYearTextView.setText(year);
        String duration = "" + movie.getDuration();
        mDurationTextView.setText(duration);
=======

        String year = String.valueOf(movie.getYear());
        mYearTextView.setText(year);

        String duration = String.valueOf(movie.getDuration());
        mDurationTextView.setText(duration);

>>>>>>> f8ff8a6e4a3f8af1018ce33f9d1cba2fec28fd9d
        String rating = String.valueOf(movie.getRating());
        mMovieRatingTextView.setText(rating);

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
/*
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
<<<<<<< HEAD
        mTitleTextView.setVisibility(View.VISIBLE);
        mGenreTextView.setVisibility(View.VISIBLE);
        mYearTextView.setVisibility(View.VISIBLE);
        mMoviePosterImageView.setVisibility(View.VISIBLE);
        mDurationTextView.setVisibility(View.VISIBLE);
        mMovieRatingTextView.setVisibility(View.VISIBLE);
        mDescriptionTextView.setVisibility(View.VISIBLE);
    }
=======
    }*/
>>>>>>> f8ff8a6e4a3f8af1018ce33f9d1cba2fec28fd9d

}
