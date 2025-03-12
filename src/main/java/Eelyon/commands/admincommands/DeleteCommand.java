package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param index The index of the task to be deleted (0-based).
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the delete command by removing the task at the specified index
     * from the task list. If the index is invalid, an error message is displayed.
     *
     * @param taskList The task list from which the task will be removed.
     * @param ui The UI instance to handle user interaction.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (index < 0 || index >= taskList.getSize()) {
            Ui.printRemoveError();
        } else {
            Ui.printRemoveTask(taskList.get(index), taskList.getSize() - 1);
            taskList.removeTask(index);
        }
    }
}
