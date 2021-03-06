package bll;

import be.Player;
import enums.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* Respinsible for accepting and checking user input and passing it to the engine, also displays data that can be done without the engine */
public class Parser {
    private GameEngine engine;
    private Map<String,UserRequest> behaviours;

    public Parser(Player player)
    {
        engine = new GameEngine(player);
        behaviours = new HashMap<>();
        initRequests();
    }

    public void initRequests()
    {
        // define the engine callback and assumes the arguments are real, if not, "Unknown command" error is thrown.
        UserRequest help = new UserRequest(Command.HELP,0) {
            @Override
            public String callback(String[] args) {
                return "I don't blame you, Adam also tends to forget things. Your commands are:\n" + behaviours.keySet().stream().map(command -> command.toString()).collect(Collectors.joining(" "));
            }
        };
        behaviours.put(help.getCommandWord(), help);

        UserRequest quit = new UserRequest(Command.QUIT, 0) {
            @Override
            public String callback(String[] args) { //THIS IS BAD
                return "Thanks for playing!";
            }
        };
        behaviours.put(quit.getCommandWord(), quit);

        UserRequest go = new UserRequest(Command.GO, 1) {
            @Override
            public String callback(String[] args) {
                if (args[1] == null)
                    return "Go where?";
                return engine.go(args[1]);
            };
        };
        behaviours.put(go.getCommandWord(), go);

        UserRequest look = new UserRequest(Command.LOOK, 0) {
            @Override
            public String callback(String[] args) {
                return engine.look();
            }
        };
        behaviours.put(look.getCommandWord(), look);

        UserRequest observe = new UserRequest(Command.OBSERVE, 1) {
            @Override
            public String callback(String[] args) {
            if (args[1] == null)
                return "Observe what?";
            return engine.observe(args[1]);
            }
        };
        behaviours.put(observe.getCommandWord(), observe);

        UserRequest take = new UserRequest(Command.TAKE, 1) {
            @Override
            public String callback(String[] args) {
                if (args[1] == null)
                    return "Take what?";
                return engine.take(args[1]);
                }
            };
        behaviours.put(take.getCommandWord(), take);

        UserRequest drop = new UserRequest(Command.DROP, 1) {
            @Override
            public String callback(String[] args) {
                if (args[1] == null)
                    return "Drop what?";
                return engine.drop(args[1]);
            }
        };
        behaviours.put(drop.getCommandWord(),drop);

        UserRequest inventory = new UserRequest(Command.INVENTORY, 0) {
            @Override
            public String callback(String[] args) {
                return engine.inventory();
            }
        };
        behaviours.put(inventory.getCommandWord(), inventory);
    }


    public UserRequest getBehaviour(String commandWord)
    {
        return behaviours.get(commandWord);
    }
}
