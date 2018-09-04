package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.about.AboutTheAppFragment;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MovieDetailsFragment movieDetailsFragment();

    //TODO:Add presenter for the activity
    /*@ActivityScoped
    @Binds
    abstract MovieDetailsFragment aboutTheAppFragment();*/
}

