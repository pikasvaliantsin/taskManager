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

@WebServlet(urlPatterns = "/tasks/update")
public class UpdateTaskController extends HttpServlet {

    private final TaskService taskService = TaskServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();

    private final TaskMapper taskMapper = new TaskMapper();

    private Task task;
    private long id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Long.parseLong(req.getParameter("taskId"));
        task = taskService.getTask(id);
        req.setAttribute("taskUser", task.getAssignee());
        req.setAttribute("taskTeam", task.getTeam());
        req.setAttribute("currentPriority", task.getPriority());
        req.setAttribute("currentStatus", task.getStatus());
        req.setAttribute("task", task.getTitle());
        req.setAttribute("description", task.getDescription());
        req.setAttribute("users", userService.readUsers());
        req.setAttribute("teams", teamService.readTeams());
        req.setAttribute("priorities", Priority.values());
        req.setAttribute("statuses", Status.values());
        req.getRequestDispatcher("/pages/tasks/updateTask.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        task = taskMapper.buildMapper(req);
        taskService.setTask(id, task);
        req.getRequestDispatcher("/tasks/read").forward(req, resp);
    }
}
