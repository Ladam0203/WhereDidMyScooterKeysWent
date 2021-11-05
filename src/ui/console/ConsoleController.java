package ui.console;

import bll.Game;
import ui.UI;

import java.util.Scanner;

public class ConsoleController implements UI {
    Scanner scanner;

    public ConsoleController()
    {
        scanner = new Scanner(System.in);
    }

    @Override
    public String acquireNextInputLine() {
        System.out.print(">");
        return scanner.nextLine();
    }

    @Override
    public void displayNextOutputLine(String outputline) {
        System.out.println(outputline);
    }

    @Override
    public void displayError(String inputline) {
        System.out.println(inputline);
    }

    @Override
    public void exitEnvironment() {
        System.exit(0);
    }
}
