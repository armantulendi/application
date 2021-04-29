package com.example.prim.repo;

import com.project.data.second.Employee;

public interface EmployeeDao {
    Employee findEmployee();
    void insertEmployee(Employee e);

}
