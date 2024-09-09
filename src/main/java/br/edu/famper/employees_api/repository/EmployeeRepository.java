package br.edu.famper.employees_api.repository;
import br.edu.famper.employees_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{}
