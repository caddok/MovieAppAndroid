package com.example.georgi.movieapp.views.views.redact;

import com.example.georgi.movieapp.async.base.SchedulerProvider;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.services.MovieService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MovieRedactPresenter implements MovieRedactContracts.Presenter {
    private MovieRedactContracts.View mView;
    private MovieService mMovieService;
    private SchedulerProvider mSchedulerProvider;
    private int mMovieId;
    private Movie movie;

    @Inject
    public MovieRedactPresenter(MovieService service, SchedulerProvider provider) {
        this.mMovieService = service;
        this.mSchedulerProvider = provider;
    }


    @Override
    public void subscribe(MovieRedactContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMovieToRedact() {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Movie>) emitter-> {
                    Movie movie = mMovieService.getDetailsById(mMovieId);
                    mView.setMovie(movie);
                    emitter.onNext(movie);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(mView::showMovieToRedact,
                        mView::showError);
    }

    @Override
    public void setMovieId(int id) {
        mMovieId = id;
    }

    @Override
    public void updateRedactedMovie(Movie movie) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Movie>) emitter-> {
                    Movie movieToUpdate = mMovieService.update(movie,movie.getId());
                    emitter.onNext(movieToUpdate);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(mView::showSuccessMessage,
                        mView::showError);
    }

    @Override
    public void allowNavigation(String intention) {
        this.mView.navigateToNext(intention);
    }
}
