package com.alamo.exception;

public class RNException extends AlamoException {

	private static final long serialVersionUID = 6573179472775316664L;
	
	public RNException(String messsage) {
		super(new Exception(messsage));
	}
}
 