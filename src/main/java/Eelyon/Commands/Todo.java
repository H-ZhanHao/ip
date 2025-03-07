package Eelyon.commands;

/**
 * Represents a to-do task. Inherits from the Task class.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task with a description
     *
     * @param description The description of the to-do task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of the Todo task.
     * This includes the task type indicator and the task's status and description.
     *
     * @return The string representation of the to-do task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
