package com.alamo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @author Marcos Moreira
 *
 */
@Entity
@Table(name="a_produto_marca")
@Audited
public class ProdutoMarca implements Serializable{
	
	private static final long serialVersionUID = 394110103111005930L;

	@Id
	@SequenceGenerator(name = "produtoMarcaGenerator", sequenceName = "seq_produto_marca", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoMarcaGenerator")
	private long id;

	@Column(nullable = false, length = 30)
	private String referencia;
	
	@Column(nullable = false)
	private BigDecimal preco;
	
	@Column(nullable = false, columnDefinition = "Integer default 0")
	private Integer qtdVendidos;
	
	@ManyToOne(targetEntity = Produto.class, fetch = FetchType.LAZY, optional = false)
	private Produto produto;
	
	@ManyToOne(targetEntity = Marca.class, fetch = FetchType.LAZY, optional = false)
	private Marca marca;	
	
	@OneToMany(targetEntity = Estoque.class, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "produtoMarca")
	private List<Estoque> estoque;
	
	@Column(nullable = false)
	private boolean ativo = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQtdVendidos() {
		return qtdVendidos;
	}

	public void setQtdVendidos(Integer qtdVendidos) {
		this.qtdVendidos = qtdVendidos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Estoque> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Estoque> estoque) {
		this.estoque = estoque;
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ProdutoMarca other = (ProdutoMarca) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
