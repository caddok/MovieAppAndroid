package com.example.georgi.movieapp.validation;

import com.example.georgi.movieapp.models.Movie;
import com.example.georgi.movieapp.utils.navigation.Constants;

public class ValidatorMovie implements ValidationBase<Movie> {


    @Override
    public boolean isObjectValid(Movie movie) {
        return movie != null && isMovieNameValid(movie) && isMovieGenreValid(movie) && isMovieDescriptionValid(movie)
                && isMovieImageURLValid(movie) && isMovieYearValid(movie) && isMovieDurationValid(movie);
    }

    private boolean isMovieNameValid(Movie movie){
        return movie.getName().length() >= Constants.MOVIE_NAME_MINIMUM_LENGTH
                && movie.getName().length() <= Constants.MOVIE_NAME_MAXIMUM_LENGTH;
    }

    private boolean isMovieGenreValid(Movie movie){
        return movie.getGenre().length() >= Constants.MOVIE_GENRE_MINIMUM_LENGTH
                && movie.getGenre().length() <= Constants.MOVIE_GENRE_MAXIMUM_LENGTH;
    }

    private boolean isMovieDescriptionValid(Movie movie){
        return movie.getMovieDescription().length() >= Constants.MOVIE_DESCRIPTION_MINIMUM_LENGTH
                && movie.getMovieDescription().length() <= Constants.MOVIE_DESCRIPTION_MAXIMUM_LENGTH;
    }

    private boolean isMovieImageURLValid(Movie movie){
        return movie.getImgUrl().length() >= Constants.MOVIE_IMGURL_MINIMUM_LENGTH
                && movie.getImgUrl().length() <= Constants.MOVIE_IMGURL_MAXIMUM_LENGTH;
    }

    private boolean isMovieYearValid(Movie movie){
        return movie.getYear() >= Constants.MOVIE_MINIMUM_YEAR && movie.getYear() <= Constants.MOVIE_MAXIMUM_YEAR;
    }

    private boolean isMovieDurationValid(Movie movie){
        return movie.getDuration() >= Constants.MOVIE_MINIMUM_DURATION && movie.getDuration() <= Constants.MOVIE_MAXIMUM_DURAION;
    }
}
