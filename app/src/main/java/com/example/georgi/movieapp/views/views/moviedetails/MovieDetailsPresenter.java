package com.example.georgi.movieapp.views.views.moviedetails;

import com.example.georgi.movieapp.async.AsyncSchedulerProvider;
import com.example.georgi.movieapp.async.base.SchedulerProvider;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.services.MovieService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MovieDetailsPresenter implements MovieDetailsContracts.Presenter {
    private MovieDetailsContracts.View mView;
    private MovieService mMovieService;
    private SchedulerProvider mSchedulerProvider;
    private int mMovieId;
    private Movie mMovie;

    @Inject
    public MovieDetailsPresenter(MovieService service, SchedulerProvider provider){
        mMovieService = service;
        mSchedulerProvider = provider;
    }

    @Override
    public void subscribe(MovieDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMovie() {
        //mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Movie>) emitter -> {
                    Movie movie = mMovieService.getDetailsById(mMovieId);
                    emitter.onNext(movie);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showMovie);
    }

    @Override
    public void setMovieId(int id) {
        mMovieId = id;
    }

}
