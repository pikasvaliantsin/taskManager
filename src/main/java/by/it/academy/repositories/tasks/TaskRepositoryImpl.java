package by.it.academy.repositories.tasks;

import by.it.academy.entities.Task;
import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TaskRepositoryImpl implements TaskRepository {

    private static TaskRepository taskRepository;
    private final List<Task> tasks = new ArrayList<>();

    private TaskRepositoryImpl() {
    }

    public static TaskRepository getInstance() {
        if (taskRepository == null) {
            taskRepository = new TaskRepositoryImpl();
        }
        return taskRepository;
    }

    @Override
    public void getDefaultTasks() {
        tasks.add(new Task(1L, "TestTask1", "default task 1", Priority.LOW, Status.NEW, null, null));
        tasks.add(new Task(2L, "TestTask2", "default task 2", Priority.LOW, Status.NEW, null, null));
    }

    @Override
    public Task getTask(long taskId) {
        return tasks.stream()
                .filter(task -> task.getTaskId() == taskId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getTaskIndex(long taskId) {
        return IntStream.range(0, tasks.size())
                .filter(i -> tasks.get(i).getTaskId() == taskId)
                .findFirst()
                .orElse(-1);
    }

    @Override
    public List<Task> readTasks() {
        return tasks;
    }

    @Override
    public Task createTask(Task task) {
        task.setTaskId(tasks.size() + 1);
        tasks.add(task);
        return task;
    }

    @Override
    public Task setTask(long id, Task task) {
        int index = taskRepository.getTaskIndex(id);
        task.setTaskId(id);
        tasks.set(index, task);
        return task;
    }

    @Override
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

}
