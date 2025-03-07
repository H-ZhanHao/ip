package Eelyon.commands;

/**
 * Represents a task that has a deadline. Inherits from the Task class.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Constructs a Deadline task with a description and a deadline time.
     *
     * @param description The description of the task.
     * @param by The deadline time by which the task should be completed.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline time for the task.
     *
     * @return The deadline time as a string.
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns the string representation of the Deadline task.
     * This includes the task type indicator, status, description, and the deadline time.
     *
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
