package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to unmark a task as not completed in the task list.
 */
public class UnmarkCommand extends Command {
    private int index;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param index The index of the task to be unmarked (0-based).
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the unmark command by unmarking the task at the specified index
     * as not completed. If the index is invalid, an error message is displayed.
     *
     * @param taskList The task list containing the task to be unmarked.
     * @param ui The UI instance to handle user interaction.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (index < 0 || index >= taskList.getSize()) {
            Ui.printRemoveError();
        } else {
            taskList.unmarkTask(index);
            Ui.printUnmark(taskList.get(index));
        }
    }
}
