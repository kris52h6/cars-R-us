package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.cars.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/

public class ReservationResponse {
    private int id;
    private int carId;


    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime reservationDate;

    /*@JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)*/
    private LocalDate rentalDate;

    public ReservationResponse(Reservation res) {
        this.id = res.getId();
        this.carId = res.getCar().getId();
        this.reservationDate = res.getReservationDate();
        this.rentalDate = res.getRentalDate();
    }

}
