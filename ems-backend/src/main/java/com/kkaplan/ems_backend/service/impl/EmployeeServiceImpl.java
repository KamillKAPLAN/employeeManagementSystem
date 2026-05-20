package com.kkaplan.ems_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kkaplan.ems_backend.dto.EmployeeDto;
import com.kkaplan.ems_backend.entity.Employee;
import com.kkaplan.ems_backend.exception.ResourceNotFoundException;
import com.kkaplan.ems_backend.mapper.EmployeeMapper;
import com.kkaplan.ems_backend.repository.EmployeeRepository;
import com.kkaplan.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();		
		return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
	}

}
