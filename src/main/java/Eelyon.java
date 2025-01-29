import java.util.Scanner;


public class Eelyon {
    public static void main(String[] args) {
        boolean exit = false;
        String input;
        Scanner in = new Scanner(System.in);

        String line = "____________________________________________________________\n";
        System.out.println(line + "Hello! I'm Eelyon\n" + "What can I do for you?\n" + line);

        while (!exit) {
            input = in.nextLine();
            if (input.equals("bye")) {
                exit = true;
            } else {
                System.out.println(line + input + "\nlist" + line);
            }
        }

        System.out.println(line + "Bye. Hope to see you soon!\n" + line);
    }


}

