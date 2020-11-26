package com.cg.empspringapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_payroll")
public class EmpPayroll {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
        private String name;
        private double salary;
        
        public EmpPayroll() {}
        
        public EmpPayroll(String name, double salary) {
        	this.name = name;
        	this.salary = salary;
        }
        
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
        
		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "name : " + name + "salary : " + salary ;
		}

}
