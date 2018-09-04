package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.start.MovieStartContracts;
import com.example.georgi.movieapp.views.views.movielist.MovieListPresenter;
import com.example.georgi.movieapp.views.views.movielist.MoviesListContracts;
import com.example.georgi.movieapp.views.views.start.StartActivityFragment;
import com.example.georgi.movieapp.views.views.start.StartPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartActivityFragment startActivityFragment();


    @ActivityScoped
    @Binds
    abstract MovieStartContracts.Presenter createPresenter(StartPresenter presenter);
}
