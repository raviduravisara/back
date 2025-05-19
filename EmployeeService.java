package com.SalonManagement.service;


import com.SalonManagement.model.Employee;
import com.SalonManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id)
                .orElse(null);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employeeDetails){
        Employee employee = employeeRepository.findById(id)
                .orElse(null);
        if(employee != null){
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPhone(employeeDetails.getPhone());
            employee.setPosition(employeeDetails.getPosition());
            employee.setAddress(employeeDetails.getAddress());
            return employeeRepository.save(employee);
        }
        return null;
    }
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }













}
