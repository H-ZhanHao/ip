package Eelyon.commands.admincommands;

import Eelyon.commands.Task;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    String keyword = "";

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }



    @Override
    public void execute(TaskList taskList, Ui ui) {
        ArrayList<Task> list = taskList.getList();
        TaskList requestedTasks = new TaskList();

        for (Task task : list) {
            if (task.getDescription().contains(keyword)) {
                requestedTasks.addTask(task);
            }
        }
        Ui.printFoundTasks(requestedTasks,keyword);
    }
}
