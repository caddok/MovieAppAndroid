package com.example.georgi.movieapp.views.views.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;

import javax.inject.Inject;

public class CreateMovieActivity extends BaseDrawer implements MovieCreateContracts.Navigator{

    public static final int IDENTIFIER = 605;
    private Toolbar mToolbar;

    @Inject
    CreateMovieFragment mFragment;

    @Inject
    MovieCreateContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
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
    public void navigateToListActivity() {
        Intent intent = new Intent(this, MoviesList.class);

        startActivity(intent);

        finish();
    }
}
