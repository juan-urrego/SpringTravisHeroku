package com.udea.springtravisheroku.service;

import com.udea.springtravisheroku.entity.Employee;
import com.udea.springtravisheroku.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    final
    EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean notExistById(int id) {
        return !this.employeeRepository.existsById(id);
    }

    public Optional<Employee> getById(int id){
        return this.employeeRepository.findById(id);
    }

    public Iterable<Employee> getAll(){
        return this.employeeRepository.findAll();
    }

    public void save(Employee employee, int seniority){
        if (seniority >= 2)
            employee.setSalary((long) (employee.getSalary() + (employee.getSalary() * 0.1)));
        this.employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }

    public void update(int id, Employee newEmployee, int seniority){
        Optional<Employee> employee = getById(id);
        if (employee.isPresent()){
            employee.get().setName(newEmployee.getName());
            employee.get().setSalary(newEmployee.getSalary());
            employee.get().setRole(newEmployee.getRole());
            employee.get().setAddress(newEmployee.getAddress());
            employee.get().setOffice(newEmployee.getOffice());
            employee.get().setBranch(newEmployee.getBranch());
            employee.get().setEmail(newEmployee.getEmail());
            employee.get().setPhone(newEmployee.getPhone());
            save(employee.get(), seniority);
        }
    }
}
