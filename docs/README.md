# Eelyon User Guide

```
Hello! I'm Eelyon
What can I do for you?

      ▄▀▄     ▄▀▄
     ▄█░░▀▀▀▀▀░░█▄
 ▄▄  █░░░░░░░░░░░█  ▄▄
█▄▄█ █░░▀░░┬░░▀░░█ █▄▄█
```

**Eelyon is a task organiser designed to make your life easier!**



## List Tasks
Display all the tasks in the list

Example: `list`

```
1. [T][ ] Task 
2. [D][ ] Deadline (by: <date>)
3. [E][ ] Event (from: <date> to: <date>)
```


## Adding Tasks

### Todo Task

Add a todo task to the list

Example: `todo <todo_task>`

```
added: <todo_task>

You now have 1 tasks in the list
```

### Deadline Task

Add a deadline task to the list

Example: `deadline <deadline_task> /by <date>`

```
added: <deadline_task>

You now have 1 tasks in the list
```

### Event Task

Add an event task to the list

Example: `event <event_task> /from <date> /to <date>`

```
added: <event_task>

You now have 1 tasks in the list
```

## Delete Task
Delete a task from the list

Example: `delete <task_index>`

```
Noted. Removing this task:
[D][ ] <task> (by: <date>)
Now you have 3 tasks in the list.
```

## Find Task 

Find tasks in the list containing a specific keyword

Example: `find <keyword>`

```
Here are the tasks matching the keyword: <keyword>
1.[T][ ] <keyword>
2.[T][ ] <keyword>
3.[T][ ] <keyword>
```

## Mark Task as Done

Mark a specific task as done

Example: `mark <task_index>`

```
Nice! I've marked this task as done:
[X] <task>
```

## Unmark a Task

Unmark a specific task

Example: `unmark <task_index>`

```
Ok, I've marked this task as not done yet:
[ ] <task>
```

## Exit the Program

Quit the application

Example: `bye`

```
SEE YA LATER! COME BACK SOON!!!
```
