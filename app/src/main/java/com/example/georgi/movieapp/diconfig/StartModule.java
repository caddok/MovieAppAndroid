package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.movielist.MovieListPresenter;
import com.example.georgi.movieapp.views.views.movielist.MoviesListContracts;
import com.example.georgi.movieapp.views.views.start.StartActivityFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartActivityFragment aboutTheAppFragment();


    @ActivityScoped
    @Binds
    abstract MoviesListContracts.Presenter listPresenter(MovieListPresenter presenter);
}
