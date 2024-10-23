import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();
        Controller controller = new Controller(collection, scanner);


        boolean running = true;

        while (running)
        {
            System.out.println("The Totally-Awesome Movie Collection!\n");
            System.out.println("1. Add a new movie");
            System.out.println("2. Show all movies");
            System.out.println("3. Search for a movie by title");
            System.out.println("4. Search for movies by part of the title");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    controller.addMovie();
                    break;

                case 2:
                    controller.displayAllMovies();
                    break;

                case 3:
                    controller.searchMovieByTitle();
                    break;

                case 4:
                    controller.searchMovieByPartOfTitle();

                case 5:
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
