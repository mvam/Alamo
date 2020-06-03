package com.alamo.enums;

public enum Permissao {
	USUARIO(1, "ROLE_USER"),
	ADMINISTRADOR(2, "ROLE_ADMIN");
	
	private int cod;
	private String desc;
	
	private Permissao(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
