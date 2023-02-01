package be.thomasmore.hospitalappintment.model;

import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    private int id;
    private String doctorName;
    private String specialization;
    @Column(length = 1000)
    private String bio;
    private String inlinePhoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;


    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getInlinePhoneNo() {
        return inlinePhoneNo;
    }

    public void setInlinePhoneNo(String inlinePhoneNo) {
        this.inlinePhoneNo = inlinePhoneNo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
