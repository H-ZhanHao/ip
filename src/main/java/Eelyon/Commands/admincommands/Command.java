package Eelyon.commands.admincommands;

import Eelyon.control.TaskList;
import Eelyon.control.Ui;

public abstract class Command {
    protected static TaskList taskList;
    protected Ui ui;
    protected Boolean exit = false;

    public Command() {
    }

    public Boolean isExit() {
        return exit;
    }
    public abstract void execute(TaskList taskList, Ui ui);
}
