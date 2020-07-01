package com.alamo.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javassist.bytecode.ByteArray;

/**
 * @author Marcos Moreira
 *
 */
@Entity
@Table(name="a_produto")
@Audited
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 3657114399026824464L;

	@Id
	@SequenceGenerator(name = "produtoGenerator", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoGenerator")
	private long id;

	@Column(nullable = false, length = 7)
	private String numeroReferenciaLoja;
	
	private String aplicacao;
	
	private String comentario;

	@Lob
	private ByteArray imagem;
	
	@ManyToOne(targetEntity = ProdutoTipo.class, fetch = FetchType.LAZY, optional = false)
	private ProdutoTipo tipo;
	
	@ManyToOne(targetEntity = ProdutoMaterial.class, fetch = FetchType.LAZY)
	private ProdutoMaterial material;	
	
	@OneToMany(targetEntity = ProdutoMarca.class, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "produto")
	private Set<ProdutoMarca> produtoMarca;
	
	@OneToMany(targetEntity = ProdutoMedida.class, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "produto")
	@OrderBy("ordinal ASC")
	private List<ProdutoMedida> produtoMedida;
	
	private Calendar dataAdicao;
	
	@Column(nullable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
	private Calendar dataCriacao;
	
	@Column(nullable = false)
	private boolean ativo = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroReferenciaLoja() {
		return numeroReferenciaLoja;
	}

	public void setNumeroReferenciaLoja(String numeroReferenciaLoja) {
		this.numeroReferenciaLoja = numeroReferenciaLoja;
	}

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public ProdutoTipo getTipo() {
		return tipo;
	}

	public void setTipo(ProdutoTipo tipo) {
		this.tipo = tipo;
	}

	public ProdutoMaterial getMaterial() {
		return material;
	}

	public void setMaterial(ProdutoMaterial material) {
		this.material = material;
	}

	public Set<ProdutoMarca> getProdutoMarca() {
		return produtoMarca;
	}

	public void setProdutoMarca(Set<ProdutoMarca> produtoMarca) {
		this.produtoMarca = produtoMarca;
	}

	public List<ProdutoMedida> getProdutoMedida() {
		return produtoMedida;
	}

	public void setProdutoMedida(List<ProdutoMedida> produtoMedida) {
		this.produtoMedida = produtoMedida;
	}

	public Calendar getDataAdicao() {
		return dataAdicao;
	}

	public void setDataAdicao(Calendar dataAdicao) {
		this.dataAdicao = dataAdicao;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
