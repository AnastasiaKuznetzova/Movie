package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int movieLength = 10;

    public MovieManager() {
    }

    public MovieManager(int movieLength) {
        this.movieLength = movieLength;
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastMovie = tmp.length - 1;
        tmp[lastMovie] = movie;
        movies = tmp;
    }

    public Movie[] getAddLastMovie() {
        int resultLength = movies.length;
        if (resultLength < movieLength) {
            movieLength = resultLength;
        }
        Movie[] result = new Movie[movieLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];

        }
        return result;
    }


}