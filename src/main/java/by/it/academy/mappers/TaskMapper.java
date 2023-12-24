package by.it.academy.mappers;

import by.it.academy.entities.Task;
import by.it.academy.entities.Team;
import by.it.academy.entities.User;
import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import by.it.academy.services.teams.TeamService;
import by.it.academy.services.teams.TeamServiceImpl;
import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.it.academy.utils.Constants.*;
import static java.lang.Long.parseLong;

public class TaskMapper {

    private final UserService userService = UserServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();
    private static TaskMapper taskMapper;

    private TaskMapper() {
    }

    public static TaskMapper getInstance() {
        if (taskMapper == null) {
            taskMapper = new TaskMapper();
        }
        return taskMapper;
    }

    public Task buildMapper(HttpServletRequest request) {
        User user = request.getParameter(ASSIGNEE) != null ? userService.getUser(parseLong(request.getParameter(ASSIGNEE))) : null;
        Team team = request.getParameter(TEAM) != null ? teamService.getTeam(parseLong(request.getParameter(TEAM))) : null;

        return Task.builder()
                .title(request.getParameter(TASK))
                .description(request.getParameter(TASK_DESCRIPTION))
                .assignee(user)
                .team(team)
                .status(Status.valueOf(request.getParameter(STATUSES)))
                .priority(Priority.valueOf(request.getParameter(PRIORITIES)))
                .build();
    }
}
