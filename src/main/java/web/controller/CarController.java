package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;


@Controller
public class CarController {

    @GetMapping("/addCar")
    public String showAddCarPage(ModelMap model) {
        model.addAttribute("carForm", new User());
        return "addCar";
    }
}
