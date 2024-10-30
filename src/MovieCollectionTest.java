/* import org.junit.jupiter.api.Test;
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

    @Test
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

    @Test
    public void testDeleteMovie() {
        MovieCollection collection = new MovieCollection();
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148);
        collection.addMovie(movie);

        boolean isDeleted = collection.deleteMovie("Inception");
        assertTrue(isDeleted, "Movie should be deleted successfully.");
        assertTrue(collection.isEmpty(), "Collection should be empty after deleting the movie.");

        boolean notFound = collection.deleteMovie("Nonexistent Movie");
        assertFalse(notFound, "Attempting to delete a non-existent movie should return false.");
    }
}
*/