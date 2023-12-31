package by.it.academy.controllers.filters;

import by.it.academy.services.users.UserService;
import by.it.academy.services.users.UserServiceImpl;
import by.it.academy.utils.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.utils.Constants.*;

@WebFilter(USERS_CREATE)
public class RegistrationFilter extends HttpFilter {

    UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter(Constants.USERNAME);
        if (userService.isLoginUnique(login)) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute(USERNAME, login);
            req.getRequestDispatcher(REGISTRATION_ERROR).forward(req, res);
        }

    }
}
