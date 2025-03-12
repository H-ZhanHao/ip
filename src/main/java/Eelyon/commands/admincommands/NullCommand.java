package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command that does nothing.
 * This is used as a fallback when an invalid command is encountered.
 */
public class NullCommand extends Command {

    /**
     * Constructs a NullCommand.
     * This command does not perform any action when executed.
     */
    public NullCommand() {
    }

    /**
     * Executes the null command, which does nothing.
     *
     * @param taskList The task list (not used in this command).
     * @param ui The UI instance to handle user interaction (not used in this command).
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        // No operation is performed in this command
    }
}
