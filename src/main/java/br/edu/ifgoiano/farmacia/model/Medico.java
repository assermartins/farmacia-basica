package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicos database table.
 * 
 */
@Entity
@Table(name="medicos")
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

	//bi-directional many-to-one association to SaidasMedicamento
	@OneToMany(mappedBy="medico")
	private List<SaidasMedicamento> saidasMedicamentos;

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

	public List<SaidasMedicamento> getSaidasMedicamentos() {
		return this.saidasMedicamentos;
	}

	public void setSaidasMedicamentos(List<SaidasMedicamento> saidasMedicamentos) {
		this.saidasMedicamentos = saidasMedicamentos;
	}

	public SaidasMedicamento addSaidasMedicamento(SaidasMedicamento saidasMedicamento) {
		getSaidasMedicamentos().add(saidasMedicamento);
		saidasMedicamento.setMedico(this);

		return saidasMedicamento;
	}

	public SaidasMedicamento removeSaidasMedicamento(SaidasMedicamento saidasMedicamento) {
		getSaidasMedicamentos().remove(saidasMedicamento);
		saidasMedicamento.setMedico(null);

		return saidasMedicamento;
	}

}