package Eelyon.control;

import Eelyon.commands.Task;

/**
 * Represents the user interface for managing tasks.
 */
public class Ui {

    /**
     * Prints a line separator.
     */
    public static void printLine() {
        System.out.println("____________________________________________________________\n");
    }

    /**
     * Prints an error message.
     *
     * @param e The exception containing the error message.
     */
    public void printErrorMessage(Exception e) {
        Ui.printLine();
        System.out.println(e.getMessage());
        Ui.printLine();
    }

    /**
     * Prints the list of tasks.
     *
     * @param list The TaskList to print.
     */
    public static void printList(TaskList list) {
        Ui.printLine();
        if (list.getSize() <= 0) {
            System.out.println("List is empty");
        } else {
            list.printTasks();
        }
        Ui.printLine();
    }

    public static void printFoundTasks(TaskList list, String keyword) {
        Ui.printLine();
        System.out.println("Here are the tasks matching the keyword: " + keyword);
        if (list.getSize() <= 0) {
            System.out.println("No items found");
        } else {
            list.printTasks();
        }
        Ui.printLine();
    }

    /**
     * Prints a message after adding a task.
     *
     * @param task The task that was added.
     * @param size The size of the task list after adding.
     */
    public static void printAddTask(Task task, int size) {
        Ui.printLine();
        System.out.println("added: " + task.getDescription() + "\n");
        System.out.printf("You now have %d tasks in the list\n", size);
        Ui.printLine();
    }

    /**
     * Prints a message after removing a task.
     *
     * @param task The task that was removed.
     * @param size The size of the task list after removal.
     */
    public static void printRemoveTask(Task task, int size) {
        Ui.printLine();
        System.out.println("Noted. Removing this task:\n" + task);
        System.out.printf("Now you have %d tasks in the list.\n", size);
        Ui.printLine();
    }

    /**
     * Prints an error message for invalid index during task removal.
     */
    public static void printRemoveError() {
        Ui.printLine();
        System.out.println("Invalid index");
        Ui.printLine();
    }

    /**
     * Prints a message after marking a task as done.
     *
     * @param task The task that was marked as done.
     */
    public static void printMark(Task task) {
        Ui.printLine();
        System.out.println("Nice! I've marked this task as done:\n" + "[" + task.getStatusIcon() + "] " + task.getDescription());
        Ui.printLine();
    }

    /**
     * Prints a message after marking a task as not done.
     *
     * @param task The task that was marked as not done.
     */
    public static void printUnmark(Task task) {
        Ui.printLine();
        System.out.println("Ok, I've marked this task as not done yet:\n" + "[" + task.getStatusIcon() + "] " + task.getDescription());
        Ui.printLine();
    }

    /**
     * Prints an exit message.
     */
    public static void printExitMessage() {
        Ui.printLine();
        System.out.println("SEE YA LATER! COME BACK SOON!!!");
        Ui.printLine();
    }

    /**
     * Prints a welcome message.
     */
    public static void printWelcomeMessage() {
        Ui.printLine();
        System.out.println("Hello! I'm Eelyon\n" + "What can I do for you?\n");
        System.out.println(
               "      ▄▀▄     ▄▀▄\n" +
               "     ▄█░░▀▀▀▀▀░░█▄\n" +
               " ▄▄  █░░░░░░░░░░░█  ▄▄\n" +
               "█▄▄█ █░░▀░░┬░░▀░░█ █▄▄█\n");
        Ui.printLine();
    }
}
