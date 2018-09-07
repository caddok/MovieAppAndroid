package com.example.georgi.movieapp.diconfig;

import com.example.georgi.movieapp.views.views.about.AboutTheAppActivity;
import com.example.georgi.movieapp.views.views.create.CreateMovieActivity;
import com.example.georgi.movieapp.views.views.moviedetails.MovieDetails;
import com.example.georgi.movieapp.views.views.movielist.MoviesList;
import com.example.georgi.movieapp.views.views.start.StartActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules =
                MoviesListModule.class
    )
    abstract MoviesList moviesList();


    @ActivityScoped
    @ContributesAndroidInjector(
            modules = AboutModule.class
    )
    abstract AboutTheAppActivity aboutTheApp();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = MovieDetailsModule.class
    )
    abstract MovieDetails movieDetails();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = StartModule.class
    )
    abstract StartActivity startActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = CreateModule.class
    )
    abstract CreateMovieActivity createActivity();
}
