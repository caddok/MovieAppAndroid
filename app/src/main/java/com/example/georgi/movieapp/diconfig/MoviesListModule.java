package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsFragment;
import com.example.georgi.movieapp.views.views.movielist.MoviesListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MoviesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoviesListFragment moviesListFragment();

    //TODO:Add presenter for the activity
    /*@ActivityScoped
    @Binds
    abstract MovieListFragment aboutTheAppFragment();*/
}
