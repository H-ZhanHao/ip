package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to mark a task as completed in the task list.
 */
public class MarkCommand extends Command {
    private int index;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param index The index of the task to be marked as completed (0-based).
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the mark command by marking the task at the specified index
     * as completed. If the index is invalid, an error message is displayed.
     *
     * @param taskList The task list containing the task to be marked.
     * @param ui The UI instance to handle user interaction.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (index < 0 || index >= taskList.getSize()) {
            Ui.printRemoveError();
        } else {
            taskList.markTask(index);
            Ui.printMark(taskList.get(index));
        }
    }
}
