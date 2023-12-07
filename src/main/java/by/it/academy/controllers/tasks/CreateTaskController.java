package by.it.academy.controllers.tasks;

import by.it.academy.entities.Task;
import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import by.it.academy.mappers.TaskMapper;
import by.it.academy.services.tasks.TaskService;
import by.it.academy.services.tasks.TaskServiceImpl;
import by.it.academy.services.teams.TeamService;
import by.it.academy.services.teams.TeamServiceImpl;
import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/tasks/create")
public class CreateTaskController extends HttpServlet {

    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();

    private final TaskMapper taskMapper = new TaskMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.readUsers());
        req.setAttribute("teams", teamService.readTeams());
        req.setAttribute("priorities", Priority.values());
        req.setAttribute("statuses", Status.values());
        req.getRequestDispatcher("/pages/tasks/createTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = taskMapper.buildMapper(req);
        taskService.createTask(task);
        req.getRequestDispatcher("/tasks/read").forward(req, resp);
    }
}
