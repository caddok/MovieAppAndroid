package com.example.georgi.movieapp.views.views.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class StartActivity extends DaggerAppCompatActivity implements MovieStartContracts.Navigator{
    public static final long IDENTIFIER = 340;

    @Inject
    StartActivityFragment mFragment;

    @Inject
    MovieStartContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.start_content, mFragment)
                .commit();

    }

    @Override
    public void navigatoTo() {
        Intent intent = new Intent(this, MoviesList.class);

        startActivity(intent);
    }
}
