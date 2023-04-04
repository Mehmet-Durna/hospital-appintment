package be.thomasmore.hospitalappintment.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospital {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_generator")
    @SequenceGenerator(name = "hospital_generator", sequenceName = "HOSPITAL_SEC", allocationSize = 1)
    @Id
    private Integer id;
    private String hospitalName;
    private String address;
    private String telNo;
    private int capacity;
    private boolean freeParkingAvailable;
    private String city;
    private double distanceFromPublicTransportInKm;





}
