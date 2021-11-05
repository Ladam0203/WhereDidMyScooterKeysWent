package enums;

public enum Command {
    //TODO: implement commands
    HELP("help"), QUIT("quit"), GO("go"), LOOK("look"),OBSERVE("observe"), TAKE("take"), DROP("drop"), INVENTORY("inventory"), CONSUME("consume"), BACK("back");

    private String commandWord;
    Command(String commandWord)
    {
        this.commandWord = commandWord;
    }

    @Override
    public String toString()
    {
        return commandWord;
    }
}
