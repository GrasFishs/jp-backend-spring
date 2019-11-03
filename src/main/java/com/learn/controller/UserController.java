package com.learn.controller;

import com.learn.model.User;
import com.learn.service.UserService;
import com.learn.service.impl.UserServiceImpl;
import com.learn.util.Response;
import com.learn.util.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public Response<User> register(@RequestBody User user) {
        Response<User> response = new Response<>();
        User newUser = userService.register(user);
        response.setData(newUser);
        response.setCode(RetCode.SUCCESS);
        return response;
    }
}
