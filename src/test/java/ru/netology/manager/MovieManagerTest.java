package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    MovieManager manager = new MovieManager(10);
    private Movie first = new Movie(1, "Bloodshot", "thriller");
    private Movie second = new Movie(2, "Onward", "cartoon");
    private Movie third = new Movie(3, "Hotel Belgrade", "comedy");
    private Movie fourth = new Movie(4, "The Gentlemen", "crime");
    private Movie fifth = new Movie(5, "The Invisible Man", "fantasy");
    private Movie sixth = new Movie(6, "Trolls World Tour", "cartoon");
    private Movie seventh = new Movie(7, "Number One", "comedy");
    private Movie eighth = new Movie(8, "eighth", "none");
    private Movie ninth = new Movie(9, "ninth", "none");
    private Movie tenth = new Movie(10, "tenth", "none");




    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
    }

    @Test
    void giveOutActualNumberMovies() {
        MovieManager manager = new MovieManager(6);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        Movie movieAdd = new Movie(6, "Trolls World Tour", "cartoon");
        manager.addMovie(movieAdd);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = {new Movie(6, "Trolls World Tour", "cartoon"),fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }




    @Test
    void giveOutTenMovies() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void giveOutShowNothing() {
        MovieManager manager = new MovieManager(0);
        Movie[] actual = manager.getAddLastMovie();
        Movie [] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
    @Test
    void giveOutFifthLimitMovies() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = new Movie[] {fifth, fourth, third, second, first,};
        assertArrayEquals(expected, actual);
    }
    @Test
    void giveOutMoreLimitMovies() {
        MovieManager manager = new MovieManager(11);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getAddLastMovie();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}