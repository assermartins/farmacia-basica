package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_estado")
	private Integer pkEstado;

	@Column(name="codigo_uf")
	private String codigoUf;

	private String nome;

	private String regiao;

	private String uf;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades;

	public Estado() {
	}

	public Integer getPkEstado() {
		return this.pkEstado;
	}

	public void setPkEstado(Integer pkEstado) {
		this.pkEstado = pkEstado;
	}

	public String getCodigoUf() {
		return this.codigoUf;
	}

	public void setCodigoUf(String codigoUf) {
		this.codigoUf = codigoUf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return this.regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade addCidade(Cidade cidade) {
		getCidades().add(cidade);
		cidade.setEstado(this);

		return cidade;
	}

	public Cidade removeCidade(Cidade cidade) {
		getCidades().remove(cidade);
		cidade.setEstado(null);

		return cidade;
	}

}