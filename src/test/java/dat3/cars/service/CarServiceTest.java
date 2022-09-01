package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarServiceTest {

    public CarService carService;

    public static CarRepository carRepository;

    @BeforeAll
    public static void setUpData(@Autowired CarRepository car_Repository) {
        carRepository = car_Repository;
        List<Car> cars = List.of(
                new Car("Mercedes", "A1", 200, 10.0),
                new Car("BMW", "QUICK", 100,  50)
        );
        carRepository.saveAll(cars);
    }


    // why?
    @BeforeEach
    public void setCarService(){
        carService = new CarService(carRepository);
    }

    @Test
    void getCars() {
        List<Car> response = carRepository.findAll();
        assertEquals(2, response.size());
        assertThat(response, containsInAnyOrder(
                hasProperty("brand", is("Mercedes")),
                hasProperty("brand", is("BMW"))));
    }

    @Test
    void addCar() {
        Car c = new Car("Skoda", "SLOW", 50, 10);
        CarRequest carToBeAdded = new CarRequest(c);
        carService.addCar(carToBeAdded);

        assertEquals(3, carRepository.count());
    }

    @Test
    void deleteCar() {
        carService.deleteCar(1);

        assertEquals(1, carRepository.count());
    }
}