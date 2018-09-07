package com.example.georgi.movieapp.views.views.redactoptions;

import com.example.georgi.movieapp.async.base.SchedulerProvider;
import com.example.georgi.movieapp.services.MovieService;

import javax.inject.Inject;

public class MovieRedactOptionsPresenter implements MovieRedactOptionsContracts.Presenter {
    private MovieRedactOptionsContracts.View mView;
    private MovieService mMovieService;
    private SchedulerProvider mProvider;

    @Inject
    public MovieRedactOptionsPresenter(MovieService service, SchedulerProvider provider) {
        mMovieService = service;
        mProvider = provider;
    }

    @Override
    public void subscribe(MovieRedactOptionsContracts.View view) {
        mView = view;
    }

}
