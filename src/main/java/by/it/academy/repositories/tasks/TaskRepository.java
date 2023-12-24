package by.it.academy.repositories.tasks;

import by.it.academy.entities.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> readTasks();

    Task createTask(Task task);

    Task setTask(long id, Task task);

    void deleteTask(Task task);

    void getDefaultTasks();

    Task getTask(long taskId);

    int getTaskIndex(long taskId);

}
