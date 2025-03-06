package Eelyon.commands.admincommands;

import Eelyon.commands.CommandType;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (index < 0 || index >= taskList.getSize()) {
            Ui.printRemoveError();
        } else {
            taskList.unmarkTask(index);
            Ui.printUnmark(taskList.get(index), index);
        }
    }
}
