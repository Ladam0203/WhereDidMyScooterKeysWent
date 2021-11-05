import ui.console.ConsoleApp;
import ui.javafx.JavaFXApp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String mode = "cli";
        switch (mode)
        {
            case "gui": //if additional data about the player as to be displayed, then te Player object should be seen by he GUI, should we introduce a method where the GUI recieves data about the player "behind the scenes"?
                JavaFXApp gui = new JavaFXApp();
                gui.main(args);
                break;
            case "cli":
                ConsoleApp cli = new ConsoleApp();
                cli.main(args);
        }
    }
}
