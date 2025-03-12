package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to display all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Constructs a ListCommand.
     */
    public ListCommand() {
    }

    /**
     * Executes the list command by printing all tasks from the task list.
     *
     * @param taskList The task list whose tasks will be printed.
     * @param ui The UI instance to handle user interaction.
     */
    @Override
    public final void execute(TaskList taskList, Ui ui) {
        Ui.printList(taskList);
    }
}
