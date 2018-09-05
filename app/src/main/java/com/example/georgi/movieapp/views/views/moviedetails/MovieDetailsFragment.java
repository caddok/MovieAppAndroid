package com.example.georgi.movieapp.views.views.moviedetails;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        Picasso.get().load(movie.getImgUrl()).into(mMoviePosterImageView);
        mTitleTextView.setText(movie.getName());
        mGenreTextView.setText(movie.getGenre());
        mYearTextView.setText(movie.getYear());
        mDurationTextView.setText(movie.getDuration());
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
        Toast.makeText(getContext(), SHOW_ERROR + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        //TODO
    }

    @Override
    public void hideLoading() {
        //TODO
    }
}
