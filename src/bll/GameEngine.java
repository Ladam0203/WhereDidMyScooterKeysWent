package bll;

import be.Item;
import be.Player;
import be.Room;

import java.util.stream.Collectors;

public class GameEngine {
    Player player;
    public GameEngine(Player player)
    {
        this.player = player;
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

    public String take(String itemName) {
        Item item = player.getCurrentRoom().getItem(itemName);
        if (item == null)
        {
            return "There is no such item in this room!";
        }
        if (!item.canBePickedUp())
        {
            return "You cannot pick up this item!";
        }
        player.getCurrentRoom().removeItem(item);
        player.addItem(item);
        return "You have picked up " + item.getName();
    }

    public String drop(String itemName) {
        Item item = player.getItem(itemName);
        if (item == null)
        {
            return "You don't have that item on you!";
        }
        player.removeItem(item);
        player.getCurrentRoom().addItem(item);
        return "You have dropped your " + item.getName();
    }

    public String inventory() {
            return "Inventory (" + player.getInventoryCapacity() + "kg/" + player.getInventoryWeight() + "kg):" +
                    (player.getInventory().size() != 0 ?
                        "\n" + player.getInventory().stream().map(Item::getLongDescription).collect(Collectors.joining("\n"))
                        : ""
                    );
    }
}
