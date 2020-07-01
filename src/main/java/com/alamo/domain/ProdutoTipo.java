package com.alamo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 * @author Marcos Moreira
 *
 */
@Entity
@Table(name="a_produto_tipo")
@Audited
public class ProdutoTipo implements Serializable{
	
	private static final long serialVersionUID = -536316126009430314L;

	@Id
	@SequenceGenerator(name = "produtoTipoGenerator", sequenceName = "seq_produto_tipo", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoTipoGenerator")
	private long id;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	@Column(nullable = false, length = 5)
	private String acronomo;
	
	private String discricao;
	
	private String descricaoArmazenamento;
	
	@OneToMany(targetEntity = TipoMedida.class, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy="tipo")
	@OrderBy("ordinal ASC")
	private List<TipoMedida> tipoMedida;
	
	@ManyToOne(targetEntity = ProdutoTipo.class, fetch = FetchType.LAZY)
	private ProdutoTipo tipoPai;
	
	@Column(nullable = false)
	private boolean ativo = true;

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

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

	public String getDescricaoArmazenamento() {
		return descricaoArmazenamento;
	}

	public void setDescricaoArmazenamento(String descricaoArmazenamento) {
		this.descricaoArmazenamento = descricaoArmazenamento;
	}

	public List<TipoMedida> getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(List<TipoMedida> tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public ProdutoTipo getTipoPai() {
		return tipoPai;
	}

	public void setTipoPai(ProdutoTipo tipoPai) {
		this.tipoPai = tipoPai;
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
		ProdutoTipo other = (ProdutoTipo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
