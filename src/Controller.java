import java.io.IOException;
import java.util.ArrayList;

public class Controller
{
    private MovieCollection collection;
    private UserInterface ui;
    private FileHandler fileHandler;
    private boolean dataChanged = false;

    public Controller(MovieCollection collection, UserInterface ui, FileHandler fileHandler)
    {
        this.collection = collection;
        this.ui = ui;
        this.fileHandler = fileHandler;
        loadMovies();
    }

    public void saveMovies()
    {
        if (!dataChanged)
        {
            ui.displayMessage("No changes detected. No changes saved.");
            return;
        }
        try
        {
            fileHandler.saveMovies(collection.getMovies());
            ui.displayMessage("Movies saved to file successfully!");
            dataChanged = false;
        }
        catch (IOException e)
        {
            ui.displayMessage("Error saving movies: " + e.getMessage());
        }
    }

    public void loadMovies()
    {
        try
        {
            ArrayList<Movie> movies = fileHandler.loadMovies();
            collection.setMovies(movies);
            ui.displayMessage("Movies loaded from file.");
            dataChanged = false;
        }
        catch (IOException | ClassNotFoundException e)
        {
            ui.displayMessage("Error loading movies: " + e.getMessage());
        }

    }

    public void sortMovies(String attribute)
    {
        collection.sortMoviesByAttribute(attribute);
    }

    public void displayAllMovies()
    {
        ArrayList<Movie> sortedMovies = collection.getMovies();
        ui.displayMovies(sortedMovies);
    }


    public void addMovie()
    {
        String title = ui.readString("\nEnter title: ");
        String director = ui.readString("Enter director: ");
        int yearCreated = ui.readInt("Enter release year: ");
        String genre = ui.readString("Enter genre: ");
        boolean isColor = ui.readBoolean("Is the movie in color? (yes/no): ");
        int lengthMinutes = ui.readInt("Enter movie length (minutes): ");

        Movie movie = new Movie(title, director, yearCreated, genre, isColor, lengthMinutes);
        collection.addMovie(movie);

        ui.displayMessage("Movie added successfully!\n");
        dataChanged = true;
    }

    public void deleteMovie()
    {
        String title = ui.readString("Enter the title of the movie you want to delete:");
        boolean isDeleted = collection.deleteMovie(title);

        if (isDeleted)
        {
            ui.displayMessage("Movie deleted successfully!");
            dataChanged = true;
        }
        else
        {
            ui.displayMessage("No movie found with that title.");
        }
    }

    public void editMovie()
    {
        String title = ui.readString("\nEnter the title of the movie you want to edit:");
        Movie movieToEdit = collection.searchMovie(title);

        if (movieToEdit != null)
        {
            ui.displayMessage("Editing movie: " + movieToEdit + "\nLeave field blank if you don't want to edit anything.");

            String newTitle = ui.readString("New title (" + movieToEdit.getTitle() + "): ");
            if (!newTitle.isEmpty())
            {
                movieToEdit.setTitle(newTitle);
            }

            String newDirector = ui.readString("New director (" + movieToEdit.getDirector() + "): ");
            if (!newDirector.isEmpty())
            {
                movieToEdit.setDirector(newDirector);
            }

            String yearInput = ui.readString("New release year (" + movieToEdit.getYearCreated() + "): ");
            if (!yearInput.isEmpty())
            {
                try
                {
                    int newYear = Integer.parseInt(yearInput);
                    movieToEdit.setYearCreated(newYear);
                }
                catch (NumberFormatException e)
                {
                    ui.displayMessage("Invalid year format. Skipping this field.");
                }
            }

            String newGenre = ui.readString("New genre (" + movieToEdit.getGenre() + "): ");
            if (!newGenre.isEmpty())
            {
                movieToEdit.setGenre(newGenre);
            }

            boolean isColor = ui.readBoolean("Is the movie in color? (yes/no) [" + (movieToEdit.isColor() ? "Yes" : "No") +"]: ");
            movieToEdit.setColor(isColor);

            String lengthInput = ui.readString("New length (minutes) (" + movieToEdit.getLengthMinutes() + "): ");
            if (!lengthInput.isEmpty())
            {
                try
                {
                    int newLength = Integer.parseInt(lengthInput);
                    movieToEdit.setLengthMinutes(newLength);
                }
                catch (NumberFormatException e)
                {
                    ui.displayMessage("Invalid length format. Skipping this field.");
                }
            }

            ui.displayMessage("Movie updated successfully!");
            ui.displayMessage(UserInterface.SEPARATOR);
            dataChanged = true;
        }

            else
            {
                ui.displayMessage("No movie found with that title.");
            }

        }

        public ArrayList<Movie> getAllMovies()
        {
            return collection.getMovies();
        }

        public void searchMovieByTitle()
        {
            String title = ui.readString("\nEnter the title to search for:");
            Movie foundMovie = collection.searchMovie(title);

            if (foundMovie != null)
            {
                ui.displayMessage("\nMovie found:\n" + foundMovie);
            }

            else
            {
                ui.displayMessage("No movie found with that title.");
            }
        }

        public void searchMovieByPartOfTitle()
        {
            String partialTitle = ui.readString("Enter part of the title to search for:");
            ArrayList<Movie> foundMovies = collection.searchMoviesByPartialTitle(partialTitle);

            if (foundMovies.isEmpty())
            {
                ui.displayMessage("No movies found with that part of its title.");
            }
            else
            {
                for (Movie movie : foundMovies)
                {
                    ui.displayMovie(movie);
                    ui.displayMessage(UserInterface.SEPARATOR);
                }
            }
        }
    }

