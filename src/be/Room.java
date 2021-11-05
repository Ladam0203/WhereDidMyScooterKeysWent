package be;

import javafx.collections.ObservableList;

import java.util.*;
import java.util.stream.Collectors;

public class Room {
    private String name;
    private HashMap<String, Room> exits;
    private List<Item> items;

    public Room(String name)
    {
        this.name = name;
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
    public String getName()
    {
        return name;
    }

    public Set<String> getExitDirections()
    {
        return exits.keySet();
    }

    public List<Item> getItems()
    {
        return Collections.unmodifiableList(items);
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
        return "Exits: " + String.join(" ", exits.keySet());
    }

    public String getItemString()
    {
        if (items.size() != 0)
        {
            return "-Items: " + items.stream().map(Item::getName).collect(Collectors.joining(" "));
        }
        return "No items in this room";
    }

    public String getLongDescription()
    {
        return "[" + getName() + "]\n" + getExitString() + "\n" + getItemString();
    }
}
