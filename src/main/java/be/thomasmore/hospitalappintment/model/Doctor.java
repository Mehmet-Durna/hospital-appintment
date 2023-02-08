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
