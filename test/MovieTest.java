import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest
{

    @Test
    public void testMovieAttributes()
    {
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148);

        assertEquals("Inception", movie.getTitle(), "Title should be 'Inception'.");
        assertEquals("Christopher Nolan", movie.getDirector(), "Director should be 'Christopher Nolan'.");
        assertEquals(2010, movie.getYearCreated(), "Year should be 2010.");
        assertEquals("Sci-Fi", movie.getGenre(), "Genre should be 'Sci-Fi'.");
        assertTrue(movie.isColor(), "Movie should be in color.");
        assertEquals(148, movie.getLengthMinutes(), "Length should be 148 minutes.");
    }

    @Test
    public void testSetMovieAttributes()
    {
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", true, 148);
        movie.setTitle("Interstellar");
        movie.setDirector("Quentin Tarantino");
        movie.setYearCreated(2014);
        movie.setGenre("Adventure");
        movie.setColor(false);
        movie.setLengthMinutes(169);

        assertEquals("Interstellar", movie.getTitle());
        assertEquals("Quentin Tarantino", movie.getDirector());
        assertEquals(2014, movie.getYearCreated());
        assertEquals("Adventure", movie.getGenre());
        assertFalse(movie.isColor());
        assertEquals(169, movie.getLengthMinutes());
    }
}
