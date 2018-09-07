package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.create.CreateMovieFragment;
import com.example.georgi.movieapp.views.views.create.MovieCreateContracts;
import com.example.georgi.movieapp.views.views.create.MovieCreatePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CreateMovieFragment createActivityFragment();


    @ActivityScoped
    @Binds
    abstract MovieCreateContracts.Presenter createPresenter(MovieCreatePresenter presenter);
}
