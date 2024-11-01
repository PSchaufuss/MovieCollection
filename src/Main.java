import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();
        UserInterface ui = new UserInterface(scanner, null);
        FileHandler fileHandler = new FileHandler(ui);
        Controller controller = new Controller(collection, ui, fileHandler);
        ui.setController(controller);


        ui.startProgram();

        controller.saveMovies();
        scanner.close();

    }
}
