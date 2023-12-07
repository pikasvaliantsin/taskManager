package by.it.academy.controllers.tasks;

import by.it.academy.entities.Task;
import by.it.academy.services.tasks.TaskService;
import by.it.academy.services.tasks.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/tasks/delete")
public class DeleteTaskController extends HttpServlet {
    private final TaskService taskService = TaskServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("taskId"));
        Task task = taskService.getTask(id);
        taskService.deleteTask(task);
        req.getRequestDispatcher("/tasks/read").forward(req, resp);
    }
}
