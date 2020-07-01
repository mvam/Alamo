package com.alamo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @author Marcos Moreira
 *
 */
@Entity
@Table(name="a_estoque")
@Audited
public class Estoque implements Serializable{

	private static final long serialVersionUID = -3294452611381463881L;

	@Id
	@SequenceGenerator(name = "estoqueGenerator", sequenceName = "seq_estoque", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoqueGenerator")
	private long id;
	
	@ManyToOne(optional = false)
	private ProdutoMarca produtoMarca;
	
	@Column(nullable = false)
	private BigDecimal precoCompra;
	
	@Column(nullable = false)
	private Integer qtdEstoque;
	
	@Column(nullable = false)
	private Calendar dataCompra;
	
	@Column(nullable = false)
	private boolean ativo = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProdutoMarca getProdutoMarca() {
		return produtoMarca;
	}

	public void setProdutoMarca(ProdutoMarca produtoMarca) {
		this.produtoMarca = produtoMarca;
	}

	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
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
		Estoque other = (Estoque) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
