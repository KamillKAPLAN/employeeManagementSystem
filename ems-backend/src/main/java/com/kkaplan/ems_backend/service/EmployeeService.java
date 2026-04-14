package com.kkaplan.ems_backend.service;

import com.kkaplan.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
}
