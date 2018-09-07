package com.example.georgi.movieapp.views.views.start;

import javax.inject.Inject;

public class StartPresenter implements MovieStartContracts.Presenter {

    private MovieStartContracts.View mView;


    @Inject
    StartPresenter(){

    }

    @Override
    public void subscribeToView(MovieStartContracts.View view) {
        this.mView = view;
    }

    @Override
    public void allowNavigation() {
        this.mView.navigateToNext();
    }

}
