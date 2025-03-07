package Eelyon.commands.admincommands;

import Eelyon.commands.Task;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to load a task into the task list.
 * This is used for loading tasks from a saved text file
 */
public class LoadDataCommand extends Command {
    private Task task;

    /**
     * Constructs a LoadDataCommand with the specified task.
     *
     * @param task The task to be loaded into the task list.
     */
    public LoadDataCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the load data command by adding the task to the task list.
     * Similar to AddCommand, but does not output anything to the console
     *
     * @param taskList The task list to which the task will be added.
     * @param ui The UI instance to handle user interaction (not used in this command).
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.addTask(task);
    }
}
