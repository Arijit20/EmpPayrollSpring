package com.cg.empspringapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.empspringapp.dto.User;
import com.cg.empspringapp.exception.EmpPayrollException;
import com.cg.empspringapp.model.EmpPayroll;
import com.cg.empspringapp.repository.EmpPayrollRepository;

@Service
public class EmpPayrollService implements IEmpPayrollService {

	@Autowired
	private EmpPayrollRepository empPayrollRepository;
	
	@Override
	public List<User> getAllUser() {
		return empPayrollRepository.findAll().stream().map(employee -> new User(employee)).collect(Collectors.toList());
	}

	@Override
	public User getUserById(Long id) {
		return empPayrollRepository.findById(id).map(employee -> {
			return new User(employee);
		}).orElseThrow(() -> new EmpPayrollException("employee not present"));
	}

	@Override
	public User CreateUser(User user) {
		EmpPayroll empPayroll = new EmpPayroll(user.getName(), user.getProfile(),
				user.getGender(), user.getDepartment(), user.getSalary(), user.getStartDate(), user.getNotes());
		return new User(empPayrollRepository.save(empPayroll));
	}

	@Override
	public User UpdateUser(User user) {
		return empPayrollRepository.findById(user.getId()).map(employee -> {
			
			employee.setName(user.getName());
			employee.setProfile(user.getProfile());
			employee.setGender(user.getGender());
			employee.setDepartment(user.getDepartment());
			employee.setSalary(user.getSalary());
			employee.setStartDate(user.getStartDate());
			employee.setNotes(user.getNotes());
			
			return new User(empPayrollRepository.save(employee));
			}).orElseThrow(() -> new EmpPayrollException("Employee not found"));
	}

	@Override
	public User deleteUser(Long id) {
		return empPayrollRepository.findById(id)
				.map(employee -> {empPayrollRepository.deleteById(employee.getId());
				return new User(employee);
		}).orElseThrow(() -> new EmpPayrollException("Id not present"));
	}
	
}
