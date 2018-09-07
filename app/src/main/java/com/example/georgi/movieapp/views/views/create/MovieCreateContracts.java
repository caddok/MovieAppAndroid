package com.example.georgi.movieapp.views.views.create;

import com.example.georgi.movieapp.models.Movie;

public interface MovieCreateContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showLoading();

        void hideLoading();

        void showError(Throwable error);

        void navigateToListActivity();


    }

    interface Presenter{

        void subscribeToView(View view);

        void createMovie(Movie movie);
    }

    public interface Navigator {

        void navigateToListActivity();
    }

}
