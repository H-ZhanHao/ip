package Eelyon.control;

import Eelyon.commands.Task;

public class Ui {

    public static void printLine() {
        System.out.println("____________________________________________________________\n");
    }

    public void printErrorMessage(Exception e) {
        Ui.printLine();
        System.out.println(e.getMessage());
        Ui.printLine();
    }

    public static void printList(TaskList list) {
        Ui.printLine();
        if (list.getSize() <= 0) {
            System.out.println("List is empty");
        } else {
            list.printTasks();
        }
        Ui.printLine();
    }

    public static void printAddTask(Task task, int size) {
        Ui.printLine();
        System.out.println("added: " + task.getDescription() + "\n");
        System.out.printf("You now have %d tasks in the list\n", size);
        Ui.printLine();
    }

    public static void printRemoveTask(Task task, int size) {
        Ui.printLine();
        System.out.println("Noted. Removing this task:\n" + task);
        System.out.printf("Now you have %d tasks in the list.\n", size);
        Ui.printLine();
    }

    public static void printRemoveError() {
        Ui.printLine();
        System.out.println("Invalid index");
        Ui.printLine();
    }

    public static void printMark(Task task, int index) {
        Ui.printLine();
        System.out.println("Nice! I've marked this task as done:\n" + "[" + task.getStatusIcon() + "] " + task.getDescription());
        Ui.printLine();
    }

    public static void printUnmark(Task task, int index) {
        Ui.printLine();
        System.out.println("Ok, I've marked this task as not done yet:\n" + "[" + task.getStatusIcon() + "] " + task.getDescription());
        Ui.printLine();
    }

    public static void printExitMessage() {
        Ui.printLine();
        System.out.println("SEE YA LATER! COME BACK SOON!!!");
        Ui.printLine();
    }

    public static void printWelcomeMessage() {
        Ui.printLine();
        System.out.println("Hello! I'm Eelyon\n" + "What can I do for you?\n");
        Ui.printLine();
    }
}
