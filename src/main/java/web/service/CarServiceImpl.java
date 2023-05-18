package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarServiceImpl implements CarService {

    private static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("LADA", "Priora", 100000));
        cars.add(new Car("Ford", "Mustang", 100000));
        cars.add(new Car("Toyota", "Land cruiser", 1000000));
        cars.add(new Car("Ford", "Mustang", 100000));
        cars.add(new Car("Toyota", "Land cruiser", 1000000));
    }

    @Override
    public List<Car> showCountCars(int count) {
        if (count < 0 | count > cars.size()) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
