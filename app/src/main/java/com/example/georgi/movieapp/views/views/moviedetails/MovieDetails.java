package com.example.georgi.movieapp.views.views.moviedetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;

import javax.inject.Inject;

import butterknife.BindView;

public class MovieDetails extends BaseDrawer {
    public static final long IDENTIFIER = 651;
    public static final String EXTRA_KEY = "details";

    @Inject
    MovieDetailsFragment mMovieDetailsFragment;

    @Inject
    MovieDetailsContracts.Presenter mMovieDetailsPresenter;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        Intent incoming = getIntent();
        Movie movie = (Movie) incoming.getSerializableExtra(MovieDetails.EXTRA_KEY);

        mMovieDetailsPresenter.setMovieId(movie.getId());
        mMovieDetailsFragment.setPresenter(mMovieDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.movie_content,mMovieDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getToolbar() {
        return mToolbar;
    }
}
