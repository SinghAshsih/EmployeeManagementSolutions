package com.blueliner.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueliner.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
