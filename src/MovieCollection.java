import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class MovieCollection
{
    private ArrayList<Movie> movies;

    public MovieCollection()
    {
        this.movies = new ArrayList();
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
        return movies;
    }

    public void sortMoviesByAttribute(String attribute)
    {
        switch (attribute.toLowerCase())
        {
            case "title", "t" -> Collections.sort(movies, Comparator.comparing(Movie::getTitle));
            case "year", "y" -> Collections.sort(movies, Comparator.comparing(Movie::getYearCreated));
            case "director", "d" -> Collections.sort(movies, Comparator.comparing(Movie::getDirector));
            case "genre", "g" -> Collections.sort(movies, Comparator.comparing(Movie::getGenre));
            default -> Collections.sort(movies, Comparator.comparing(Movie::getTitle));
        }
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
