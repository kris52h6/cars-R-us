package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    LocalDateTime reservationDate;

    LocalDate rentalDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;

    public Reservation(Member member, Car car, LocalDate rentalDate) {
        this.member = member;
        this.car = car;
        this.rentalDate = rentalDate;
    }

}
