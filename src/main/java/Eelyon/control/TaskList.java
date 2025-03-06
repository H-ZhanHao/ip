package Eelyon.control;

import Eelyon.commands.Task;

import java.util.ArrayList;

public class TaskList {
    static ArrayList<Task> list = new ArrayList<>();

    public void addTask(Task task) {
        list.add(task);
    }

    public void removeTask(Task task) {
        list.remove(task);
    }

    public void removeTask(int index) {
        list.remove(index);
    }

    public int getSize() {
        return list.size();
    }

    public void printTasks() {
        for (Task task : list) {
            System.out.print(list.indexOf(task) + 1 + ".");
            System.out.println(task);
        }
    }

    public int getIndexOfTask(Task task) {
        return list.indexOf(task);
    }

    public Task get(int index) {
        return list.get(index);
    }

    public void markTask(int index) {
        list.get(index).setDone(true);
    }

    public void unmarkTask(int index) {
        list.get(index).setDone(false);
    }

    public ArrayList<Task> getList() {
        return list;
    }
}
