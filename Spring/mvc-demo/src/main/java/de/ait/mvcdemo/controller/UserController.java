package de.ait.mvcdemo.controller;

import de.ait.mvcdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //методы для работы с юзером
    @PostMapping("/register")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password){

        System.out.println(name + " " + email + " " + password);

        return null;
    }
}
