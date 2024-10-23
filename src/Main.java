import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        boolean running = true;
        while (running)
        {
            System.out.println("The Totally-Awesome Movie Collection!\n\n");
            System.out.println("1. Add a new movie");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
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

                    System.out.println("Movie added successfully!");
                    break;

                case 2:
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
