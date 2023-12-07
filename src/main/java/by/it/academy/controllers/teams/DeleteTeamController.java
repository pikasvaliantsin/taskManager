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

@WebServlet(urlPatterns = "/teams/delete")
public class DeleteTeamController extends HttpServlet {
    private final TeamService teamService = TeamServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("teamId"));
        Team team = teamService.getTeam(id);
        teamService.deleteTeam(team);
        req.getRequestDispatcher("/teams/read").forward(req, resp);
    }
}
