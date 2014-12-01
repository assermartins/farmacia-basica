package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_grupo")
	private Integer pkGrupo;

	@Column(name="nome_grupo")
	private String nomeGrupo;

	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="grupo")
	private List<Medicamento> medicamentos;

	public Grupo() {
	}

	public Integer getPkGrupo() {
		return this.pkGrupo;
	}

	public void setPkGrupo(Integer pkGrupo) {
		this.pkGrupo = pkGrupo;
	}

	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public List<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Medicamento addMedicamento(Medicamento medicamento) {
		getMedicamentos().add(medicamento);
		medicamento.setGrupo(this);

		return medicamento;
	}

	public Medicamento removeMedicamento(Medicamento medicamento) {
		getMedicamentos().remove(medicamento);
		medicamento.setGrupo(null);

		return medicamento;
	}

}