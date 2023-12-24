package by.it.academy.services.tasks;

import by.it.academy.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> readTasks();

    Task createTask(Task task);

    Task setTask(long id, Task task);

    void deleteTask(Task task);

    void getDefaultTasks();

    Task getTask(long taskId);

}
