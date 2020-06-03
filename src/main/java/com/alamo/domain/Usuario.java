package com.alamo.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="a_usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -5389418623290985748L;
	
	@Id
	@SequenceGenerator(name = "usuarioGenerator", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioGenerator")
	private Integer id;
	
	@Column(columnDefinition = "varchar(30)")
	private String  login;
	
	@Column(columnDefinition = "varchar(30)")
	private String senha;
	
	@ElementCollection(targetClass= String.class)
	@JoinTable(name="a_usuario_permissao",
	uniqueConstraints={@UniqueConstraint(columnNames={"usuario", "permissao"})},
	joinColumns=@JoinColumn(name="usuario"))
	@Column(name="permissao", length=50)
	private Set<String> permissao= new HashSet<String>();
	
	@Column(name = "senhaerros")
	private Integer senhaErros;
	
	private boolean bloqueado;
	
	private boolean ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
