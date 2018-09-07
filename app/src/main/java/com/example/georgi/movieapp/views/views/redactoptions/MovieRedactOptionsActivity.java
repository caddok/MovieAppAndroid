package com.example.georgi.movieapp.views.views.redactoptions;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;

import javax.inject.Inject;

public class MovieRedactOptionsActivity extends BaseDrawer {
    public static final long IDENTIFIER = 959;

    private Toolbar mToolbar;

    @Inject
    MovieRedactOptionsFragment mMovieRedactFragment;

    @Inject
    MovieRedactOptionsContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_redact_options);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mMovieRedactFragment.setPresenter(mPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_redact,mMovieRedactFragment)
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
