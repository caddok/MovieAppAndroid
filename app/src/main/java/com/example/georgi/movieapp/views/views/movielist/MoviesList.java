package com.example.georgi.movieapp.views.views.movielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;

import butterknife.BindView;

public class MoviesList extends BaseDrawer {
    public static final long IDENTIFIER = 972;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
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
