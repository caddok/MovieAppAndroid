package com.example.georgi.movieapp.views.views.movielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetails;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsFragment;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsPresenter;
import com.example.georgi.movieapp.views.views.redact.MovieRedactActivity;
import com.example.georgi.movieapp.views.views.redactoptions.MovieRedactOptionsFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class MoviesList extends BaseDrawer implements MoviesListContracts.Navigator {
    public static final long IDENTIFIER = 972;

    @Inject
    MoviesListFragment mMovieListFragment;

    @Inject
    MoviesListContracts.Presenter mPresenter;

    private Toolbar mToolbar;
    private String mIntentExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        mToolbar = this.findViewById(R.id.toolbar);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        Intent incoming = getIntent();
        mIntentExtra = incoming.getStringExtra("Purpose");

        mPresenter.setIntentPurpose(mIntentExtra);
        mMovieListFragment.setNavigator(this);
        mMovieListFragment.setPresenter(mPresenter);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content,mMovieListFragment)
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
    public void navigateWith(Movie movie) {
        Intent intent = null;

        if (mIntentExtra != null && mIntentExtra.equals(MovieRedactOptionsFragment.INTENT_TO_REDACT)) {
            intent = new Intent(this, MovieRedactActivity.class);
            intent.putExtra(MovieRedactActivity.REDACT_EXTRA,movie);
        } else {
            intent = new Intent(this,MovieDetails.class);
            intent.putExtra(MovieDetails.EXTRA_KEY,movie);
        }
        startActivity(intent);
    }
}
