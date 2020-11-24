package com.alamo.exception;

public class BeanException extends AlamoException {

	private static final long serialVersionUID = 1162684600008445034L;

	public BeanException(String messsage) {
		super(new Exception(messsage));
	}
}
 