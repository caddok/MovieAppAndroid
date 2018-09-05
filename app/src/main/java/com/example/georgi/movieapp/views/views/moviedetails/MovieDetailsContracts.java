package com.example.georgi.movieapp.views.views.moviedetails;

import com.example.georgi.movieapp.models.Movie;

public interface MovieDetailsContracts {
    interface View{
        void showMovie(Movie movie);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }
    interface Presenter{
        void subscribe(View view);

        void loadMovie();

        void setMovieId(int id);
    }
}
