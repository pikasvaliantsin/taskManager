package by.it.academy.controllers.teams;

import by.it.academy.entities.Task;
import by.it.academy.entities.Team;
import by.it.academy.entities.User;
import by.it.academy.mappers.TeamMapper;
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
import java.util.List;

import static by.it.academy.utils.Constants.*;

@WebServlet(urlPatterns = TEAMS_CREATE)
public class CreateTeamController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();
    private final TeamMapper teamMapper = TeamMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.readUsers();
        List<Task> tasks = taskService.readTasks();
        req.setAttribute(USERS, users);
        req.setAttribute(TASKS, tasks);
        req.getRequestDispatcher(CREATE_TEAM_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Team team = teamMapper.buildTeam(req);
        teamService.createTeam(team);
        req.getRequestDispatcher(TEAMS_READ).forward(req, resp);
    }
}
