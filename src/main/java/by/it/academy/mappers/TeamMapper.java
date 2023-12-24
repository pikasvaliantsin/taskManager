package by.it.academy.mappers;

import by.it.academy.entities.Team;
import by.it.academy.services.tasks.TaskService;
import by.it.academy.services.tasks.TaskServiceImpl;
import by.it.academy.services.teams.TeamService;
import by.it.academy.services.teams.TeamServiceImpl;
import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;
import by.it.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

public class TeamMapper {

    UserService userService = UserServiceImpl.getInstance();
    TaskService taskService = TaskServiceImpl.getInstance();
    TeamService teamService = TeamServiceImpl.getInstance();
    private static TeamMapper teamMapper;

    private TeamMapper() {
    }

    public static TeamMapper getInstance() {
        if (teamMapper == null) {
            teamMapper = new TeamMapper();
        }
        return teamMapper;
    }

    public Team buildTeam(HttpServletRequest request) {
        return Team.builder()
                .teamName(request.getParameter(Constants.TEAM_NAME))
                .member(userService.getUser(parseLong(request.getParameter(Constants.MEMBER))))
                .task(taskService.getTask(parseLong(request.getParameter(Constants.TASK))))
                .build();
    }

    public Team UpdateTeam(HttpServletRequest request) {
        List<String> membersId = Optional.ofNullable(request.getParameterValues("checkedMember"))
                .stream().flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<String> tasksId = Optional.ofNullable(request.getParameterValues("checkedTasks"))
                .stream().flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Team team = Team.builder()
                .teamName(request.getParameter(Constants.TEAM_NAME))
                .build();
        teamService.updateMembers(team, membersId);
        teamService.updateTasks(team, tasksId);
        return team;
    }
}
