import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller
{
    private MovieCollection collection;
    private Scanner scanner;
    private UserInterface ui;

    public Controller(MovieCollection collection, Scanner scanner, UserInterface ui)
    {
        this.collection = collection;
        this.scanner = scanner;
        this.ui = ui;
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
    }

    public void deleteMovie()
    {
        ui.displayMessage("Enter the title of the movie you want to delete:");
        String title = scanner.nextLine();
        boolean isDeleted = collection.deleteMovie(title);

        if (isDeleted)
        {
            ui.displayMessage("Movie deleted successfully!");
        }
        else
        {
            ui.displayMessage("No movie found with that title.");
        }
    }

    public void editMovie()
    {
        ui.displayMessage("\nEnter the title of the movie you want to edit:");
        String title = scanner.nextLine();
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

            ui.displayMessage("Movie updated successfully!\n------------------------------\n" + movieToEdit + "\n------------------------------");
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

        public void displayAllMovies()
        {
            if (collection.isEmpty())
            {
                ui.displayMessage("No movies in the collection.");
            }
            else
            {
                for (Movie movie : collection.getMovies())
                {
                    ui.displayMovie(movie);
                    ui.displayMessage("------------------------------");
                }

            }
        }

        public void searchMovieByTitle()
        {
            ui.displayMessage("\nEnter the title to search for:");
            String title = scanner.nextLine();
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
            ui.displayMessage("Enter part of the title to search for:");
            String partialTitle = scanner.nextLine();
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
                    ui.displayMessage("------------------------------");
                }
            }
        }
    }

