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

@WebFilter(urlPatterns = "/users/update")
public class AccessUpdateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            long userId = Long.parseLong(req.getParameter("userId"));
            HttpSession session = req.getSession();
            Long sessionUserId = (Long) session.getAttribute("sessionUserId");
            Role role = (Role) session.getAttribute("userRole");
            if (role.equals(Role.ADMIN)) {
                chain.doFilter(req, res);
            }
            if (userId == sessionUserId) {
                chain.doFilter(req, res);
            } else {
                req.getRequestDispatcher("/pages/errors/access_error.jsp").forward(req, res);
            }
        }
        chain.doFilter(req, res);
    }
}

