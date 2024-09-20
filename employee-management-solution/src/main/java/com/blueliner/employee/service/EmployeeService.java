package com.blueliner.employee.service;

import java.util.List;

import com.blueliner.employee.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);

	public EmployeeDto getEmployeeDto(Long id);

	public List<EmployeeDto> getAllEmployeeDto();

	public void deleteEmployeeDto(Long id);
}
