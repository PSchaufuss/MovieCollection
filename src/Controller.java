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

        System.out.println("Is the movie in color? (yes/no): \n");
        String colorInput = scanner.nextLine();
        boolean isColor = colorInput.equalsIgnoreCase("yes");

        System.out.println("Enter movie length (minutes): ");
        int lengthMinutes = scanner.nextInt();
        scanner.nextLine();

        Movie movie = new Movie(title, director, yearCreated, genre, isColor, lengthMinutes);
        collection.addMovie(movie);

        System.out.println("Movie added successfully!\n");
    }
}
