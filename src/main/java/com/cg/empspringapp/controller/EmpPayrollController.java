package com.cg.empspringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.empspringapp.dto.User;
import com.cg.empspringapp.service.IEmpPayrollService;

@RestController
public class EmpPayrollController {

	@Autowired
	private IEmpPayrollService empPayrollService;

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empPayrollService.CreateUser(user));
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(empPayrollService.UpdateUser(user));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(empPayrollService.deleteUser(id));
	}

	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(empPayrollService.getAllUser());
	}

}
