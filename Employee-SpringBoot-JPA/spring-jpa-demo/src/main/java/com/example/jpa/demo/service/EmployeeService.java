package com.example.jpa.demo.service;

import com.example.jpa.demo.entity.Employee;
import com.example.jpa.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository
                .findEmployeeByName(employee.getName());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Employee with name " + employee.getName() + " exists.");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + employeeId + " does not exists.");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId,
                               String name,
                               String department) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + employeeId + " does not exists."
                ));
        if (name != null &&
            !name.isEmpty() &&
            !Objects.equals(name, employee.getName())) {
            employee.setName(name);
        }
        if (department != null &&
            !department.isEmpty() &&
            !Objects.equals(department, employee.getDepartment())) {
            employee.setDepartment(department);
        }

    }
}
