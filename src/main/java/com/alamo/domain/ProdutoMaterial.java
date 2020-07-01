package com.alamo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @author Marcos Moreira
 *
 */
@Entity
@Table(name="a_produto_material")
@Audited
public class ProdutoMaterial implements Serializable{
	
	private static final long serialVersionUID = -287616869654591738L;

	@Id
	@SequenceGenerator(name = "produtoMaterialGenerator", sequenceName = "seq_produto_material", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoMaterialGenerator")
	private long id;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	private String discricao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		ProdutoMaterial other = (ProdutoMaterial) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
