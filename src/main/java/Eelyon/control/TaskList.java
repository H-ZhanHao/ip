package Eelyon.control;

import Eelyon.commands.Task;

import java.util.ArrayList;

/**
 * Represents a list of tasks and provides methods to manipulate them.
 */
public class TaskList {
    static ArrayList<Task> list = new ArrayList<>();

    /**
     * Adds a task to the list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        list.add(task);
    }

    /**
     * Removes a specified task from the list.
     *
     * @param task The task to be removed.
     */
    public void removeTask(Task task) {
        list.remove(task);
    }

    /**
     * Removes a task from the list by its index.
     *
     * @param index The index of the task to be removed.
     */
    public void removeTask(int index) {
        list.remove(index);
    }

    /**
     * Gets the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Prints all tasks in the list with their corresponding indices.
     */
    public void printTasks() {
        for (Task task : list) {
            System.out.print(list.indexOf(task) + 1 + ".");
            System.out.println(task);
        }
    }

    /**
     * Gets the index of a specified task in the list.
     *
     * @param task The task to find.
     * @return The index of the task, or -1 if not found.
     */
    public int getIndexOfTask(Task task) {
        return list.indexOf(task);
    }

    /**
     * Retrieves a task from the list based on its index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task get(int index) {
        return list.get(index);
    }

    /**
     * Marks a task as done at the specified index.
     *
     * @param index The index of the task to mark as done.
     */
    public void markTask(int index) {
        list.get(index).setDone(true);
    }

    /**
     * Marks a task as not done at the specified index.
     *
     * @param index The index of the task to mark as not done.
     */
    public void unmarkTask(int index) {
        list.get(index).setDone(false);
    }

    /**
     * Retrieves the entire list of tasks.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getList() {
        return list;
    }
}
