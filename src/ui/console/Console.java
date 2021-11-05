package ui.console;

import ui.UI;

import java.util.Scanner;

public class Console implements UI {
    Scanner scanner;

    public Console()
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
