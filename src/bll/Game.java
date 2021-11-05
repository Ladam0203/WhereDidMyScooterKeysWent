package bll;

import be.Player;
import enums.Command;
import ui.UI;

public class Game {
    UI ui;
    Parser parser;

    public Game(UI ui)
    {
        this.ui = ui;
        parser = new Parser();
    }

    public void run()
    {
        ui.displayNextOutputLine(welcomeMessage());
        while(true) {
            String inputline = ui.acquireNextInputLine();
            String[] tokens = inputline.split("\\s"); // default split on white space
            UserRequest behavior = parser.getBehaviour(tokens[0]);
            if(tokens == null) ui.displayError(inputline);
            try {
                ui.displayNextOutputLine(behavior.callback(tokens));
                if(tokens[0].equals(Command.QUIT.toString())) ui.exitEnvironment();
            }
            catch(Exception e) { ui.displayError("Unknown command!"); };
        }
    }

    public String welcomeMessage()
    {
        return "Welcome to \"Where did my scooter keys go?\", an interesting adventure game, where the objective is to help Adam find his lost scooter keys.\nNow look around with typing '" + Command.LOOK + "' to begin your adventure.\nIf you are lost, type '" + Command.HELP + "'";
    }

}
