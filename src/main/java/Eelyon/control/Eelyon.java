package Eelyon.control;

import Eelyon.commands.admincommands.Command;

import java.io.IOException;
import java.util.Scanner;


public class Eelyon {
    static final String FILE_PATH = "src/main/java/Eelyon/data/data.txt";

    public static void main(String[] args) {
        boolean isFinished = false;
        String input;
        Scanner in = new Scanner(System.in);
        TaskList taskList = new TaskList();
        Ui ui = new Ui();
        Parser parser = new Parser();
        Storage storage = new Storage(FILE_PATH);

        Ui.printWelcomeMessage();

        try {
            Storage.createFile(taskList, ui);
        } catch (IOException e) {
            ui.printErrorMessage(e);
        }

        while (!isFinished) {
            input = in.nextLine();

            Command centralCommand = parser.parse(input);
            centralCommand.execute(taskList, ui);
            isFinished = centralCommand.isExit();

            try {
                Storage.updateFile(taskList);
            } catch (IOException e) {
                ui.printErrorMessage(e);
            }
        }

    }
}

