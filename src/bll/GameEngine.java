package bll;

import be.Item;
import be.Player;
import be.Room;

public class GameEngine {
    Player player;

    public GameEngine()
    {
        this.player = new Player();
        init();
    }

    public void init() //Inits rooms and places player
    {
        Room hall = new Room("Hall");
        Room myRoom = new Room("My room");

        hall.setExit("north", myRoom);
        myRoom.setExit("south", hall);

        hall.addItem(new Item("umbrella", "a must-have in Denmark", 1, true));

        player.setCurrentRoom(hall);

        //
    }

    public String go(String direction) {
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null)
            return "You cannot go there!";
        else
        {
            player.addToPath(player.getCurrentRoom());
            player.setCurrentRoom(nextRoom);
            return player.getCurrentRoom().getLongDescription();
        }
    }

    public String look() {
        return player.getCurrentRoom().getLongDescription();
    }

    public String observe(String itemName) {
        Item item = player.getCurrentRoom().getItem(itemName);
        return item == null ? "There is no such item in this room!" : item.getLongDescription();
    }
}
