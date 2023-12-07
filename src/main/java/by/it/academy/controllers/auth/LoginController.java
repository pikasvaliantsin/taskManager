package by.it.academy.controllers.auth;

import by.it.academy.entities.User;
import by.it.academy.services.tasks.TaskService;
import by.it.academy.services.tasks.TaskServiceImpl;
import by.it.academy.services.teams.TeamService;
import by.it.academy.services.teams.TeamServiceImpl;
import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;
import by.it.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userService.getUser(req.getParameter(Constants.USERNAME));
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("sessionUserId", user.getUserId());
        req.getRequestDispatcher("/menu").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userService.getDefaultUsers();
        taskService.getDefaultTasks();
        teamService.getDefaultTeams();
    }
}
