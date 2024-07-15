package org.example;

import java.util.ArrayList;

public class EmployeeCRUD {
    private ArrayList<Employee> employees;

    public EmployeeCRUD() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee: employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, String newName, String newDepartment) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(newName);
            employee.setDepartment(newDepartment);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeCRUD manager = new EmployeeCRUD();

        // Create new employees
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        Employee emp2 = new Employee(2, "Jane Smith", "Marketing");
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        // Read all employees
        System.out.println("All Employees:");
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println(emp);
        }

        // Read employee by ID
        System.out.println("Employee with ID 1:");
        System.out.println(manager.getEmployeeById(1));

        // Update employee
        if (manager.updateEmployee(emp1.getId(), "John Updated", "HR")) {
            System.out.println("Updated Employee with ID 1:");
            System.out.println(manager.getEmployeeById(1));
        } else {
            System.out.println("Employee with ID 1 not found.");
        }

        // Delete employee
        if (manager.deleteEmployee(2)) {
            System.out.println("Deleted Employee with ID 2.");
        } else {
            System.out.println("Employee with ID 2 not found.");
        }

        // Read all employees after update and delete
        System.out.println("All Employees after update and delete:");
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}


