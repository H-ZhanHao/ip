import java.util.Scanner;


public class Eelyon {

    public static void main(String[] args) {
        boolean exit = false;
        String input;
        String[] list = new String[100];
        int listIndex = 0;
        Scanner in = new Scanner(System.in);

        String line = "____________________________________________________________\n";
        System.out.println(line + "Hello! I'm Eelyon\n" + "What can I do for you?\n" + line);

        while (!exit) {
            input = in.nextLine();
            if (input.equals("bye")) {
                exit = true;
            } else if (input.equals("list")) {
                System.out.println(line);
                for (int i = 0; i < listIndex; i++) {
                    System.out.println(i + 1 + ". " + list[i]);
                }
                System.out.println(line);
            } else {
                list[listIndex] = input;
                listIndex++;
                System.out.println(line + "added: " + input + "\n" + line);
            }
        }

        System.out.println(line + "Bye. Hope to see you soon!\n" + line);
    }


}

