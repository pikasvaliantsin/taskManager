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

@WebServlet(urlPatterns = "/users/update")
public class UpdateUserController extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();
    private final UserMapper userMapper = new UserMapper();
    private User user;
    private long id;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Long.parseLong(req.getParameter("userId"));
        user = userService.getUser(id);
        req.setAttribute("roles", Role.values());
        req.setAttribute("userRole", user.getRole());
        req.setAttribute("username", user.getUsername());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("password", user.getPassword());
        req.getRequestDispatcher("/pages/users/updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = userMapper.updateUser(req);
        userService.setUser(id, user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }
}
