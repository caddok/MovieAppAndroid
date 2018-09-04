package com.example.georgi.movieapp.views.views.moviedetails;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;

import butterknife.BindView;

public class MovieDetails extends BaseDrawer {
    public static final long IDENTIFIER = 651;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
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
