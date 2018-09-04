package com.example.georgi.movieapp.views.views.about;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;

import butterknife.BindView;

public class AboutTheApp extends BaseDrawer {
    public static final long IDENTIFIER = 20;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_app);

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected android.support.v7.widget.Toolbar getToolbar() {
        return mToolbar;
    }
}
