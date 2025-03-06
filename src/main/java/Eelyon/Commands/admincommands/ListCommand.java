package Eelyon.commands.admincommands;

import Eelyon.commands.CommandType;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public class ListCommand extends Command {


    public ListCommand() {
    }

    @Override
    public final void execute(TaskList taskList, Ui ui) {
        Ui.printList(taskList);
    }
}
