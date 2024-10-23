import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner;
    private Controller controller;

    public UserInterface(Scanner scanner, Controller controller)
    {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void startProgram() {
        boolean running = true;

        while (running)
        {
            System.out.println("The Totally-Awesome Movie Collection!\n");
            System.out.println("1. Add a new movie");
            System.out.println("2. Show all movies");
            System.out.println("3. Search for a movie by title");
            System.out.println("4. Search for movies by part of the title");
            System.out.println("5. Edit a movie");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
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
                    break;

                case 5:
                    controller.editMovie();
                    break;

                case 6:
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
