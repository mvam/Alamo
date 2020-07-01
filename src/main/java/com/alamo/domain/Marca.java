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
@Table(name="a_marca")
@Audited
public class Marca implements Serializable{

	private static final long serialVersionUID = -5253463027644807134L;

	@Id
	@SequenceGenerator(name = "marcaGenerator", sequenceName = "seq_marca", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marcaGenerator")
	private long id;
	
	@Column(nullable = false, length = 70)
	private String nome;
	
	@Column(nullable = false, length = 5)
	private String acronomo;
	
	@Column(nullable = false)
	private Integer linha;
	
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

	public String getAcronomo() {
		return acronomo;
	}

	public void setAcronomo(String acronomo) {
		this.acronomo = acronomo;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
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
		Marca other = (Marca) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
