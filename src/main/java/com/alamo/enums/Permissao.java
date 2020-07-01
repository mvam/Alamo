package com.alamo.enums;

/**
 * @author Jhonis
 *
 */
public enum Permissao {
	USUARIO(1, "ROLE_USER"),
	ADMINISTRADOR(2, "ROLE_ADMIN"),
	GERENTE(3, "ROLE_GERENTE");
	
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
