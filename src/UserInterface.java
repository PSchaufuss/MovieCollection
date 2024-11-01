import java.util.InputMismatchException;
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

    public void displayMovies(ArrayList<Movie> movies)
    {
        if (movies.isEmpty())
        {
            displayMessage("No movies in the collection.\n");
        }
        else
        {
            for (Movie movie : movies)
            {
                System.out.println(movie);
                displayMessage(SEPARATOR);
            }
        }
    }

    public void displayAllMovies()
    {
        String attribute = readString("Enter attribute to sort by (title, year, director, genre): \n");
        controller.sortMovies(attribute);
        System.out.println(SEPARATOR);
        controller.displayAllMovies();
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public int readInt(String prompt)
    {
        int number = 0;
        boolean valid = false;
        while (!valid)
        {
            try
            {
                System.out.println(prompt);
                number = scanner.nextInt();
                scanner.nextLine();
                valid = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return number;
    }

    public boolean readBoolean(String prompt)
    {
        displayMessage(prompt);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    public String readString(String prompt)
    {
        displayMessage(prompt);
        return scanner.nextLine();
    }

    public void startProgram()
    {
        boolean running = true;

        while (running) {
            System.out.println("\nThe Totally-Awesome Movie Collection!\n");
            System.out.println("1. Add new movie");
            System.out.println("2. View movies");
            System.out.println("3. Search for movie by title");
            System.out.println("4. Search for movies by part of the title");
            System.out.println("5. Edit movie");
            System.out.println("6. Delete movie");
            System.out.println("7. Save movies");
            System.out.println("8. Load movies");
            System.out.println("9. Exit");
            System.out.print("\nChoose an option.");

            int choice = readInt("\n" + SEPARATOR + "\nChoice: ");

            switch (choice)
            {
                case 1 -> controller.addMovie();
                case 2 -> displayAllMovies();
                case 3 -> controller.searchMovieByTitle();
                case 4 -> controller.searchMovieByPartOfTitle();
                case 5 -> controller.editMovie();
                case 6 -> controller.deleteMovie();
                case 7 -> controller.saveMovies();
                case 8 -> controller.loadMovies();
                case 9 ->
                {
                    running = false;
                    displayMessage("Goodbye!");
                }
                default -> displayMessage("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
