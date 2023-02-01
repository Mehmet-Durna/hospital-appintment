package be.thomasmore.hospitalappintment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Nurse {
    @Id
    private int id;
    private String nurseName;
    private String gender;
    @Column(length = 1000)
    private String bio;
    private String inlinePhoneNo;
}
