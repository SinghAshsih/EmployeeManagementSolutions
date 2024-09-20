package com.blueliner.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueliner.employee.dto.EmployeeDto;
import com.blueliner.employee.entity.Employee;
import com.blueliner.employee.exception.RecordNotFoundException;
import com.blueliner.employee.repository.EmployeeRepository;
import com.blueliner.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);

		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeDto(Long id) {
		// TODO Auto-generated method
		Employee findById = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Record not found with the given id :  " + id));
		EmployeeDto employeeDto = modelMapper.map(findById, EmployeeDto.class);
		return employeeDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployeeDto() {
		// TODO Auto-generated method stub
		List<Employee> findAll = employeeRepository.findAll();
		List<EmployeeDto> employeeDto = findAll.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
		return employeeDto;
	}

	@Override
	public void deleteEmployeeDto(Long id) {
		// TODO Auto-generated method stub
		Employee findById = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Record not found with the given id :  " + id));
		employeeRepository.deleteById(id);

	}

}
