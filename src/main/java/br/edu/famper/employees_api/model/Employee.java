package br.edu.famper.employees_api.model;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", length = 100)
    private String employeeName;

    @NotNull
    @Column(name = "role", length = 100)
    private String employeeRole;

    @NotNull
    @Column(name = "department", length = 100)
    private String employeeDepartment;

    @NotNull
    @Column(name = "admission_data")
    private Date employeeAdmissionData;

    @NotNull
    @Column(name = "email", length = 200)
    private String employeeEmail;

    @NotNull
    @Column(name = "phone", length = 20)
    private String employeePhone;

}
