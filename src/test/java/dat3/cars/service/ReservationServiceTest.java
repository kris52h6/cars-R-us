/*
package dat3.cars.service;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationServiceTest {

    public ReservationService reservationService;

    public static ReservationRepository reservationRepository;
    public static MemberRepository memberRepository;
    public static CarRepository carRepository;

    @BeforeAll
    public static void setupData(@Autowired ReservationRepository reservation_Repository, @Autowired MemberRepository member_Repository,@Autowired CarRepository car_Repository) {
        reservationRepository = reservation_Repository;
        memberRepository = member_Repository;
        carRepository = car_Repository;

        Member m = new Member("m1", "pw", "m1@a.dk", "aa", "aaa", "aaaa", "aaaa", "1234");
        Car c = new Car("Skoda", "SLOW", 50, 10);
        LocalDate date = LocalDate.of(2022, 10, 8);
        Reservation r = new Reservation(m, c, date);
        reservationRepository.save(r);
    }

    @BeforeEach
    public void setService() {
        reservationService = new ReservationService(reservationRepository, memberRepository, carRepository);
    }

    @Test
    void getReservations() {
        List<Reservation> response = reservationRepository.findAll();

        assertEquals(1, response.size());
    }

    @Test
    void reserveCar() {
        reservationService.reserveCar("m1", 1, LocalDate.now());

        assertEquals(2, reservationService.getReservations().size());
    }
}*/
