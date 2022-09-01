/*
package dat3.cars.repository;

import dat3.cars.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    static int car1;
    @BeforeAll
    public static void setupData(@Autowired CarRepository carRepository) {
        Car c1 = new Car("Mercedes", "A1", 200, 500);
        carRepository.save(c1);

        car1 = c1.getId();
    }

    @Test
    public void testFindCarByid() {
        Car result = carRepository.findById(car1).get();
        assertEquals(car1, result.getId());
    }

    @Test
    public void testFindCarByModel() {
        Car result = carRepository.findCarByModel("A1");
        System.out.println(result);
        assertEquals(car1, result.getId());
    }

}*/
