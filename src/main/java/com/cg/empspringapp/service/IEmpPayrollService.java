package com.cg.empspringapp.service;

import java.util.List;
import com.cg.empspringapp.dto.User;

public interface IEmpPayrollService {
	
    List<User> getAllUser();
	
	User getUserById(Long id);

    User CreateUser(User user);

	User UpdateUser(User user);

	User deleteUser(Long id);
}
