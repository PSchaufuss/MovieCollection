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

    public void editMovie()
    {
        System.out.println("\nEnter the title of the movie you want to edit:");
        String title = scanner.nextLine();
        Movie movieToEdit = collection.searchMovie(title);

        if (movieToEdit != null)
        {
            System.out.println("Editing movie: " + movieToEdit);
            System.out.println("Leave field blank if you don't want to edit anything.");

            System.out.print("New title (" + movieToEdit.getTitle() + "): ");
            String newTitle = scanner.nextLine();

            if (!newTitle.isEmpty())
            {
                movieToEdit.setTitle(newTitle);
            }

            System.out.print("New director (" + movieToEdit.getDirector() + "): ");
            String newDirector = scanner.nextLine();

            if (!newDirector.isEmpty())
            {
                movieToEdit.setDirector(newDirector);
            }

            System.out.print("New release year (" + movieToEdit.getYearCreated() + "): ");
            String yearInput = scanner.nextLine();

            if (!yearInput.isEmpty())
            {
                int newYear = Integer.parseInt(yearInput);
                movieToEdit.setYearCreated(newYear);
            }

            System.out.print("New genre (" + movieToEdit.getGenre() + "): ");
            String newGenre = scanner.nextLine();

            if (!newGenre.isEmpty())
            {
                movieToEdit.setGenre(newGenre);
            }

            System.out.print("Is the movie in color? (yes/no) [" + (movieToEdit.isColor() ? "Yes" : "No") +"]: ");
            String colorInput = scanner.nextLine();

            if (!colorInput.isEmpty())
            {
                boolean newColor = colorInput.equalsIgnoreCase("yes");
                movieToEdit.setColor(newColor);
            }

            System.out.println("New length (minutes) (" + movieToEdit.getLengthMinutes() + "): ");
            String lengthInput = scanner.nextLine();

            if (!lengthInput.isEmpty())
            {
                int newLength = Integer.parseInt(lengthInput);
                movieToEdit.setLengthMinutes(newLength);
            }

            System.out.println("Movie updated successfully!\n");
            System.out.println("------------------------------");
            System.out.println(movieToEdit);
            System.out.println("------------------------------");
        }

            else
            {
                System.out.println("No movie found with that title.");
            }

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
