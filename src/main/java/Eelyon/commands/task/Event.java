package Eelyon.commands.task;

/**
 * Represents an event task with a start and end time. Inherits from the Task class.
 */
public class Event extends Task {

    private String from;
    private String to;

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description The description of the event task.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start time of the event.
     *
     * @return The start time of the event.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the end time of the event.
     *
     * @return The end time of the event.
     */
    public String getTo() {
        return to;
    }

    /**
     * Returns the string representation of the Event task.
     * This includes the task type indicator, status, description, start time, and end time.
     *
     * @return The string representation of the event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + " to: " + to + ")";
    }
}
