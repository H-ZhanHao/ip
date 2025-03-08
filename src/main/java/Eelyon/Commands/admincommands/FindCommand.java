package Eelyon.commands.admincommands;

import Eelyon.commands.Task;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

import java.util.ArrayList;

/**
 * Represents a command to find tasks containing a specific keyword.
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Constructs a FindCommand with the specified keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching for tasks that contain the keyword.
     * It then prints the list of matching tasks.
     *
     * @param taskList The list of tasks to search within.
     * @param ui       The user interface to handle output.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        ArrayList<Task> list = taskList.getList();
        TaskList requestedTasks = new TaskList();

        for (Task task : list) {
            if (task.getDescription().contains(keyword)) {
                requestedTasks.addTask(task);
            }
        }

        Ui.printFoundTasks(requestedTasks, keyword);
    }
}
