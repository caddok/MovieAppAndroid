package com.example.georgi.movieapp.views.views.about;

import javax.inject.Inject;

public class AboutTheAppPresenter implements AboutTheAppContracts.Presenter{

    private AboutTheAppContracts.View mView;

    @Inject
    public AboutTheAppPresenter(){

    }

    @Override
    public void subscribe(AboutTheAppContracts.View view) {
        this.mView = view;
    }

    @Override
    public void allowSetView() {
        mView.setView();
    }
}
