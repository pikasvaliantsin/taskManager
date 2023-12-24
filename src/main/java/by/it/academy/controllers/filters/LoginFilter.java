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

@WebFilter("/login")
public class LoginFilter extends HttpFilter {

    UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            String login = req.getParameter(Constants.USERNAME);
            String password = req.getParameter(Constants.PASSWORD);

            if (userService.isLoginUnique(login)) {
                req.setAttribute("username", login);
                req.getRequestDispatcher("pages/errors/authorization_invalid_login.jsp").forward(req, res);
            } else if (userService.isAuthorize(login, password)) {
                chain.doFilter(req, res);
            } else {
                req.getRequestDispatcher("pages/errors/authorization_invalid_password.jsp").forward(req, res);
            }
        }
        chain.doFilter(req, res);
    }
}
