package com.alamo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

/**
 * @author Marcos Moreira
 *
 */
@Entity
@Table(name="a_produto_medida")
@Audited
public class ProdutoMedida implements Serializable{
	
	private static final long serialVersionUID = -1882349568670486195L;

	@Id
	@SequenceGenerator(name = "produtoMedidaGenerator", sequenceName = "seq_produto_medida", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoMedidaGenerator")
	private long id;
	
	@NaturalId
	@ManyToOne(optional = false)
	private Produto produto;
	
	@Column(nullable = false)
	private BigDecimal medida;
	
	@NaturalId
	@Column(nullable = false)
	private Integer ordinal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getMedida() {
		return medida;
	}

	public void setMedida(BigDecimal medida) {
		this.medida = medida;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
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
		ProdutoMedida other = (ProdutoMedida) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
