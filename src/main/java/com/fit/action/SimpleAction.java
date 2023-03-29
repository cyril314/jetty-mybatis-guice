package com.fit.action;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fit.domain.User;
import com.fit.service.UserService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @className: SimpleServlet
 * @description: 演示控制器
 * @author: Aim
 * @date: 2023/3/29
 **/
@Singleton
public class SimpleAction extends HttpServlet {

    private final UserService userService;

    @Inject
    SimpleAction(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getRequestURI().endsWith("/db")) {
                User user = insertUser();

                resp.getWriter().print(userService.getUserById(user.getUserId()));
            } else {
                resp.getWriter().print("Hello from Java!");
            }
        } catch (Exception e) {
            resp.getWriter().print("There was an error: " + e.getMessage());
        }
    }

    private User insertUser() {
        User user = new User();
        user.setEmailId(UUID.randomUUID() + "@x.com");
        user.setPassword("secret");
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");

        userService.insertUser(user);

        return user;
    }
}
