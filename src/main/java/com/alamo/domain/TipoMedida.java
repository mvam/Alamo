package com.alamo.domain;

import java.io.Serializable;

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
@Table(name = "a_produto_tipo_medida")
@Audited
public class TipoMedida implements Serializable {

	private static final long serialVersionUID = -268661806971735253L;

	@Id
	@SequenceGenerator(name = "produtoTipoMedidaGenerator", sequenceName = "seq_produto_tipo_medida", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoTipoMedidaGenerator")
	private long id;

	@NaturalId
	@ManyToOne(optional = false)
	private ProdutoTipo tipo;

	@Column(nullable = false, length = 50)
	private String nome;

	private String discricao;

	@NaturalId
	@Column(nullable = false)
	private Integer ordinal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProdutoTipo getTipo() {
		return tipo;
	}

	public void setTipo(ProdutoTipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
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
		TipoMedida other = (TipoMedida) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
