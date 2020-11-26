package com.cg.empspringapp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.empspringapp.dto.User;
import com.cg.empspringapp.model.EmpPayroll;
import com.cg.empspringapp.repository.EmpPayrollRepository;

@Service
public class EmpPayrollService implements IEmpPayrollService {

	@Autowired
	private EmpPayrollRepository empPayrollRepository;

	@Override
	public User CreateUser(User user) {
		EmpPayroll empPayroll = new EmpPayroll(user.getName(), user.getSalary());
		return new User(empPayrollRepository.save(empPayroll));
	}

	@Override
	public User UpdateUser(User user) {

		return empPayrollRepository.findById(user.getId()).map(employee -> {
			if (Objects.nonNull(user.getName())) {
				employee.setName(user.getName());
			}
			if (Objects.nonNull(user.getSalary())) {
				employee.setSalary(user.getSalary());
			}
			return new User(empPayrollRepository.save(employee));
		}).orElse(null);
	}

	@Override
	public User deleteUser(Long id) {
		return empPayrollRepository.findById(id).map(employee -> {
			empPayrollRepository.deleteById(employee.getId());
			return new User(employee);
		}).orElse(null);
	}

	@Override
	public List<User> getAllUser() {
		return empPayrollRepository.findAll().stream().map(employee -> new User(employee)).collect(Collectors.toList());
	}
}
