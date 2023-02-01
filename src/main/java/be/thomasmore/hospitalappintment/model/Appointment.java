package be.thomasmore.hospitalappintment.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
public class Appointment {
@Id
    private int id;
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

    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public be.thomasmore.hospitalappintment.model.Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(be.thomasmore.hospitalappintment.model.Doctor doctor) {
        doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
