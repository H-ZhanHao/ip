package Eelyon.commands;

public class CommandType {
    private String commandType;
    private boolean isValid = true;
    private final String[] COMMAND_LIST = new String[]{
            "deadline", "event", "todo", "mark", "unmark", "list", "delete", "bye", "find"
    };

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String inputCommandType) {
        for (String command : COMMAND_LIST) {
            if (command.equals(inputCommandType)) {
                this.commandType = inputCommandType;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid Command! Try again.");
    }

    public String getEndCommand() {
        switch (commandType) {
        case "deadline":
            return ("/by");
        case "event":
            return ("/from");
        case "todo":
            return ("");
        default:
            return (" ");
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
