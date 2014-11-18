package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidades database table.
 * 
 */
@Entity
@Table(name="cidades")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_cidade")
	private Integer pkCidade;

	private String nome;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="pk_estado")
	private Estado estado;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="cidade")
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Psf
	@OneToMany(mappedBy="cidade")
	private List<Psf> psfs;

	public Cidade() {
	}

	public Integer getPkCidade() {
		return this.pkCidade;
	}

	public void setPkCidade(Integer pkCidade) {
		this.pkCidade = pkCidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setCidade(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setCidade(null);

		return paciente;
	}

	public List<Psf> getPsfs() {
		return this.psfs;
	}

	public void setPsfs(List<Psf> psfs) {
		this.psfs = psfs;
	}

	public Psf addPsf(Psf psf) {
		getPsfs().add(psf);
		psf.setCidade(this);

		return psf;
	}

	public Psf removePsf(Psf psf) {
		getPsfs().remove(psf);
		psf.setCidade(null);

		return psf;
	}

}