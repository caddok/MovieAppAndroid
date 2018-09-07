package com.example.georgi.movieapp.views.views.redactoptions;

import com.example.georgi.movieapp.models.Movie;

import java.util.List;

public interface MovieRedactOptionsContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showLoading();

        void hideLoading();

    }

    interface Presenter{
        void subscribe(View view);

    }
}
