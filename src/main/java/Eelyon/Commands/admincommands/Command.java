package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents an abstract command that can be executed within the task management system.
 */
public abstract class Command {
    protected static TaskList taskList;
    protected Ui ui;
    protected Boolean exit = false;

    /**
     * Checks if the command signals an exit from the application.
     *
     * @return true if the command exits the application, false otherwise.
     */
    public Boolean isExit() {
        return exit;
    }

    /**
     * Executes the command with the given task list and UI.
     *
     * @param taskList The task list on which the command operates.
     * @param ui The UI instance to handle user interaction.
     */
    public abstract void execute(TaskList taskList, Ui ui);
}
