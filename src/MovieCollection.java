import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class MovieCollection
{
    private ArrayList<Movie> movies;
    private UserInterface ui;

    public MovieCollection()
    {
        this.movies = new ArrayList();
        this.ui = ui;
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    public boolean deleteMovie(String title)
    {
        Movie movieToDelete = searchMovie(title);

        if (movieToDelete != null)
        {
            movies.remove(movieToDelete);
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        return movies.isEmpty();
    }

    public ArrayList<Movie> getMovies()
    {
        return new ArrayList<>(movies);
    }

    public boolean sortMoviesByAttribute(String primaryAttribute, String secondaryAttribute)
    {
        Comparator<Movie> primaryComparator = getComparator(primaryAttribute);
        Comparator<Movie> secondaryComparator = getComparator(secondaryAttribute);

        if (primaryComparator == null)
        {
            primaryComparator = getComparator("title");
            ui.displayMessage("Couldn't understand primary input. Sorting by title as default.");
        }
        if (secondaryComparator == null)
        {
            secondaryComparator = getComparator("title");
        }

        Collections.sort(movies, primaryComparator.thenComparing(secondaryComparator));
        return primaryComparator != null && secondaryComparator != null;
    }

    private Comparator<Movie> getComparator(String attribute)
    {
        return switch (attribute.toLowerCase())
        {
            case "title", "t" -> Comparator.comparing(Movie::getTitle);
            case "year", "y" -> Comparator.comparing(Movie::getYearCreated);
            case "director", "d" -> Comparator.comparing(Movie::getDirector);
            case "genre", "g" -> Comparator.comparing(Movie::getGenre);
            default -> null;
        };
    }



    public void setMovies(ArrayList<Movie> movies)
    {
        this.movies = movies;
    }


    public Movie searchMovie(String title)
    {
        for (Movie movie : movies)
        {
            if (movie.getTitle().equalsIgnoreCase(title))
            {
                return movie;
            }
        }
        return null;
    }

    public ArrayList<Movie> searchMoviesByPartialTitle(String partialTitle)
    {
        ArrayList<Movie> foundMovies = new ArrayList<>()
                ;
        for (Movie movie : movies)
        {
            if (movie.getTitle().toLowerCase().contains(partialTitle.toLowerCase()))
            {
                foundMovies.add(movie);
            }
        }
        return foundMovies;
    }

}
