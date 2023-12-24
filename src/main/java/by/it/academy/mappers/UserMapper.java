package by.it.academy.mappers;

import by.it.academy.entities.User;
import by.it.academy.enums.Role;
import by.it.academy.services.tasks.TaskService;
import by.it.academy.services.tasks.TaskServiceImpl;
import by.it.academy.services.teams.TeamService;
import by.it.academy.services.teams.TeamServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.it.academy.utils.Constants.*;
import static java.lang.Long.parseLong;

public class UserMapper {

    TeamService teamService = TeamServiceImpl.getInstance();
    TaskService taskService = TaskServiceImpl.getInstance();
    public static UserMapper userMapper;

    private UserMapper() {
    }

    public static UserMapper getInstance() {
        if (userMapper == null) {
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    public User buildUser(HttpServletRequest request) {
        return User.builder()
                .username(request.getParameter(USERNAME))
                .email(request.getParameter(EMAIL))
                .password(request.getParameter(PASSWORD))
                .role(Role.valueOf(request.getParameter(ROLE)))
                .team(teamService.getTeam(parseLong(request.getParameter(TEAM))))
                .task(taskService.getTask(parseLong(request.getParameter(TASK))))
                .build();

    }

    public User updateUser(HttpServletRequest request) {
        return User.builder()
                .username(request.getParameter(USERNAME))
                .email(request.getParameter(EMAIL))
                .password(request.getParameter(PASSWORD))
                .role(Role.valueOf(request.getParameter(ROLE)))
                .build();

    }
}
