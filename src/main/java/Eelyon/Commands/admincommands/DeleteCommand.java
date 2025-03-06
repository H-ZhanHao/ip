package Eelyon.commands.admincommands;

import Eelyon.commands.CommandType;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (index < 0 || index > taskList.getSize()) {
            Ui.printRemoveError();
        } else {
            Ui.printRemoveTask(taskList.get(index), taskList.getSize() - 1);
            taskList.removeTask(index);
        }
    }
}
