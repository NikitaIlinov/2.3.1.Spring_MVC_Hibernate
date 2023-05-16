package web.service;

import web.model.Car;
import web.model.CarDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void saveCar(CarDao carDao) {
        String brand = carDao.getBrand();
        String model = carDao.getModel();
        int millage = carDao.getMileage();
            Car newCar = new Car(brand, model, millage);
            cars.add(newCar);
        }

        @Override
        public List<Car> showAllCars () {
            return cars;
        }

    @Override
    public List<Car> showCountCars(List<Car> cars, int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
