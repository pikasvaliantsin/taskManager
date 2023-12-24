package by.it.academy.controllers.users;

import by.it.academy.entities.User;
import by.it.academy.enums.Role;
import by.it.academy.mappers.UserMapper;
import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.utils.Constants.*;
import static java.lang.Long.parseLong;

@WebServlet(urlPatterns = USERS_UPDATE)
public class UpdateUserController extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = parseLong(req.getParameter(USER_ID));
        User user = userService.getUser(id);
        req.setAttribute(ROLES, Role.values());
        req.setAttribute(USER_ROLE, user.getRole());
        req.setAttribute(USERNAME, user.getUsername());
        req.setAttribute(EMAIL, user.getEmail());
        req.setAttribute(PASSWORD, user.getPassword());
        req.getRequestDispatcher(UPDATE_USER_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = parseLong(req.getParameter(USER_ID));
        User user = userMapper.updateUser(req);
        userService.setUser(id, user);
        req.getRequestDispatcher(USERS_READ).forward(req, resp);
    }
}
