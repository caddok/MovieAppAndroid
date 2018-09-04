package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.movielist.MoviesList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = MoviesList.class)
    abstract MoviesList moviesList();

}
