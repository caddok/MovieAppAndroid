package com.example.georgi.movieapp.views.views.movielist;

import com.example.georgi.movieapp.async.AsyncSchedulerProvider;
import com.example.georgi.movieapp.async.base.SchedulerProvider;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.services.MovieService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MovieListPresenter implements MoviesListContracts.Presenter {
    private MoviesListContracts.View mView;
    private MovieService mMovieService;
    private SchedulerProvider mProvider; //

    @Inject
    public MovieListPresenter(MovieService movieService, SchedulerProvider provider) {
        mMovieService = movieService;
        mProvider = provider;
    }

    @Override
    public void subscribe(MoviesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMovies() {
        //mView.showLoading();
        Disposable observal = Observable
                .create((ObservableOnSubscribe<List<Movie>>) emitter -> {
                    List<Movie> movies = mMovieService.getAllMovies();
                    emitter.onNext(movies);
                    emitter.onComplete();
                })
                .subscribeOn(mProvider.background())
                .observeOn(mProvider.ui())
                //.doFinally(mView::hideLoading)
                .subscribe(this::presentMoviesToView,
                        error -> mView.showError(error));

    }

    @Override
    public void selectMovie(Movie movie) {
        mView.showMovieDetails(movie);
    }

    @Override
    public void filterMovies(String pattern) {
        //mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<List<Movie>>) emitter -> {
                    List<Movie> movies = mMovieService.getFilteredMovies(pattern);
                    emitter.onNext(movies);
                    emitter.onComplete();
                })
                .subscribeOn(mProvider.background())
                .observeOn(mProvider.ui())
                //.doFinally(mView::hideLoading)
                .subscribe(this::presentMoviesToView,
                        error->mView.showError(error));
    }

    private void presentMoviesToView(List<Movie> movieList) {
        if (movieList.isEmpty()) {
            mView.showEmptyMovieList();
        } else {
            mView.showMovies(movieList);
        }
    }
}
