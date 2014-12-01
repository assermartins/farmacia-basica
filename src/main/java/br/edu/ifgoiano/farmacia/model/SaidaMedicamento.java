package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the saida_medicamento database table.
 * 
 */
@Entity
@Table(name="saida_medicamento")
@NamedQuery(name="SaidaMedicamento.findAll", query="SELECT s FROM SaidaMedicamento s")
public class SaidaMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_saida")
	private Integer pkSaida;

	@Temporal(TemporalType.DATE)
	@Column(name="data_saida")
	private Date dataSaida;

	private Integer quantidade;

	//bi-directional many-to-one association to Medicamento
	@ManyToOne
	@JoinColumn(name="pk_medicamento")
	private Medicamento medicamento;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="pk_medicos")
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="pk_paciente")
	private Paciente paciente;

	public SaidaMedicamento() {
	}

	public Integer getPkSaida() {
		return this.pkSaida;
	}

	public void setPkSaida(Integer pkSaida) {
		this.pkSaida = pkSaida;
	}

	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}