import java.util.Scanner;

public class Controller
{
    private MovieCollection collection;
    private Scanner scanner;

    public Controller(MovieCollection collection, Scanner scanner)
    {
        this.collection = collection;
        this.scanner = scanner;
    }

    public void addMovie()
    {
        System.out.println("\nEnter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter director: ");
        String director = scanner.nextLine();
        System.out.println("Enter release year: ");
        int yearCreated = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.println("Is the movie in color? (yes/no): ");
        String colorInput = scanner.nextLine();
        boolean isColor = colorInput.equalsIgnoreCase("yes");

        System.out.println("Enter movie length (minutes): ");
        int lengthMinutes = scanner.nextInt();
        scanner.nextLine();

        Movie movie = new Movie(title, director, yearCreated, genre, isColor, lengthMinutes);
        collection.addMovie(movie);

        System.out.println("Movie added successfully!\n");
    }

    public void displayAllMovies()
    {
        System.out.println("\nAll Movies in the Collection:\n");
        collection.displayMovies();
        System.out.println();
    }

    public void searchMovieByTitle()
    {
        System.out.println("\nEnter the title to search for:");
        String title = scanner.nextLine();
        Movie foundMovie = collection.searchMovie(title);

        if (foundMovie != null)
        {
            System.out.println("\nMovie found:");
            System.out.println(foundMovie);
        }
        else
        {
            System.out.println("No movie found with that title.");
        }
    }

    public void searchMovieByPartOfTitle()
    {
        System.out.println("\nEnter part of the title to search for:");
        String partialTitle = scanner.nextLine();
        collection.searchMoviesByPartialTitle(partialTitle);
    }
}
