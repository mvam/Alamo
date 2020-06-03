package com.alamo.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="a_produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 3657114399026824464L;

	@Id
	@SequenceGenerator(name = "produtoGenerator", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoGenerator")
	private Integer id;
	
	@
	private String referenciaLoja;
	
	private String aplicacao;
	
	private String comentario;
	
	@Column(name="dataadicao")
	private Calendar dataAdicao;

//	private Naoseioquetipo foto;
	
	@ManyToOne(targetEntity = ProdutoTipo.class, fetch = FetchType.LAZY)
	private TipoProduto tipo;
	
	@ManyToOne(targetEntity = ProdutoMaterial.class, fetch = FetchType.LAZY)
	private MaterialProduto material;	
	
	@OneToMany(targetEntity = ProdutoMarca.class, fetch = FetchType.LAZY)
	private Set<ProdutoMarca> produtoMarca;
	
	@OneToMany(targetEntity = ProdutoMedida.class, fetch = FetchType.LAZY)
	@OrderBy("ordinal ASC")
	private List<ProdutoMedida> produtoMedida;
	
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
