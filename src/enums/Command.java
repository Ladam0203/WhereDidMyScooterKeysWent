package enums;

public enum Command {
    HELP("help"), QUIT("quit"), GO("go"), LOOK("look"),OBSERVE("observe");

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
