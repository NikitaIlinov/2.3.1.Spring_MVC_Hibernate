package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.CarDao;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarController {
    CarService carService = new CarServiceImpl();
    CarDao carDao = new CarDao();

    @GetMapping(value = "/cars")
    public String showCars(ModelMap model, @RequestParam(name = "count", required = false, defaultValue = "5") int count) {
        if (count >= 5) {
            model.addAttribute("cars", carService.showAllCars());
        } else {
            model.addAttribute("cars", carService.showCountCars(carService.showAllCars(), count));
        }
        return "cars";
    }

    @GetMapping("/addCar")
    public String showAddCarPage(ModelMap model) {
        model.addAttribute("carForm", carDao);
        return "addCar";
    }

    @PostMapping("/addCar")
    public String saveCar(@ModelAttribute("carForm") CarDao carDao) {
        if (carDao.getBrand() != null && carDao.getBrand().length() > 0 //
                && carDao.getModel() != null && carDao.getModel().length() > 0
                && carDao.getMileage() >= 0) {
            carService.saveCar(carDao);
            return "redirect:/cars";
        }
        return "addCar";
    }
}
