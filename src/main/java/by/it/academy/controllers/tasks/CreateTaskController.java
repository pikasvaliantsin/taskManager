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

import static by.it.academy.utils.Constants.*;

@WebServlet(urlPatterns = TASKS_CREATE)
public class CreateTaskController extends HttpServlet {
    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();
    private final TaskMapper taskMapper = TaskMapper.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(USERS, userService.readUsers());
        req.setAttribute(TEAMS, teamService.readTeams());
        req.setAttribute(PRIORITIES, Priority.values());
        req.setAttribute(STATUSES, Status.values());
        req.getRequestDispatcher(CREATE_TASK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = taskMapper.buildMapper(req);
        taskService.createTask(task);
        req.getRequestDispatcher(TASKS_READ).forward(req, resp);
    }
}