package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.moviedetails.MovieDetailsFragment;
import com.example.georgi.movieapp.views.views.movielist.MovieListPresenter;
import com.example.georgi.movieapp.views.views.movielist.MoviesListContracts;
import com.example.georgi.movieapp.views.views.movielist.MoviesListFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MoviesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoviesListFragment moviesListFragment();

    @ActivityScoped
    @Binds
    abstract MoviesListContracts.Presenter listPresenter(MovieListPresenter presenter);

}
