package bll;

import be.Item;
import be.Player;
import enums.Command;
import javafx.collections.ObservableList;
import ui.UI;

import java.util.List;
import java.util.Set;

public class Game {
    private UI ui;
    private Player player;
    private Parser parser;

    public Game(UI ui)
    {
        this.ui = ui;
        this.player = new Player();
        parser = new Parser(player);
    }

    public void start()
    {
        ui.displayNextOutputLine(welcomeMessage());
    }

    public void execute()
    {
        String inputline = ui.acquireNextInputLine();
        String[] tokens = inputline.split("\\s"); // default split on white space
        UserRequest behavior = parser.getBehaviour(tokens[0]);
        if(tokens == null) ui.displayError(inputline);
        try {
            ui.displayNextOutputLine(behavior.callback(tokens));
            if(tokens[0].equals(Command.QUIT.toString())) ui.exitEnvironment();
        }
        catch(Exception e) { ui.displayError("Unknown command! " + e); };
    }

    public String welcomeMessage()
    {
        return "Welcome to \"Where did my scooter keys go?\", an interesting adventure game, where the objective is to help Adam find his lost scooter keys.\nIf you are lost, type '" + Command.HELP + "'";
    }

    //example of ways for the GUI to access player data
    public List<Item> getPlayerInventory()
    {
        return player.getInventory();
    }
    public String getCurrentRoomName()
    {
        return player.getCurrentRoom().getName();
    }
    public List<Item> getCurrentRoomItems()
    {
        return player.getCurrentRoom().getItems();
    }
    public Set<String> getExitDirections()
    {
        return player.getCurrentRoom().getExitDirections();
    }

}
