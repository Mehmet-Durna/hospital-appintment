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
public class Department {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(name = "department_generator", sequenceName = "DEPARTMENT_SEC", allocationSize = 1)
    @Id
    private Integer id;
    private String departmentName;
    private String inlinePhoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;



}
