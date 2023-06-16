package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUserPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping ("/addUserPage")
    public String showSaveUserPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUserPage";
    }
    @PostMapping("/addUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/users/edit/{id}")
    public String showUpdateUserPage(@PathVariable("id") Long id, @ModelAttribute("user") User user,  ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "editUserPage";
    }

    @PatchMapping("/editUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
