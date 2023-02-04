package be.thomasmore.hospitalappintment.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Appointment {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_generator")
    @SequenceGenerator(name = "appointment_generator", sequenceName = "APPOINTMENT_SEC", allocationSize = 1)
    @Id
    private Integer id;
    @Column(length = 200)
    private String info;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date time;
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
