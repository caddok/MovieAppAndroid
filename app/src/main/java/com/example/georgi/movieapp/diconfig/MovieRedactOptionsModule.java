package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.redactoptions.MovieRedactOptionsContracts;
import com.example.georgi.movieapp.views.views.redactoptions.MovieRedactOptionsFragment;
import com.example.georgi.movieapp.views.views.redactoptions.MovieRedactOptionsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieRedactOptionsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MovieRedactOptionsFragment moviesRedactOptionsFragment();

    @ActivityScoped
    @Binds
    abstract MovieRedactOptionsContracts.Presenter
    redactOptionsPresenter(MovieRedactOptionsPresenter presenter);
}
