import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();
        Controller controller = new Controller(collection, scanner);
        UserInterface ui = new UserInterface(scanner, controller);

        ui.startProgram();
        scanner.close();

    }
}
