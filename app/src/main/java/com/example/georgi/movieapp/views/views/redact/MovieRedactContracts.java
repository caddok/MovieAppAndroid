package com.example.georgi.movieapp.views.views.redact;

import com.example.georgi.movieapp.models.Movie;

public interface MovieRedactContracts {

    interface View{

        void setPresenter(Presenter presenter);

        void showLoading();

        void hideLoading();

        void showError(Throwable e);

        void showMovieToRedact(Movie movie);

        void showSuccessMessage(Movie movie);

        void setMovie(Movie movie);

        void setNavigator(Navigator navigator);

        void navigateToNext(String intention);
    }

    interface Presenter{

        void subscribe(View view);

        void loadMovieToRedact();

        void setMovieId(int id);

        void updateRedactedMovie(Movie movie);

        void allowNavigation(String intention);
    }

    interface Navigator {
        void navigateTo(String intention);
    }
}
