package com.blueliner.employee.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private Long id;

	private String firstName;
	private String lastName;
	private String department;
	private double salary;
	private String contact;
	private LocalDate dateOfJoining;
	private String designation;
	private AddressDto address;
}
