package com.cg.iscap;

public class CSVStateCensusException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public enum ExceptionType{INCORRECT_PATH,INCORRECT_TYPE,INCORRECT_DELIMITER,INCORRECT_HEADER}
	
	ExceptionType type;

	public CSVStateCensusException(ExceptionType type,String message) {
		super(message);
		this.type=type;
	}

}
