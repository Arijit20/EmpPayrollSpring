package com.cg.empspringapp.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	    
	    public void setName(String name) {
	    	Pattern pattern = Pattern.compile("^[A-Z]{1}[a-zA-Z\\s]{2,}$");
			Matcher matcher = pattern.matcher(name);
			Boolean b = matcher.find();
			if(b) this.name = name;
			else this.name = null;
	    }

}
