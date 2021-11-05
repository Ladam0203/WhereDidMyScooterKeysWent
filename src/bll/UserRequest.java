package bll;

import enums.Command;

public abstract class UserRequest {
    protected Command command;
    protected int numArgs;

    public UserRequest(Command command, int numArgs) {
        this.command= command;
        this.numArgs= numArgs;
    }

    public String getCommandWord() {
        return command.toString();
    }

    public abstract String callback(String[] args);
}
