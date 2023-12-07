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
import by.it.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Long.*;

public class TaskMapper {

    private final UserService userService = UserServiceImpl.getInstance();
    private final TeamService teamService = TeamServiceImpl.getInstance();

    public Task buildMapper(HttpServletRequest request){
        User user = request.getParameter(Constants.ASSIGNEE) != null ? userService.getUser(Long.parseLong(request.getParameter(Constants.ASSIGNEE))) : null;
        Team team = request.getParameter(Constants.TEAM) != null ? teamService.getTeam(Long.parseLong(request.getParameter(Constants.TEAM))) : null;

        return Task.builder()
                .title(request.getParameter(Constants.TASK))
                .description(request.getParameter(Constants.TASK_DESCRIPTION))
                .assignee(user)
                .team(team)
                .status(Status.valueOf(request.getParameter(Constants.STATUS)))
                .priority(Priority.valueOf(request.getParameter(Constants.PRIORITY)))
                .build();
    }
}
