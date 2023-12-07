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

@WebServlet(urlPatterns = "/users/delete")
public class DeleteUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private User user;
    private long id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Long.parseLong(req.getParameter("userId"));
        user = userService.getUser(id);
        userService.deleteUser(user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }
}
