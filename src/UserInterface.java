import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface
{
    private Scanner scanner;
    private Controller controller;
    public static final String SEPARATOR = "------------------------------";

    public UserInterface(Scanner scanner, Controller controller)
    {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void displayMessage(String message)
    {
        System.out.println(message);
    }

    public void displayMovie(Movie movie)
    {
        System.out.println(movie);
    }

    public void displayAllMovies() {

        ArrayList<Movie> movies = controller.getAllMovies();

        if (movies.isEmpty())
        {
            displayMessage("No movies in the collection.");
        }
        else
        {
            for (Movie movie : movies)
            {
                displayMovie(movie);
                displayMessage(SEPARATOR);
            }
        }
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void startProgram()
    {
        boolean running = true;

        while (running) {
            System.out.println("The Totally-Awesome Movie Collection!\n");
            System.out.println("1. Add a new movie");
            System.out.println("2. Show all movies");
            System.out.println("3. Search for a movie by title");
            System.out.println("4. Search for movies by part of the title");
            System.out.println("5. Edit a movie");
            System.out.println("6. Delete a movie");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    controller.addMovie();
                    break;

                case 2:
                    displayAllMovies();
                    break;

                case 3:
                    controller.searchMovieByTitle();
                    break;

                case 4:
                    controller.searchMovieByPartOfTitle();
                    break;

                case 5:
                    controller.editMovie();
                    break;

                case 6:
                    controller.deleteMovie();
                    break;

                case 7:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
