package com.example.georgi.movieapp.views.views.about;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.georgi.movieapp.R;
import com.example.georgi.movieapp.utils.navigation.navigation.BaseDrawer;

import javax.inject.Inject;

import butterknife.BindView;

public class AboutTheAppActivity extends BaseDrawer {

    public static final long IDENTIFIER = 20;

    @Inject
    AboutTheAppFragment mFragment;

    @Inject
    AboutTheAppContracts.Presenter mPresenter;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_app);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mFragment.setPresenter(mPresenter);

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
    protected android.support.v7.widget.Toolbar getToolbar() {
        return mToolbar;
    }
}
