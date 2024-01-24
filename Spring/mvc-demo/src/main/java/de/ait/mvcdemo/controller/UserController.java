package de.ait.mvcdemo.controller;

import de.ait.mvcdemo.model.User;
import de.ait.mvcdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

//        System.out.println(name + " " + email + " " + password);

        userService.addUser(name, email, password);
        return "redirect:/success_page.html";
    }

    @GetMapping("/home")
    public String getHomePage(Model model){
        return "redirect:home.html";
    }

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("userList", users);
        return "users_page";
    }
}
