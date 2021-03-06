package com.example.georgi.movieapp.views.views.moviedetails;

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
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Movie>) emitter -> {
                    mMovie = mMovieService.getDetailsById(mMovieId);
                    mView.setMovie(mMovie);
                    emitter.onNext(mMovie);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(mView::showMovie,
                           mView::showError);
    }

    @Override
    public void setMovieId(int id) {
        mMovieId = id;
    }

    @Override
    public void updateMovie(Movie movie) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Movie>) emitter -> {
                    Movie movieToUpdate = mMovieService.update(movie, movie.getId());
                    emitter.onNext(movieToUpdate);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(mView::showUpdate,
                        mView::showError);
    }

}
