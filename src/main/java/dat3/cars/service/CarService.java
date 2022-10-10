package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarResponse getCarById(int id) {
        Car found = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        return new CarResponse(found, true);
    }

    public List<CarResponse> getCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(car -> new CarResponse(car,true)).collect(Collectors.toList());

    }

    public CarResponse addCar(CarRequest carRequest) {
        Car carToBeAdded = CarRequest.getCarEntity(carRequest);
        carToBeAdded = carRepository.save(carToBeAdded);
        return new CarResponse(carToBeAdded, false);
    }

    public void editCar(CarRequest c, int id) {
        Car found = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        found.setBrand(c.getBrand());
        found.setModel(c.getModel());
        found.setPricePrDay(c.getPricePrDay());
        found.setBestDiscount(c.getBestDiscount());
        carRepository.save(found);
    }

    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}
