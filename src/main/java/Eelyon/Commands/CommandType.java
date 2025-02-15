package Eelyon.Commands;

public class CommandType {
    private String commandType;
    private boolean isValid;

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        switch(commandType) {
        case "deadline":
        case "event":
        case "todo":
        case "mark":
        case "unmark":
        case "list":
        case "bye": this.commandType = commandType; break;
        default: throw new IllegalArgumentException("Invalid Command! Try again.");
        }
    }

    public String getEndCommand() {
        switch (commandType) {
        case "deadline":
            return("/by");
        case "event":
            return("/from");
        case "todo":
            return("");
        default: return (" ");
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
