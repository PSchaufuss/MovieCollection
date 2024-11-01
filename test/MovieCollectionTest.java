import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MovieCollectionTest
{
    @Test
    public void testAddMovie()
    {
        MovieCollection collection = new MovieCollection();
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148);

        collection.addMovie(movie);

        assertFalse(collection.isEmpty(), "Collection should not be empty after adding a movie.");
        assertEquals(1, collection.getMovies().size(), "Collection should contain one movie.");
        assertEquals(movie, collection.getMovies().get(0), "The movie added should match the one retrieved.");
    }

    @Test
    public void testDeleteMovie()
    {
        MovieCollection collection = new MovieCollection();
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148);

        collection.addMovie(movie);

        boolean isDeleted = collection.deleteMovie("Inception");
        assertTrue(isDeleted, "Movie should be deleted successfully.");
        assertTrue(collection.isEmpty(), "Collection should be empty after deleting the movie.");
    }

    @Test
    public void testSortMoviesByAttribute()
    {
        MovieCollection collection = new MovieCollection();

        collection.addMovie(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148));
        collection.addMovie(new Movie("The Matrix", "Lana Wachowski", 1999, "Sci-Fi", true, 136));
        collection.addMovie(new Movie("Memento", "Christopher Nolan", 2000, "Mystery", true, 113));

        collection.sortMoviesByAttribute("director", "year");


        assertEquals("Memento", collection.getMovies().get(0).getTitle(), "Movies should be sorted by director and then year.");
        assertEquals("Inception", collection.getMovies().get(1).getTitle(), "Movies should be sorted by director and then year.");
        assertEquals("The Matrix", collection.getMovies().get(2).getTitle(), "Movies should be sorted by director and then year.");
    }
}
