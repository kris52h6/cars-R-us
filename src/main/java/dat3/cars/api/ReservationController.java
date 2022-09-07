package dat3.cars.api;

import dat3.cars.dto.ReservationResponse;
import dat3.cars.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /*@GetMapping(path =("/{id}"))
    ReservationResponse getReservationById(@PathVariable int id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping
    List<ReservationResponse> getReservations() {
        return reservationService.getReservations();
    }*/

    @PostMapping("/{username}/{carId}/{rentalDate}")
    public void addReservation(@PathVariable String username, @PathVariable int carId, @PathVariable String rentalDate) {
        LocalDate parsedData = LocalDate.parse(rentalDate);
        reservationService.reserveCar(username, carId, parsedData);
    }



}
