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
}
