package Eelyon.commands.admincommands;

import Eelyon.commands.Task;
import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to add a task to the task list.
 */
public class AddCommand extends Command {
    private Task task;

    /**
     * Constructs an AddCommand with the specified task.
     *
     * @param task The task to be added.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the add command by adding the task to the task list and
     * displaying a confirmation message.
     *
     * @param taskList The task list to add the task to.
     * @param ui The UI instance to handle user interaction.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.addTask(task);
        Ui.printAddTask(task, taskList.getSize());
    }
}
