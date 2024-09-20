package com.blueliner.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueliner.employee.dto.EmployeeDto;
import com.blueliner.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	ResponseEntity<EmployeeDto> createEmployeeDto(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto createEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	ResponseEntity<EmployeeDto> getEmployeeDto(@PathVariable Long id) {
		EmployeeDto employeeDto = employeeService.getEmployeeDto(id);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);

	}

	@GetMapping("/all")
	ResponseEntity<List<EmployeeDto>> getAll() {
		List<EmployeeDto> allEmployeeDto = employeeService.getAllEmployeeDto();
		return new ResponseEntity<List<EmployeeDto>>(allEmployeeDto, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		employeeService.deleteEmployeeDto(id);
		return new ResponseEntity<String>("Data deleted successfully !", HttpStatus.NOT_FOUND);
	}
}
