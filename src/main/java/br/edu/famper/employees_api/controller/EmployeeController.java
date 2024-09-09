package br.edu.famper.employees_api.controller;
import br.edu.famper.employees_api.model.Employee;
import br.edu.famper.employees_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Employee employee){
        employeeService.deleteById(employee.getId());
        return ResponseEntity.noContent().build();
    }

}
