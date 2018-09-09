package com.example.georgi.movieapp.views.views.movielist;

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
    private SchedulerProvider mProvider;
    private String mPurpose;

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
        mView.showLoading();
        Disposable observal = Observable
                .create((ObservableOnSubscribe<List<Movie>>) emitter -> {
                    List<Movie> movies = mMovieService.getAllMovies();
                    emitter.onNext(movies);
                    emitter.onComplete();
                })
                .subscribeOn(mProvider.background())
                .observeOn(mProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentMoviesToView,
                        error -> mView.showError(error));

    }

    @Override
    public void selectMovie(Movie movie) {
        switch (mPurpose) {
            case "redact":
                mView.getMovieToRedact(movie);
                break;
            case "delete":
                deleteMovie(movie);
                break;
            case "show":
                mView.showMovieDetails(movie);
                break;
        }
    }

    @Override
    public void filterMovies(String pattern) {
        if (mPurpose == null) {
            mView.showLoading();
            Disposable disposable = Observable
                    .create((ObservableOnSubscribe<List<Movie>>) emitter -> {
                        List<Movie> movies = mMovieService.getFilteredMovies(pattern);
                        emitter.onNext(movies);
                        emitter.onComplete();
                    })
                    .subscribeOn(mProvider.background())
                    .observeOn(mProvider.ui())
                    .doFinally(mView::hideLoading)
                    .subscribe(this::presentMoviesToView,
                            error -> mView.showError(error));
        }
    }

    @Override
    public void setIntentPurpose(String purpose) {
        mPurpose = purpose;
    }

    @Override
    public String getIntentPurpose() {
        return mPurpose;
    }

    @Override
    public void deleteOrShowList(String intention) {
        mView.deleteAnotherOrGoBack(intention);
    }

    private void presentMoviesToView(List<Movie> movieList) {
        if (movieList.isEmpty()) {
            mView.showEmptyMovieList();
        } else {
            mView.showMovies(movieList);
        }
    }

    private void deleteMovie(Movie movieToDelete) {
        mView.showLoading();
        String movieName = movieToDelete.getName();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<String>) emitter -> {
                    mMovieService.deleteMovie(movieToDelete.getId());
                    emitter.onNext(movieName);
                    emitter.onComplete();
                })
                .subscribeOn(mProvider.background())
                .observeOn(mProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(result -> mView.showDeleteMessage(movieName),
                        error -> mView.showError(error));
    }
}
