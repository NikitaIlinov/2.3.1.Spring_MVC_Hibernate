package web.service;

import web.model.Car;
import web.model.CarDao;

import java.util.List;

public interface CarService {
    void saveCar (CarDao carDao);
    List<Car> showAllCars();
    List<Car> showCountCars(List<Car> cars, int count);
}
