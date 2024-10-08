package com.Outh.Autht.Controller;

import com.Outh.Autht.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(){
        return "hello";
    }

    @GetMapping("/secured")
    public String secured(){
        return userService.adduser();
    }
}
