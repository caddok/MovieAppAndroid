package com.example.georgi.movieapp.views.views.start;

import com.example.georgi.movieapp.async.base.SchedulerProvider;
import com.example.georgi.movieapp.services.MovieService;

import javax.inject.Inject;

public class StartPresenter implements MovieStartContracts.Presenter {

    private MovieStartContracts.View mView;
    private final MovieService mMovieService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public StartPresenter(MovieService movieService, SchedulerProvider schedulerProvider){
        this.mMovieService = movieService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribeToView(MovieStartContracts.View view) {
        mView = view;
    }
}
