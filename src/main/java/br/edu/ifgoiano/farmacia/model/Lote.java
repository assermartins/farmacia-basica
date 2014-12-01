package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lote database table.
 * 
 */
@Entity
@NamedQuery(name="Lote.findAll", query="SELECT l FROM Lote l")
public class Lote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_lote")
	private Integer pkLote;

	@Temporal(TemporalType.DATE)
	private Date entrada;

	@Temporal(TemporalType.DATE)
	private Date fabricacao;

	private String lote;

	private Integer nf;

	private Integer quantidade;

	@Temporal(TemporalType.DATE)
	private Date vencimento;

	//bi-directional many-to-one association to Medicamento
	@ManyToOne
	@JoinColumn(name="pk_medicamento")
	private Medicamento medicamento;

	public Lote() {
	}

	public Integer getPkLote() {
		return this.pkLote;
	}

	public void setPkLote(Integer pkLote) {
		this.pkLote = pkLote;
	}

	public Date getEntrada() {
		return this.entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getFabricacao() {
		return this.fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}

	public String getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Integer getNf() {
		return this.nf;
	}

	public void setNf(Integer nf) {
		this.nf = nf;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

}