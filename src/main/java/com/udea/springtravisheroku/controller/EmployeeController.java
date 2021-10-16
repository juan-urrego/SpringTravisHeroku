package com.udea.springtravisheroku.controller;

import com.udea.springtravisheroku.entity.Employee;
import com.udea.springtravisheroku.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    final
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        Optional<Employee> employee = this.employeeService.getById(id);
        if (employee.isPresent())
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save/{seniority}")
    public ResponseEntity<?> save(@PathVariable("seniority") int seniority, @RequestBody Employee employee) {
        this.employeeService.save(employee, seniority);
        return new ResponseEntity<>("user Saved", HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{seniority}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @PathVariable("seniority") int seniority, @RequestBody Employee employee) {
        if(this.employeeService.notExistById(id))
            return new ResponseEntity<>("employee not found", HttpStatus.NOT_FOUND);
        this.employeeService.update(id, employee, seniority);
        return new ResponseEntity<>("user updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(this.employeeService.notExistById(id))
            return new ResponseEntity<>("employee not found", HttpStatus.NOT_FOUND);
        this.employeeService.delete(id);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }
}
