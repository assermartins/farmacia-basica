package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the entradas_medicamentos database table.
 * 
 */
@Entity
@Table(name = "entradas_medicamentos")
@NamedQuery(name = "EntradasMedicamento.findAll", query = "SELECT e FROM EntradasMedicamento e")
public class EntradasMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_entrada")
	@SequenceGenerator(name = "pk_entrada", allocationSize = 1, sequenceName = "seq_pk_entrada")
	@Column(name = "pk_entrada")
	private Integer pkEntrada;

	@Temporal(TemporalType.DATE)
	private Date dataEntrada;

	private String numeroNF;
	@OneToMany
	private List<Lote> lotes;

	EntradasMedicamento() {

	}

	private EntradasMedicamento(String numeroNF) {
		this.numeroNF = numeroNF;
		this.dataEntrada = Calendar.getInstance().getTime();
	}

	/**
	 * fabrica de entradas
	 * 
	 * @return this
	 */
	public static EntradasMedicamento newEntradasMedicamentos(String numeroNF) {
		return new EntradasMedicamento(numeroNF);
	}

	public Integer getPkEntrada() {
		return pkEntrada;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public String getNumeroNF() {
		return numeroNF;
	}

	public void setNumeroNF(String numeroNF) {
		this.numeroNF = numeroNF;
	}

}