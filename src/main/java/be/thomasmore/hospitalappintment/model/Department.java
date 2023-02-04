package be.thomasmore.hospitalappintment.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Department {
    @Id
    private Integer id;
    private String departmentName;
    private String inlinePhoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;


    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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
