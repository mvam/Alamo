package com.alamo.exception;

public class DAOException extends AlamoException {

	private static final long serialVersionUID = 1821906395162091124L;

	public DAOException(String messsage) {
		super(new Exception(messsage));
	}
}
 