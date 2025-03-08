package Eelyon.control;

import Eelyon.commands.*;
import Eelyon.commands.admincommands.*;
import Eelyon.exceptions.EmptyDescriptionException;
import Eelyon.exceptions.InvalidFormatException;

/**
 * Parses user input and converts it into executable commands.
 */
public class Parser {
    private Ui ui = new Ui();

    /**
     * Parses the user input command and returns the corresponding command object.
     *
     * @param fullCommand The full command input by the user.
     * @return A {@code Command} object corresponding to the parsed input.
     */
    public Command parse(String fullCommand) {
        String command = fullCommand.split(" ")[0];
        CommandType commandType = new CommandType();

        try {
            commandType.setCommandType(command);
            if (commandType.getCommandType().equals("todo") | commandType.getCommandType().equals("deadline") | commandType.getCommandType().equals("event")) {
                checkFormat(commandType, fullCommand);
                checkDescription(commandType, fullCommand);
            }
        } catch (Exception e) {
            ui.printErrorMessage(e);
            commandType.setValid(false);
        }


        if (commandType.isValid()) {
            switch (commandType.getCommandType()) {
            case "todo":
                String todoDescription = fullCommand.substring(fullCommand.indexOf("todo") + "todo".length()).trim();
                return new AddCommand(new Todo(todoDescription));
            case "deadline":
                String deadlineDescription = fullCommand.substring(fullCommand.indexOf("deadline") + "deadline".length(), fullCommand.indexOf("/by")).trim();
                String by = fullCommand.substring(fullCommand.indexOf("/by") + "/by".length()).trim();
                return new AddCommand(new Deadline(deadlineDescription, by));
            case "event":
                String eventDescription = fullCommand.substring(fullCommand.indexOf("event") + "event".length(), fullCommand.indexOf("/from")).trim();
                String from = fullCommand.substring(fullCommand.indexOf("/from") + "/from".length(), fullCommand.indexOf("/to")).trim();
                String to = fullCommand.substring(fullCommand.indexOf("/to") + "/to".length()).trim();
                return new AddCommand(new Event(eventDescription, from, to));
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(Integer.parseInt(fullCommand.split(" ")[1]) - 1);
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(fullCommand.split(" ")[1]) - 1);
            case "delete":
                return new DeleteCommand(Integer.parseInt(fullCommand.split(" ")[1]) - 1);
            case "bye":
                return new ExitCommand();
            case "find":
                String keyword = fullCommand.substring(fullCommand.indexOf("find") + "find".length()).trim();
                return new FindCommand(keyword);
            default:
                return null;
            }
        }

        return new NullCommand();
    }


    private static void checkDescription(CommandType commandType, String input) {
        if (commandType.getCommandType().equals("todo")) {
            if (input.substring(input.indexOf("todo") + "todo".length()).trim().isEmpty()) {
                throw new EmptyDescriptionException("No empty descriptions allowed dawg. Try again.");
            }
        } else if (input.substring(input.indexOf(commandType.getCommandType()) + commandType.getCommandType().length(), input.indexOf(commandType.getEndCommand())).trim().isEmpty()) {
            throw new EmptyDescriptionException("No empty descriptions allowed dawg. Try again.");
        }
    }

    private static void checkFormat(CommandType commandType, String input) {
        if (!input.contains(commandType.getEndCommand())) {
            throw new InvalidFormatException("Input is kinda sus. Try again.");
        }
    }

    /**
     * Decodes a task from storage
     *
     * @param line The string containing task data from storage.
     * @return A Task object reconstructed from the stored data.
     * @throws IllegalArgumentException If the task format is invalid.
     */
    public static Task decodeStorageData(String line) throws IllegalArgumentException {
        String[] parts = line.split(" ");

        String commandType = "";
        String description = "";
        boolean isDone = false;
        String by = "";
        String from = "";
        String to = "";

        commandType = line.substring(line.indexOf("CommandType: ") + "CommandType: ".length(), line.indexOf("Description:")).trim();
        description = line.substring(line.indexOf("Description: ") + "Description: ".length(), line.indexOf("Done:")).trim();
        isDone = line.substring(line.indexOf("Done: ")).contains("true");

        Task task = null;
        switch (commandType) {
        case "T":
            task = new Todo(description);
            break;
        case "D":
            by = line.substring(line.indexOf("By: ") + "By: ".length());
            task = new Deadline(description, by);
            break;
        case "E":
            from = line.substring(line.indexOf("From: ") + "From: ".length(), line.indexOf("To:"));
            to = line.substring(line.indexOf("To: ") + "To: ".length());
            task = new Event(description, from, to);
            break;
        default:
            throw new IllegalArgumentException("Unknown command type: " + commandType);
        }

        task.setDone(isDone);
        return task;
    }
}
