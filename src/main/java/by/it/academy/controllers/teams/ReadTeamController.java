package by.it.academy.controllers.teams;

import by.it.academy.entities.Team;
import by.it.academy.services.teams.TeamService;
import by.it.academy.services.teams.TeamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.it.academy.utils.Constants.*;

@WebServlet(urlPatterns = TEAMS_READ)
public class ReadTeamController extends HttpServlet {
    private final TeamService teamService = TeamServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Team> teams = teamService.readTeams();
        req.setAttribute(TEAMS, teams);
        req.getRequestDispatcher(READ_TEAM_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
