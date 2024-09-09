package br.edu.famper.employees_api.service;
import br.edu.famper.employees_api.model.Employee;
import br.edu.famper.employees_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findAll());
    }

    public ResponseEntity<Employee> findById(Long id){
        return employeeRepository.findById(id).map(employee -> ResponseEntity.status(HttpStatus.OK).body(employee))
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Employee> save(Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(employee));
    }

    public ResponseEntity<Employee> update(Employee employee){

        Employee employeeSaved = employeeRepository.findById(employee.getId())
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado!"));


        employeeSaved.setEmployeeName(employee.getEmployeeName());
        employeeSaved.setEmployeeEmail(employee.getEmployeeEmail());
        employeeSaved.setEmployeePhone(employee.getEmployeePhone());
        employeeSaved.setEmployeeDepartment(employee.getEmployeeDepartment());
        employeeSaved.setEmployeeAdmissionData(employee.getEmployeeAdmissionData());
        employeeSaved.setEmployeeRole(employee.getEmployeeRole());

        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.save(employeeSaved));
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }



}
