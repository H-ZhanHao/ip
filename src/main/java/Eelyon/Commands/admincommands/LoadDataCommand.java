package Eelyon.commands.admincommands;

import Eelyon.commands.Task;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public class LoadDataCommand extends Command{
    Task task;

    public LoadDataCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.addTask(task);
    }
}
