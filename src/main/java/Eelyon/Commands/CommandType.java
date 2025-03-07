package Eelyon.commands;

/**
 * Represents the type of a command. It validates and processes the command type
 * based on the user input and manages valid command types.
 */
public class CommandType {
    private String commandType;
    private boolean isValid = true;
    private final String[] COMMAND_LIST = new String[]{
            "deadline", "event", "todo", "mark", "unmark", "list", "delete", "bye", "find"
    };

    /**
     * Returns the current command type.
     *
     * @return The command type as a string.
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * Sets the command type based on the input. If the input command is invalid,
     * an exception is thrown.
     *
     * @param inputCommandType The input command type to be validated and set.
     * @throws IllegalArgumentException if the input command is not in the list of valid commands.
     */
    public void setCommandType(String inputCommandType) {
        for (String command : COMMAND_LIST) {
            if (command.equals(inputCommandType)) {
                this.commandType = inputCommandType;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid Command! Try again.");
    }

    /**
     * Returns the end command string that corresponds to the given command type.
     *
     * @return The end command string for the given command type.
     */
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

    /**
     * Checks if the current command is valid.
     *
     * @return true if the command is valid, false otherwise.
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Sets the validity status of the current command.
     *
     * @param valid The validity status to be set for the command.
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }
}
