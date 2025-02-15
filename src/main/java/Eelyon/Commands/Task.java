package Eelyon.Commands;

import Eelyon.Exceptions.EmptyDescriptionException;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new EmptyDescriptionException("HEY! DESCRIPTION IS EMPTY!");
        } else {
            this.description = description;
            this.isDone = false;
        }
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
