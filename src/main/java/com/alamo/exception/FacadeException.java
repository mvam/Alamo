package com.alamo.exception;

public class FacadeException extends AlamoException {

	private static final long serialVersionUID = 7454934607247499998L;

	public FacadeException(String messsage) {
		super(new Exception(messsage));
	}
}
 