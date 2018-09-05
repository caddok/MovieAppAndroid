package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsContracts;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsFragment;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MovieDetailsFragment movieDetailsFragment();

    @ActivityScoped
    @Binds
    abstract MovieDetailsContracts.Presenter presenter(MovieDetailsPresenter presenter);
}

