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
        ui.displayMessage("\nEnter title: ");
        String title = scanner.nextLine();

        ui.displayMessage("Enter director: ");
        String director = scanner.nextLine();

        ui.displayMessage("Enter release year: ");
        int yearCreated = scanner.nextInt();
        scanner.nextLine();

        ui.displayMessage("Enter genre: ");
        String genre = scanner.nextLine();

        ui.displayMessage("Is the movie in color? (yes/no): ");
        String colorInput = scanner.nextLine();
        boolean isColor = colorInput.equalsIgnoreCase("yes");

        ui.displayMessage("Enter movie length (minutes): ");
        int lengthMinutes = scanner.nextInt();
        scanner.nextLine();

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

            ui.displayMessage("New title (" + movieToEdit.getTitle() + "): ");
            String newTitle = scanner.nextLine();

            if (!newTitle.isEmpty())
            {
                movieToEdit.setTitle(newTitle);
            }

            ui.displayMessage("New director (" + movieToEdit.getDirector() + "): ");
            String newDirector = scanner.nextLine();

            if (!newDirector.isEmpty())
            {
                movieToEdit.setDirector(newDirector);
            }

            ui.displayMessage("New release year (" + movieToEdit.getYearCreated() + "): ");
            String yearInput = scanner.nextLine();

            if (!yearInput.isEmpty())
            {
                int newYear = Integer.parseInt(yearInput);
                movieToEdit.setYearCreated(newYear);
            }

            ui.displayMessage("New genre (" + movieToEdit.getGenre() + "): ");
            String newGenre = scanner.nextLine();

            if (!newGenre.isEmpty())
            {
                movieToEdit.setGenre(newGenre);
            }

            ui.displayMessage("Is the movie in color? (yes/no) [" + (movieToEdit.isColor() ? "Yes" : "No") +"]: ");
            String colorInput = scanner.nextLine();

            if (!colorInput.isEmpty())
            {
                boolean newColor = colorInput.equalsIgnoreCase("yes");
                movieToEdit.setColor(newColor);
            }

            ui.displayMessage("New length (minutes) (" + movieToEdit.getLengthMinutes() + "): ");
            String lengthInput = scanner.nextLine();

            if (!lengthInput.isEmpty())
            {
                int newLength = Integer.parseInt(lengthInput);
                movieToEdit.setLengthMinutes(newLength);
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

