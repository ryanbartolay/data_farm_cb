package com.ryan.exception;

public class InvalidLottoResultException extends Exception {

	public InvalidLottoResultException() {
		super();
	}

	public InvalidLottoResultException(String message) {
		super(message);
	}
	public InvalidLottoResultException(String message, Throwable cause) { 
		super(message, cause); 
		}
	public InvalidLottoResultException(Throwable cause) { 
		super(cause); 
		}

}
