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

    public void displayMovies()
    {
        for (Movie movie : movies)
        {
            System.out.println(movie);
        }
    }
}
