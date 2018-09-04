package com.example.georgi.movieapp.views.views.movielist;

import com.example.georgi.movieapp.models.Movie;

import java.util.List;

public interface MoviesListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void showMovies(List<Movie> moviesList);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showEmptyMovieList();

        void showMovieDetails(Movie movie);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMovies();

        void selectMovie(Movie movie);

        void filterMovies(String pattern);

    }

    interface Navigator{
        void navigateWith(Movie movie);
    }
}
