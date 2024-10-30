import java.util.ArrayList;

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

    public void displayMovies()
    {
        if (movies.isEmpty())
        {
            System.out.println("No movies in the collection.");
            return;
        }

        for (int i = 0; i < movies.size(); i++)
        {
            System.out.println(movies.get(i));
            if (i < movies.size() - 1)
            {
                System.out.println("------------------------------");
            }
        }
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

    public ArrayList<Movie> getMovieCollectionList()
    {
        return movies;
    }
}
