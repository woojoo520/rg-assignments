package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/assginmentDB?useSSL=false";
    private static final String USER = "woojoo";
    private static final String PASSWORD = "******";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getDepartment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                employees.add(new Employee(id, name, department));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        Employee employee = null;
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department");
                employee = new Employee(id, name, department);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getDepartment());
            pstmt.setInt(3, employee.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was updated
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was deleted
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC manager = new EmployeeJDBC();

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
        emp1.setName("John Updated");
        emp1.setDepartment("HR");
        if (manager.updateEmployee(emp1)) {
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

