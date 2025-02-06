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

    public static void addTask(Task task) {
        list[listIndex] = task;
        System.out.println(LINE + "added: " + list[listIndex].description + "\n");
        listIndex++;
        System.out.printf("You now have %d tasks in the list\n", listIndex);
        System.out.println(LINE);
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
            case "deadline":
                String deadlineTask = input.substring(input.indexOf("deadline") + "deadline".length(), input.indexOf("/by")).trim();
                String by = input.substring(input.indexOf("by") + "by".length()).trim();
                Deadline newDeadline = new Deadline(deadlineTask,by);
                addTask(newDeadline);
                break;
            case "event":
                String eventTask = input.substring(input.indexOf("event") + "event".length(), input.indexOf("/from")).trim();
                String from = input.substring(input.indexOf("from") + "from".length(), input.indexOf("/to")).trim();
                String to = input.substring(input.indexOf("to") + "to".length()).trim();
                Event newEvent = new Event(eventTask,from,to);
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
        System.out.println(LINE + "Bye. Hope to see you soon!\n" + LINE);
    }


}

