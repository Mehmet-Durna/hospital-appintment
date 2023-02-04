package be.thomasmore.hospitalappintment.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nurse {
    @Id
    private Integer id;
    private String nurseName;
    private String gender;
    @Column(length = 1000)
    private String bio;
    private String inlinePhoneNo;
}
