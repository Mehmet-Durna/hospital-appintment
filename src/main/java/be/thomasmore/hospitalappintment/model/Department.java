package be.thomasmore.hospitalappintment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Department {
    @Id
    private int id;
    private String departmentName;
    private String inlinePhoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;


    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getInlinePhoneNo() {
        return inlinePhoneNo;
    }

    public void setInlinePhoneNo(String inlinePhoneNo) {
        this.inlinePhoneNo = inlinePhoneNo;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
