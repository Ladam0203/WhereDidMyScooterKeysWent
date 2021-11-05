package be;

public class Item {
    protected String name;
    protected String description;
    protected double weight;
    protected boolean canBePickedUp;

    public Item(String name, String description, double weight, boolean canBePickedUp)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.canBePickedUp = canBePickedUp;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public boolean canBePickedUp()
    {
        return canBePickedUp;
    }

    public String getLongDescription()
    {
        return getName() + " : " + getDescription() + " (" + getWeight() + "kg)";
    }
}
