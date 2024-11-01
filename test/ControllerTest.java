import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ControllerTest
{
    @Test
    public void testSortMovies()
    {
        MovieCollection collection = new MovieCollection();
        StubbedUserInterface ui = new StubbedUserInterface();
        FileHandler fileHandler = new FileHandler(ui);
        Controller controller = new Controller(collection, ui, fileHandler);

        collection.addMovie(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148));
        collection.addMovie(new Movie("The Matrix", "Lana Wachowski", 1999, "Sci-Fi", true, 136));

        controller.sortMovies("title", "year");

        assertEquals("Inception", collection.getMovies().get(0).getTitle());
        assertEquals("The Matrix", collection.getMovies().get(1).getTitle());
    }

    @Test
    public void testAddMovie()
    {
        MovieCollection collection = new MovieCollection();
        StubbedUserInterface ui = new StubbedUserInterface();
        FileHandler fileHandler = new FileHandler(ui);
        Controller controller = new Controller(collection, ui, fileHandler);

        controller.addMovie();
        assertEquals(1, collection.getMovies().size(), "Movie should be added to the collection.");
    }

    @Test
    public void testDeleteMovie()
    {
        MovieCollection collection = new MovieCollection();
        StubbedUserInterface ui = new StubbedUserInterface();
        FileHandler fileHandler = new FileHandler(ui);
        Controller controller = new Controller(collection, ui, fileHandler);

        collection.addMovie(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148));
        controller.deleteMovie();

        assertTrue(collection.isEmpty(), "Movie should be deleted from the collection.");
    }
}
