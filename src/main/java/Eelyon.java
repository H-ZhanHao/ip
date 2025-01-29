import java.util.Scanner;


public class Eelyon {
    static Task[] list = new Task[100];
    static int listIndex = 0;
    static final String LINE = "____________________________________________________________\n";

    public static void printList() {
        System.out.println(LINE);
        if (listIndex == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < listIndex; i++) {
                System.out.println(i + 1 + "." + "[" + list[i].getStatusIcon() + "] " + list[i].description);
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
            list[index].isDone = true;
            System.out.println(LINE);
            System.out.println("Nice! I've marked this task as done:\n" + "[" + list[index].getStatusIcon() + "] " + list[index].description);
            System.out.println(LINE);
        }
    }

    public static void setUnmarked(int index) {
        if (index >= listIndex || index < 0) {
            System.out.println(LINE);
            System.out.println("Invalid index");
            System.out.println(LINE);
        } else {
            list[index].isDone = false;
            System.out.println(LINE);
            System.out.println("Ok, I've marked this task as not done yet:\n" + "[" + list[index].getStatusIcon() + "] " + list[index].description);
            System.out.println(LINE);
        }
    }

    public static void addTask(String task) {
        list[listIndex] = new Task(task);
        System.out.println(LINE + "added: " + list[listIndex].description + "\n" + LINE);
        listIndex++;
    }

    public static void main(String[] args) {
        boolean isFinished = false;
        String input;
        String[] seperatedInput;
        Scanner in = new Scanner(System.in);

        System.out.println(LINE + "Hello! I'm Eelyon\n" + "What can I do for you?\n" + LINE);

        while (!isFinished) {
            input = in.nextLine();
            seperatedInput = input.trim().split(" ");

            switch (seperatedInput[0]) {
            case "mark":
                setMarked(Integer.parseInt(seperatedInput[1]) - 1);
                break;
            case "unmark":
                setUnmarked(Integer.parseInt(seperatedInput[1]) - 1);
                break;
            case "list":
                printList();
                break;
            case "bye":
                isFinished = true;
                break;
            default:
                addTask(input);
                break;
            }
        }
        System.out.println(LINE + "Bye. Hope to see you soon!\n" + LINE);
    }


}

