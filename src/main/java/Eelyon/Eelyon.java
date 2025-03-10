package Eelyon;

import Eelyon.commands.admincommands.Command;
import Eelyon.control.Parser;
import Eelyon.control.Storage;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

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

            Command c = parser.parse(input);
            c.execute(taskList, ui);
            isFinished = c.isExit();

            try {
                Storage.updateFile(taskList);
            } catch (IOException e) {
                ui.printErrorMessage(e);
            }
        }

    }
}

