package Eelyon;

import Eelyon.Commands.*;
import Eelyon.Exceptions.EmptyDescriptionException;
import Eelyon.Exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Eelyon {
    static final int NUMBER_OF_TASKS = 100;
    static ArrayList<Task> list = new ArrayList<>();
    static int listIndex = 0;
    static final String LINE = "____________________________________________________________\n";
    static final String FILE_PATH = "src/main/java/Eelyon/data/data.txt";

    public static void printList() {
        System.out.println(LINE);
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Task task : list) {
                System.out.print(list.indexOf(task) + 1 + ".");
                System.out.println(task);
            }
        }
        System.out.println(LINE);
    }

    public static void setMarked(int index) {
        if (index >= list.size() || index < 0) {
            System.out.println(LINE);
            System.out.println("Invalid index");
            System.out.println(LINE);
            return;
        } else {
            list.get(index).setDone(true);
            System.out.println(LINE);
            System.out.println("Nice! I've marked this task as done:\n" + "[" + list.get(index).getStatusIcon() + "] " + list.get(index).getDescription());
            System.out.println(LINE);
        }
    }

    public static void setUnmarked(int index) {
        if (index >= list.size() || index < 0) {
            System.out.println(LINE);
            System.out.println("Invalid index");
            System.out.println(LINE);
        } else {
            list.get(index).setDone(false);
            System.out.println(LINE);
            System.out.println("Ok, I've marked this task as not done yet:\n" + "[" + list.get(index).getStatusIcon() + "] " + list.get(index).getDescription());
            System.out.println(LINE);
        }
    }

    public static void deleteTask(int index) {
        if (index >= list.size() || index < 0) {
            System.out.println(LINE);
            System.out.println("Invalid index");
            System.out.println(LINE);
        } else {
            System.out.println(LINE);
            System.out.println("Noted. Removing this task:\n" + list.get(index));
            list.remove(index);
            System.out.printf("Now you have %d tasks in the list:\n", list.size());
            System.out.println(LINE);
        }
    }

    public static void addTask(Task task) {
        list.add(task);
        System.out.println(LINE + "added: " + task.getDescription() + "\n");
        System.out.printf("You now have %d tasks in the list\n", list.size());
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
            if (!commandType.getCommandType().equals("mark") && !commandType.getCommandType().equals("delete") && !commandType.getCommandType().equals("unmark") && !commandType.getCommandType().equals("list") && !commandType.getCommandType().equals("bye")) {
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

    public static void updateFile() throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        String commandType = "";
        StringBuilder fileInput = new StringBuilder();

        for (Task task : list) {
            if (task instanceof Event) {
                commandType = "E";
                fileInput.append("CommandType: ").append(commandType).append(" ").append("Description: ").append(task.getDescription()).append(" ").append("Done: ").append(task.isDone()).append(" ").append("From: ").append(((Event) task).getFrom()).append(" ").append("To: ").append(((Event) task).getTo()).append("\n");
            } else if (task instanceof Todo) {
                commandType = "T";
                fileInput.append("CommandType: ").append(commandType).append(" ").append("Description: ").append(task.getDescription()).append(" ").append("Done: ").append(task.isDone()).append("\n");
            } else if (task instanceof Deadline) {
                commandType = "D";
                fileInput.append("CommandType: ").append(commandType).append(" ").append("Description: ").append(task.getDescription()).append(" ").append("Done: ").append(task.isDone()).append(" ").append("By: ").append(((Deadline) task).getBy()).append("\n");
            }
        }
        fileWriter.write(fileInput.toString());
        fileWriter.close();
    }

    public static Task createTaskFromLine(String line) throws IllegalArgumentException {
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
            from = line.substring(line.indexOf("From: ") + "From: ".length(), line.indexOf("To:") );
            to = line.substring(line.indexOf("To: ") + "To: ".length());
            task = new Event(description, from, to);
            break;
        default:
            throw new IllegalArgumentException("Unknown command type: " + commandType);
        }

        task.setDone(isDone);
        return task;
    }


    public static void loadFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Task task = null;
            try {
                task = createTaskFromLine(line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            list.add(task);
        }

        scanner.close();
    }



    public static void main(String[] args) {
        boolean isFinished = false;
        boolean isInputValid = false;
        String input;
        String[] separatedInput = new String[0];
        Scanner in = new Scanner(System.in);

        System.out.println(LINE + "Hello! I'm Eelyon\n" + "What can I do for you?\n" + LINE);

        try {

            File f = new File(FILE_PATH);
            if (f.createNewFile()) {
                System.out.println("Save File Created Successfully");
            } else {
                System.out.println("Save file already exists. Loading from file...");
                try {
                    loadFile(f);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(LINE);
        } catch (IOException e) {
            System.out.println(LINE);
            System.out.println("An error occurred while creating the file.");
            System.out.println(e.getMessage());
            System.out.println(LINE);
        }

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

                try {
                    updateFile();
                } catch (IOException e) {
                    System.out.println(LINE);
                    System.out.println("File didn't update properly");
                    System.out.println(e.getMessage());
                    System.out.println(LINE);
                }
            }
        }
        System.out.println(LINE + "Bye. Hope to see you soon!\n" + LINE);
    }
}

