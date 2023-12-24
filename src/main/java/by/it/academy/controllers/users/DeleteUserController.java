package by.it.academy.controllers.users;

import by.it.academy.entities.User;
import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.utils.Constants.*;

@WebServlet(urlPatterns = USERS_DELETE)
public class DeleteUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter(USER_ID));
        User user = userService.getUser(id);
        userService.deleteUser(user);
        req.getRequestDispatcher(USERS_READ).forward(req, resp);
    }
}