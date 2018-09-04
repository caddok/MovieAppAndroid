package com.example.georgi.movieapp.views.views.start;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.georgi.movieapp.R;

import javax.inject.Inject;

public class StartActivity extends AppCompatActivity {
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

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.start_content, mFragment)
                .commit();

    }
}
