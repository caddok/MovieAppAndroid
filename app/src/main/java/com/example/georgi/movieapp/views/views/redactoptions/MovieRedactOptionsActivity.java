package com.example.georgi.movieapp.views.views.redactoptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;

import javax.inject.Inject;

public class MovieRedactOptionsActivity extends BaseDrawer implements MovieRedactOptionsContracts.Navigator{
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
        mMovieRedactFragment.setNavigator(this);

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


    @Override
    public void navigateTo(String intention) {
        Intent intent;
        switch (intention) {
            case MovieRedactOptionsFragment.INTENT_TO_REDACT:
                intent = new Intent(this, MoviesList.class);
                intent.putExtra("Purpose", intention);
                startActivity(intent);
                break;
            case MovieRedactOptionsFragment.INTENT_TO_DELETE:
                intent = new Intent(this, MoviesList.class);
                intent.putExtra("Purpose", intention);
                startActivity(intent);
                break;

        }
    }
}
