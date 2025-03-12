package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

/**
 * Represents a command to exit the application.
 */
public class ExitCommand extends Command {

    /**
     * Constructs an ExitCommand.
     */
    public ExitCommand() {
    }

    /**
     * Executes the exit command by setting the exit flag to true
     * and displaying an exit message.
     *
     * @param taskList The task list (not used in this command).
     * @param ui The UI instance to handle user interaction.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        exit = true;
        Ui.printExitMessage();
    }
}
