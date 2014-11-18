package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the psf database table.
 * 
 */
@Entity
@NamedQuery(name="Psf.findAll", query="SELECT p FROM Psf p")
public class Psf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_psf")
	private Integer pkPsf;

	private String nome;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="psf")
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="pk_cidade")
	private Cidade cidade;

	public Psf() {
	}

	public Integer getPkPsf() {
		return this.pkPsf;
	}

	public void setPkPsf(Integer pkPsf) {
		this.pkPsf = pkPsf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setPsf(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setPsf(null);

		return paciente;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}