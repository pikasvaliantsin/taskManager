package by.it.academy.controllers.filters;

import by.it.academy.enums.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/users/delete", "/teams/delete", "/tasks/delete"})
public class AccessDeleteFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Role role = (Role) session.getAttribute("userRole");
        if (role.equals(Role.ADMIN)) {
            chain.doFilter(req, res);
        } else {
            req.getRequestDispatcher("/pages/errors/access_error.jsp").forward(req, res);
        }
    }
}
