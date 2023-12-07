package by.it.academy.services.tasks;

import by.it.academy.entities.Task;
import by.it.academy.repositories.tasks.TaskRepository;
import by.it.academy.repositories.tasks.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository = TaskRepositoryImpl.getInstance();

    private static TaskService taskService;

    private TaskServiceImpl() {
    }

    public static TaskService getInstance() {
        if (taskService == null) {
            taskService = new TaskServiceImpl();
        }
        return taskService;
    }

    @Override
    public List<Task> readTasks() {
        return taskRepository.readTasks();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

    @Override
    public Task setTask(long id, Task task) {
        return taskRepository.setTask(id, task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.deleteTask(task);
    }

    @Override
    public void getDefaultTasks() {
        taskRepository.getDefaultTasks();
    }

    @Override
    public Task getTask(long taskId) {
        return taskRepository.getTask(taskId);
    }
}
