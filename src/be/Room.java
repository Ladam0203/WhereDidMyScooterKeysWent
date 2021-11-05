package be;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> items;

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * @return The description of the room.
     */
    private String getDescription()
    {
        return description;
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public Item getItem(String name) { return items.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);}

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    public String getExitString()
    {
        return "-Exits: " + String.join(" ", exits.keySet());
    }

    public String getItemString()
    {
        if (items.size() != 0)
        {
            return "-Items: " + items.stream().map(Item::getName).collect(Collectors.joining(" "));
        }
        return "-No items in this room";
    }

    public String getLongDescription()
    {
        return "[" + getDescription() + "]\n" + getExitString() + "\n" + getItemString();
    }
}
