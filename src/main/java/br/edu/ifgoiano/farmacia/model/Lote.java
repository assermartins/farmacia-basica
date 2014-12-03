package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the lote database table.
 * 
 */
@Entity
public class Lote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_lote")
	@SequenceGenerator(allocationSize = 1, sequenceName = "seq_pk_lote", name = "pk_lote")
	@Column(name = "pk_lote")
	private Integer pkLote;

	@Temporal(TemporalType.DATE)
	private Date dataEntrada;

	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;

	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	private String codBarras;

	private String nomeLote;

	private String numeroNf;

	private Integer qtdMedicamento;

	@Enumerated(EnumType.STRING)
	private Unidade unidade;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pk_medicamento", referencedColumnName = "pk_medicamento")
	private Medicamento medicamento;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "pk_entrada", referencedColumnName = "pk_entrada")
	private EntradasMedicamento entradasMedicamento;
	
	
	Lote() {
	}

	public Lote(Date dataEntrada, Date dataFabricacao, Date dataVencimento,
			String codBarras, String nomeLote, String numeroNf,
			Integer qtdMedicamento, Unidade unidade, Medicamento medicamento,
			EntradasMedicamento entradasMedicamento) {

		this.dataEntrada = dataEntrada;
		this.dataFabricacao = dataFabricacao;
		this.dataVencimento = dataVencimento;
		this.codBarras = codBarras;
		this.nomeLote = nomeLote;
		this.numeroNf = numeroNf;
		this.qtdMedicamento = qtdMedicamento;
		this.unidade = unidade;
		this.medicamento = medicamento;
		this.entradasMedicamento = entradasMedicamento;

	}

	public Integer getPkLote() {
		return pkLote;
	}

	public void setPkLote(Integer pkLote) {
		this.pkLote = pkLote;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public String getNomeLote() {
		return nomeLote;
	}

	public String getNumeroNf() {
		return numeroNf;
	}

	public Integer getQtdMedicamento() {
		return qtdMedicamento;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setQtdMedicamento(Integer qtdMedicamento) {
		this.qtdMedicamento = qtdMedicamento;
	}
	
	public EntradasMedicamento getEntradasMedicamento() {
		return entradasMedicamento;
	}

	public void setEntradasMedicamento(EntradasMedicamento entradasMedicamento) {
		this.entradasMedicamento = entradasMedicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codBarras == null) ? 0 : codBarras.hashCode());
		result = prime * result
				+ ((numeroNf == null) ? 0 : numeroNf.hashCode());
		result = prime * result + ((pkLote == null) ? 0 : pkLote.hashCode());
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
		Lote other = (Lote) obj;
		if (codBarras == null) {
			if (other.codBarras != null)
				return false;
		} else if (!codBarras.equals(other.codBarras))
			return false;
		if (numeroNf == null) {
			if (other.numeroNf != null)
				return false;
		} else if (!numeroNf.equals(other.numeroNf))
			return false;
		if (pkLote == null) {
			if (other.pkLote != null)
				return false;
		} else if (!pkLote.equals(other.pkLote))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lote [pkLote=" + pkLote + ", dataEntrada=" + dataEntrada
				+ ", dataFabricacao=" + dataFabricacao + ", dataVencimento="
				+ dataVencimento + ", codBarras=" + codBarras + ", nomeLote="
				+ nomeLote + ", numeroNf=" + numeroNf + ", qtdMedicamento="
				+ qtdMedicamento + ", unidade=" + unidade + ", medicamento="
				+ medicamento + "]";
	}

	

}