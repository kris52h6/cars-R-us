package dat3.cars.api;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // SECURITY ADMIN
    @GetMapping(path = ("/{id}"))
    CarResponse getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    // SECURITY ADMIN
    @GetMapping
    List<CarResponse> getCars() {
        return carService.getCars();
    }

    // SECURITY ADMIN
    @PostMapping
    CarResponse addCar(@RequestBody CarRequest carRequest) {
        return carService.addCar(carRequest);
    }

    // SECURITY ADMIN
    @PutMapping(path = ("/{id}"))
    void editCar(@RequestBody CarRequest carRequest, @PathVariable int id) {
        carService.editCar(carRequest, id);
    }

    // SECURITY ADMIN
    @DeleteMapping(path = "/{id}")
    void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }

}
