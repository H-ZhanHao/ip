package Eelyon.commands.task;

import Eelyon.exceptions.EmptyDescriptionException;

/**
 * Represents a task with a description and a completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description.
     *
     * @param description The description of the task.
     * @throws EmptyDescriptionException If the description is empty or null.
     */
    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new EmptyDescriptionException("HEY! DESCRIPTION IS EMPTY!");
        } else {
            this.description = description;
            this.isDone = false;
        }
    }

    /**
     * Returns the status icon of the task.
     * "X" if the task is done, otherwise a space.
     *
     * @return A string representing the status of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string containing the status icon and description.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if the task is done, false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Sets the completion status of the task.
     *
     * @param done true to mark the task as done, false otherwise.
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a new description for the task.
     *
     * @param description The new task description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
