package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    @Qualifier("userService")
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String showAllUserPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUser());
        return "/users";
    }

    @PostMapping("/addUser")
    public String showAddUserPage(ModelMap model) {
        model.addAttribute("addUser", new User());
        return "/addUser";
    }
}
