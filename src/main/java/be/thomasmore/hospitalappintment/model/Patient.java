package be.thomasmore.hospitalappintment.model;



import javax.persistence.*;

@Entity
public class Patient {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_generator")
    @SequenceGenerator(name = "patient_generator", sequenceName = "patient_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String patientName;
    private String gender;
    private String phoneNo;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;


    public Patient() {
    }

    public Patient(String patientName, String gender, String phoneNo, User user) {
        this.patientName = patientName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
