import bll.Game;
import ui.UI;
import ui.console.Console;
import ui.javafx.JavaFX;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UI ui = new Console();
        Game game = new Game(ui);
        game.run();
    }
}
