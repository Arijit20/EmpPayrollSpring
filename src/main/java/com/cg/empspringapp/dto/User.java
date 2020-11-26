package com.cg.empspringapp.dto;

import com.cg.empspringapp.model.EmpPayroll;

import lombok.Data;

@Data
public class User {
	
	    private Long id;
	    private String name;
	    private double salary;

	    public User(){

	    }

	    public User(EmpPayroll employee){
	        this.id = employee.getId();
	        this.name = employee.getName();
	        this.salary = employee.getSalary();
	    }

}
