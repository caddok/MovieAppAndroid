package com.example.georgi.movieapp.views.views.start;

import javax.inject.Inject;

public class StartPresenter implements MovieStartContracts.Presenter {

    private MovieStartContracts.View mView;


    @Inject
    StartPresenter(){

    }

    @Override
    public void subscribeToView(MovieStartContracts.View view) {
        mView = view;
    }

    @Override
    public void allowNavigation() {
        mView.navigateToNext();
    }
}
