package com.cg.empspringapp.service;

import java.util.List;

import com.cg.empspringapp.dto.User;
import com.cg.empspringapp.exception.EmpPayrollException;

public interface IEmpPayrollService {

	User CreateUser(User user) throws EmpPayrollException;

	User UpdateUser(User user) throws EmpPayrollException;

	User deleteUser(Long id) throws EmpPayrollException;

	List<User> getAllUser();
	
	User getUserById(Long id) throws EmpPayrollException;

}
