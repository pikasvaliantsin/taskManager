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

@WebServlet(urlPatterns = "/teams/update")
public class UpdateTeamController extends HttpServlet {


    private final UserService userService = UserServiceImpl.getInstance();
    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();
    private final TeamMapper teamMapper = new TeamMapper();
    private Team team;
    private long id;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Long.parseLong(req.getParameter("teamId"));
        team = teamService.getTeam(id);
        req.setAttribute("name", team.getTeamName());
        req.setAttribute("users", userService.readUsers());
        req.setAttribute("members", team.getMembers());
        req.setAttribute("tasks", team.getTasks());
        req.setAttribute("allTasks", taskService.readTasks());

        req.getRequestDispatcher("/pages/teams/updateTeam.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        team = teamMapper.UpdateTeam(req);
        teamService.setTeam(id, team);
        req.getRequestDispatcher("/teams/read").forward(req, resp);
    }
}
