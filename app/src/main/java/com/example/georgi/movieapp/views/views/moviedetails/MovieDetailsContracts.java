package com.example.georgi.movieapp.views.views.moviedetails;

import com.example.georgi.movieapp.models.Movie;

public interface MovieDetailsContracts {
    interface View {
        void showMovie(Movie movie);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void setMovie(Movie movie);

        void showUpdate(Movie movie);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMovie();

        void updateMovie(Movie movie);

        void setMovieId(int id);
    }
}
