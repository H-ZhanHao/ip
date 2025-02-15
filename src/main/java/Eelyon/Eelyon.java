package Eelyon;

import Eelyon.Commands.*;
import Eelyon.Exceptions.EmptyDescriptionException;
import Eelyon.Exceptions.InvalidFormatException;

import java.util.Scanner;


public class Eelyon {
    static final int NUMBER_OF_TASKS = 100;
    static Task[] list = new Task[NUMBER_OF_TASKS];
    static int listIndex = 0;
    static final String LINE = "____________________________________________________________\n";

    public static void printList() {
        System.out.println(LINE);
        if (listIndex == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < listIndex; i++) {
                int index = i + 1;
                System.out.print(index + ".");
                System.out.println(list[i]);
            }
        }
        System.out.println(LINE);
    }

    public static void setMarked(int index) {
        if (index >= listIndex || index < 0) {
            System.out.println(LINE);
            System.out.println("Invalid index");
            System.out.println(LINE);
            return;
        } else {
            list[index].setDone(true);
            System.out.println(LINE);
            System.out.println("Nice! I've marked this task as done:\n" + "[" + list[index].getStatusIcon() + "] " + list[index].getDescription());
            System.out.println(LINE);
        }
    }

    public static void setUnmarked(int index) {
        if (index >= listIndex || index < 0) {
            System.out.println(LINE);
            System.out.println("Invalid index");
            System.out.println(LINE);
        } else {
            list[index].setDone(false);
            System.out.println(LINE);
            System.out.println("Ok, I've marked this task as not done yet:\n" + "[" + list[index].getStatusIcon() + "] " + list[index].getDescription());
            System.out.println(LINE);
        }
    }

    public static void addTask(Task task) {
        list[listIndex] = task;
        System.out.println(LINE + "added: " + list[listIndex].getDescription() + "\n");
        listIndex++;
        System.out.printf("You now have %d tasks in the list\n", listIndex);
        System.out.println(LINE);
    }

    public static void checkDescription(CommandType commandType, String input) {
        if (commandType.getCommandType().equals("todo")) {
            if(input.substring(input.indexOf("todo") + "todo".length()).trim().length() <= 0) {
                throw new EmptyDescriptionException("No empty descriptions allowed dawg. Try again.");
            }
        } else if (input.substring(input.indexOf(commandType.getCommandType()) + commandType.getCommandType().length(), input.indexOf(commandType.getEndCommand())).trim().length() <= 0) {
            throw new EmptyDescriptionException("No empty descriptions allowed dawg. Try again.");
        }
    }

    public static void checkFormat(CommandType commandType, String input) {
        if (!input.contains(commandType.getEndCommand())) {
            throw new InvalidFormatException("Input is kinda sus. Try again.");
        }
    }

    public static CommandType inputCheck(String command, String input) {
        CommandType commandType = new CommandType();
        try {
            commandType.setCommandType(command); //Checks for valid command
            if (!commandType.getCommandType().equals("mark") && !commandType.getCommandType().equals("unmark") && !commandType.getCommandType().equals("list") && !commandType.getCommandType().equals("bye")) {
                checkFormat(commandType, input);
                checkDescription(commandType, input);
            }
        } catch (EmptyDescriptionException | InvalidFormatException | IllegalArgumentException error) {
            System.out.println(LINE);
            System.out.println(error.getMessage());
            System.out.println(LINE);
            commandType.setValid(false);
            return commandType;
        }
        commandType.setValid(true);
        return commandType;
    }

    public static void main(String[] args) {
        boolean isFinished = false;
        boolean isInputValid = false;
        String input;
        String[] separatedInput = new String[0];
        Scanner in = new Scanner(System.in);

        System.out.println(LINE + "Hello! I'm Eelyon\n" + "What can I do for you?\n" + LINE);

        while (!isFinished) {
            input = in.nextLine();
            separatedInput = input.trim().split(" ");
            CommandType commandType = null;
            try {
                commandType = inputCheck(separatedInput[0],input);
            } catch (IllegalArgumentException error) { //Check for valid command
                System.out.println(LINE);
                System.out.println(error.getMessage());
                System.out.println(LINE);
            }

            assert commandType != null;
            if (commandType.isValid()) {
                switch (separatedInput[0]) {
                case "mark":
                    setMarked(Integer.parseInt(separatedInput[1]) - 1);
                    break;
                case "unmark":
                    setUnmarked(Integer.parseInt(separatedInput[1]) - 1);
                    break;
                case "list":
                    printList();
                    break;
                case "bye":
                    isFinished = true;
                    break;
                case "deadline":
                    String deadlineTask = input.substring(input.indexOf("deadline") + "deadline".length(), input.indexOf("/by")).trim();
                    String by = input.substring(input.indexOf("by") + "by".length()).trim();
                    Deadline newDeadline = new Deadline(deadlineTask, by);
                    addTask(newDeadline);
                    break;
                case "event":
                    String eventTask = input.substring(input.indexOf("event") + "event".length(), input.indexOf("/from")).trim();
                    String from = input.substring(input.indexOf("from") + "from".length(), input.indexOf("/to")).trim();
                    String to = input.substring(input.indexOf("to") + "to".length()).trim();
                    Event newEvent = new Event(eventTask, from, to);
                    addTask(newEvent);
                    break;
                case "todo":
                    String todoTask = input.substring(input.indexOf("todo") + "todo".length()).trim();
                    Todo newTodo = new Todo(todoTask);
                    addTask(newTodo);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
                }
            }
        }
        System.out.println(LINE + "Bye. Hope to see you soon!\n" + LINE);
    }
}

