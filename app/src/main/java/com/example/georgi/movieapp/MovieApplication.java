package com.example.georgi.movieapp;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MovieApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

}
