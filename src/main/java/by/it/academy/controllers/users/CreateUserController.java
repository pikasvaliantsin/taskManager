package by.it.academy.controllers.users;

import by.it.academy.entities.Task;
import by.it.academy.entities.Team;
import by.it.academy.entities.User;
import by.it.academy.enums.Role;
import by.it.academy.mappers.UserMapper;
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

@WebServlet(urlPatterns = "/users/create")
public class CreateUserController extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();
    private final TaskService taskService = TaskServiceImpl.getInstance();

    private final TeamService teamService = TeamServiceImpl.getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = taskService.readTasks();
        List<Team> teams = teamService.readTeams();
        req.setAttribute("roles", Role.values());
        req.setAttribute("tasks", tasks);
        req.setAttribute("teams", teams);
        req.getRequestDispatcher("/pages/users/createUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.buildUser(req);
        userService.createUser(user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }
}
