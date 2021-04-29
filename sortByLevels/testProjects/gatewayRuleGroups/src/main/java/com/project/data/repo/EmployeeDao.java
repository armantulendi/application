package com.project.data.repo;

import com.project.data.second.Employee;

public interface EmployeeDao {
    Employee findEmployee();
    void insertEmployee(Employee e);

}
