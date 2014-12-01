package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_medicos")
	private Integer pkMedicos;

	private String crm;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to SaidaMedicamento
	@OneToMany(mappedBy="medico")
	private List<SaidaMedicamento> saidaMedicamentos;

	public Medico() {
	}

	public Integer getPkMedicos() {
		return this.pkMedicos;
	}

	public void setPkMedicos(Integer pkMedicos) {
		this.pkMedicos = pkMedicos;
	}

	public String getCrm() {
		return this.crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<SaidaMedicamento> getSaidaMedicamentos() {
		return this.saidaMedicamentos;
	}

	public void setSaidaMedicamentos(List<SaidaMedicamento> saidaMedicamentos) {
		this.saidaMedicamentos = saidaMedicamentos;
	}

	public SaidaMedicamento addSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
		getSaidaMedicamentos().add(saidaMedicamento);
		saidaMedicamento.setMedico(this);

		return saidaMedicamento;
	}

	public SaidaMedicamento removeSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
		getSaidaMedicamentos().remove(saidaMedicamento);
		saidaMedicamento.setMedico(null);

		return saidaMedicamento;
	}

}