package com.example.georgi.movieapp.views.views.redact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;
import com.example.georgi.movieapp.views.views.redactoptions.MovieRedactOptionsFragment;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MovieRedactActivity extends DaggerAppCompatActivity implements MovieRedactContracts.Navigator {
    public static final String REDACT_EXTRA = "redact";

    @Inject
    MovieRedactFragment mMovieRedactFragment;

    @Inject
    MovieRedactContracts.Presenter mRedactPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_redact);

        Intent incoming = getIntent();
        Movie movie = (Movie) incoming.getSerializableExtra(REDACT_EXTRA);

        mMovieRedactFragment.setPresenter(mRedactPresenter);
        mRedactPresenter.setMovieId(movie.getId());
        mMovieRedactFragment.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_to_redact, mMovieRedactFragment)
                .commit();
    }

    @Override
    public void nagivateTo(String intention) {
        Intent intent;
        switch (intention) {
            case MovieRedactOptionsFragment.INTENT_TO_REDACT:
                intent = new Intent(this, MoviesList.class);
                intent.putExtra("Purpose", intention);
                startActivity(intent);
                break;
            case "":
                intent = new Intent(this,MoviesList.class);
                intent.putExtra("Purpose",intention);
                startActivity(intent);
                break;
        }
    }
}
