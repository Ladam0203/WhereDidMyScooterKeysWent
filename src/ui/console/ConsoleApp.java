package ui.console;

import bll.Game;
import ui.UI;

public class ConsoleApp {
    public static void main(String[] args) {
        UI ui = new ConsoleController();
        Game game = new Game(ui);
        game.start();
        while (true)
        {
            game.execute();
        }
    }
}
