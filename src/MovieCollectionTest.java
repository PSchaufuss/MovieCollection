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
        assertEquals(1, collection.getMovieCollectionList().size(), "Collection should contain one movie.");
        assertEquals(movie, collection.getMovieCollectionList().get(0), "The movie added should match the one retrieved.");
    }

    public void testGetMovieCollectionList()
    {
        MovieCollection collection = new MovieCollection();
        Movie movie1 = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148);
        Movie movie2 = new Movie("The Matrix", "Lana Wachowski", 1999, "Sci-Fi", true, 136);

        collection.addMovie(movie1);
        collection.addMovie(movie2);

        ArrayList<Movie> movies = collection.getMovieCollectionList();

        assertEquals(2, movies.size(), "Collection should contain two movies.");
        assertTrue(movies.contains(movie1), "Collection should contain the first movie.");
        assertTrue(movies.contains(movie2), "Collection should contain the second movie.");

    }
}
