

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner; //Dette er kun for at lave en dummy UI, da jeg ikke kunne finde en anden løsning for at få koden til at virke

public class FileHandlerTest
{
@Test
    public void testSaveAndLoadMovies() throws IOException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner, null); // Den oprettede 'dummy interface'

        FileHandler fileHandler = new FileHandler(ui);

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148));

        fileHandler.saveMovies(movies);

        ArrayList<Movie> loadedMovies = fileHandler.loadMovies();

        assertEquals(1, loadedMovies.size(), "Should have loaded one movie");
        assertEquals("Inception", loadedMovies.get(0).getTitle(), "Movie title should match");

        new File("movies.dat").delete();
    }

/*
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
}