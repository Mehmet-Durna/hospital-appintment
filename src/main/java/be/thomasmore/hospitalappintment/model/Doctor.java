package be.thomasmore.hospitalappintment.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_generator")
    @SequenceGenerator(name = "doctor_generator", sequenceName = "DOCTOR_SEC", allocationSize = 1)
    @Id
    private Integer id;
    private String doctorName;
    private String specialization;
    @Column(length = 1000)
    private String bio;
    private String inlinePhoneNo;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;


}
