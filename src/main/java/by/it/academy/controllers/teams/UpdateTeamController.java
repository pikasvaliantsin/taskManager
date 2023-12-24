package by.it.academy.controllers.teams;

import by.it.academy.entities.Team;
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

import static by.it.academy.utils.Constants.*;

@WebServlet(urlPatterns = TEAMS_UPDATE)
public class UpdateTeamController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();
    private final TeamMapper teamMapper = TeamMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter(TEAM_ID));
        Team team = teamService.getTeam(id);
        req.setAttribute(TEAM_NAME, team.getTeamName());
        req.setAttribute(USERS, userService.readUsers());
        req.setAttribute(MEMBERS, team.getMembers());
        req.setAttribute(TEAM_TASKS, team.getTasks());
        req.setAttribute(TASKS, taskService.readTasks());
        req.getRequestDispatcher(UPDATE_TEAM_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter(TEAM_ID));
        Team team = teamMapper.UpdateTeam(req);
        teamService.setTeam(id, team);
        req.getRequestDispatcher(TEAMS_READ).forward(req, resp);
    }
}