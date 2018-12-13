package ru.ezhov.auth.srvlt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "auth")
public class ErrorAuthSrvlt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                System.out.println(cookie.getName());
                cookies[i].setValue(null);
                cookies[i].setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
