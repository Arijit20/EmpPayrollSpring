package com.cg.empspringapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_payroll_data_new")
public class EmpPayroll implements Serializable{
	
	  
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
        private String name;
        private String profile;
        private String gender;
        private String[] department;
        private double salary;
        private String startDate;
        private String notes;
        
        public EmpPayroll() {}
        
        public EmpPayroll(String name, String profile, String gender, String[] department, double salary, String startDate, String notes) {
        	this.name = name;
        	this.profile = profile;
        	this.gender = gender;
        	this.department = department;
        	this.salary = salary;
        	this.startDate = startDate;
        	this.notes = notes;
        }
        
}
