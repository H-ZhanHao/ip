package Eelyon.commands.admincommands;

import Eelyon.commands.CommandType;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (index < 0 || index >= taskList.getSize()) {
            Ui.printRemoveError();
        } else {
            taskList.markTask(index);
            Ui.printMark(taskList.get(index), index);
        }
    }
}
