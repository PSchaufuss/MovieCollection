

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class FileHandlerTest
{
@Test
    public void testSaveAndLoadMovies() throws IOException, ClassNotFoundException
    {
        UserInterface ui = new UserInterface(null, null); // Den oprettede 'dummy interface'
        FileHandler fileHandler = new FileHandler(ui);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148));

        fileHandler.saveMovies(movies);

        ArrayList<Movie> loadedMovies = fileHandler.loadMovies();

        assertEquals(1, loadedMovies.size(), "Should have loaded one movie");
        assertEquals("Inception", loadedMovies.get(0).getTitle(), "Movie title should match");

        new File("movies.dat").delete();
    }

    @Test
    public void testNoSaveIfNoChange() throws IOException, ClassNotFoundException, InterruptedException
    {
        UserInterface ui = new UserInterface(null, null); // Laver en dummy til min test
        FileHandler fileHandler = new FileHandler(ui);

        ArrayList<Movie> movies = new ArrayList<>();
        fileHandler.saveMovies(movies); // Det første save

        File file = new File("movies.dat");
        long fileSizeBefore = file.length();

        Thread.sleep(10);

        fileHandler.saveMovies(movies); // Test om jeg kan save igen uden ændringer

        long fileSizeAfter = file.length();

        assertEquals(fileSizeBefore, fileSizeAfter, "File should not be updated if no changes have been made.");

        file.delete();
    }
}