package com.example.georgi.movieapp.views.views.start;

import android.app.Activity;
import android.os.Bundle;

import com.example.georgi.movieapp.R;

public class StartActivity extends Activity {
    public static final long IDENTIFIER = 340;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
}
