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
import java.util.List;

import static by.it.academy.utils.Constants.*;

@WebServlet(urlPatterns = TASKS_READ)
public class ReadTaskController extends HttpServlet {
    private final TaskService taskService = TaskServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = taskService.readTasks();
        req.setAttribute(TASKS, tasks);
        req.getRequestDispatcher(READ_TASKS_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
