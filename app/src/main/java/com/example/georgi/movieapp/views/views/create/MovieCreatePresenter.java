package com.example.georgi.movieapp.views.views.create;

import com.example.georgi.movieapp.async.base.SchedulerProvider;
import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.services.MovieService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MovieCreatePresenter implements MovieCreateContracts.Presenter {

    private MovieCreateContracts.View mView;
    private final MovieService mService;
    private final SchedulerProvider mProvider;


    @Inject
    public MovieCreatePresenter(MovieService service, SchedulerProvider provider){
        this.mService = service;
        this.mProvider = provider;
    }



    @Override
    public void subscribeToView(MovieCreateContracts.View view) {
        this.mView = view;
    }

    @Override
    public void createMovie(Movie movie) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Movie>) emitter -> {
                    Movie movieToCreate = mService.addMovie(movie);
                    emitter.onNext(movieToCreate);
                    emitter.onComplete();
                })
                .subscribeOn(mProvider.background())
                .observeOn(mProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(view -> mView.navigateToListActivity(),
                        mView::showError);

    }
}
