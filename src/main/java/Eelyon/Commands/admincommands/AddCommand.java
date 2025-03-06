package Eelyon.commands.admincommands;

import Eelyon.commands.CommandType;
import Eelyon.commands.Task;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public class AddCommand extends Command {
    Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.addTask(task);
        Ui.printAddTask(task, taskList.getSize());

    }

}
