package be;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Player {
    private Room currentRoom;
    private Stack<Room> path;
    private List<Item> inventory;
    private double inventoryCapacity = 10;

    public Player()
    {
        this.path = new Stack<>();
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public double getInventoryCapacity()
    {
        return inventoryCapacity;
    }

    public Stack<Room> getPath() {
        return path;
    }

    public Item getItem(String name)
    {
        return inventory.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);
    }

    public void addItem(Item item)
    {
        inventory.add(item);
    }

    public void removeItem(Item item)
    {
        inventory.remove(item);
    }

    public double getInventoryWeight()
    {
        return inventory.stream().mapToDouble(Item::getWeight).sum();
    }

    public double getInventorySpace()
    {
        return inventoryCapacity - inventory.stream().mapToDouble(Item::getWeight).sum();
    }

    public void addToPath(Room room)
    {
        path.add(room);
    }

    public List<Item> getInventory()
    {
        return Collections.unmodifiableList(inventory);
    }
}
