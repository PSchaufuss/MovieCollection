import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    private static final String FILE_PATH = "movies.dat";
    private UserInterface ui;

    public FileHandler(UserInterface ui)
    {
        this.ui = ui;
    }

    public void saveMovies(ArrayList<Movie> movies) throws IOException
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH)))
        {
            out.writeObject(movies);
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Movie> loadMovies() throws IOException, ClassNotFoundException
    {
        ArrayList<Movie> movies = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH)))
        {
            movies = (ArrayList<Movie>) in.readObject();
        }
        catch (FileNotFoundException e)
        {
            ui.displayMessage("\nNo saved movies found. Starting with an empty collection.");
        }
        return movies;
    }
}
