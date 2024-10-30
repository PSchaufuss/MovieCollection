import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();
        UserInterface ui = new UserInterface(scanner, null);
        Controller controller = new Controller(collection, ui);
        ui.setController(controller);


        ui.startProgram();
        scanner.close();

    }
}
