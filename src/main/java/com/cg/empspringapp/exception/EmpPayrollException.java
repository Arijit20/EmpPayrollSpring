package com.cg.empspringapp.exception;

public class EmpPayrollException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;

	     public EmpPayrollException(String message) {
	        super(message);
	        this.message = message;
	    }

}
