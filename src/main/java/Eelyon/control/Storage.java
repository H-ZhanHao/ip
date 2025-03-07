package Eelyon.control;

import Eelyon.commands.Deadline;
import Eelyon.commands.Event;
import Eelyon.commands.Task;
import Eelyon.commands.Todo;
import Eelyon.commands.admincommands.LoadDataCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles file storage for saving and loading tasks.
 */
public class Storage {
    private static String filePath = "";
    static File file;

    /**
     * Constructs a Storage instance and initializes the file path.
     *
     * @param filePath The path of the file to store tasks.
     */
    public Storage(String filePath) {
        Storage.filePath = filePath;
        file = new File(filePath);
    }

    /**
     * Creates a save file if it does not exist and loads data if it does.
     *
     * @param taskList The task list to load tasks into.
     * @param ui       The user interface instance for displaying messages.
     * @throws IOException If an error occurs while creating the file.
     */
    public static void createFile(TaskList taskList, Ui ui) throws IOException {
        File file = new File(filePath);

        if (file.getParentFile().mkdirs()) {
            System.out.println("Directory created");
        }

        if (file.createNewFile()) {
            System.out.println("Save File Created Successfully");
        } else {
            System.out.println("Save file already exists. Loading from file.");
            try {
                Storage.loadData(taskList, ui);
            } catch (FileNotFoundException e) {
                ui.printErrorMessage(e);
            }
        }
        Ui.printLine();
    }

    /**
     * Loads task data from the storage file into the task list.
     *
     * @param taskList The task list to populate with loaded data.
     * @param ui       The user interface instance for displaying messages.
     * @throws FileNotFoundException If the file cannot be found.
     */
    public static void loadData(TaskList taskList, Ui ui) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Task task = null;
            try {
                task = Parser.decodeStorageData(line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            new LoadDataCommand(task).execute(taskList, ui);
        }
        scanner.close();
    }

    /**
     * Updates the storage file with the current tasks in the task list.
     *
     * @param list The task list containing the tasks to be saved.
     * @throws IOException If an error occurs while writing to the file.
     */
    public static void updateFile(TaskList list) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        String commandType = "";
        StringBuilder fileInput = new StringBuilder();
        ArrayList<Task> tasks = list.getList();

        for (Task task : tasks) {
            if (task instanceof Event) {
                commandType = "E";
                fileInput.append("CommandType: ").append(commandType)
                        .append(" Description: ").append(task.getDescription())
                        .append(" Done: ").append(task.isDone())
                        .append(" From: ").append(((Event) task).getFrom())
                        .append(" To: ").append(((Event) task).getTo())
                        .append("\n");
            } else if (task instanceof Todo) {
                commandType = "T";
                fileInput.append("CommandType: ").append(commandType)
                        .append(" Description: ").append(task.getDescription())
                        .append(" Done: ").append(task.isDone())
                        .append("\n");
            } else if (task instanceof Deadline) {
                commandType = "D";
                fileInput.append("CommandType: ").append(commandType)
                        .append(" Description: ").append(task.getDescription())
                        .append(" Done: ").append(task.isDone())
                        .append(" By: ").append(((Deadline) task).getBy())
                        .append("\n");
            }
        }
        fileWriter.write(fileInput.toString());
        fileWriter.close();
    }
}
