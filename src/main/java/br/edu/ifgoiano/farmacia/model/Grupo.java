package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
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

/**
 * The persistent class for the grupos database table.
 * 
 */
@Entity
@Table(name = "grupos")
@NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_grupo")
	@SequenceGenerator(name = "pk_grupo", allocationSize = 1, sequenceName = "seq_pk_grupo")
	@Column(name = "pk_grupo")
	private Integer pkGrupo;

	private String descricaoGrupo;

	private String nomeGrupo;

	private String nomeSubGrupo;

	@OneToMany(mappedBy = "grupo")
	private List<Medicamento> medicamentos;

	Grupo() {
	}

	public Grupo(String descricaoGrupo, String nomeGrupo, String nomeSubGrupo) {
		this.descricaoGrupo = descricaoGrupo;
		this.nomeGrupo = nomeGrupo;
		this.nomeSubGrupo = nomeSubGrupo;
	}

	public Integer getPkGrupo() {
		return pkGrupo;
	}

	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public String getNomeSubGrupo() {
		return nomeSubGrupo;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	@Override
	public String toString() {
		return "Grupo [pkGrupo=" + pkGrupo + ", descricaoGrupo="
				+ descricaoGrupo + ", nomeGrupo=" + nomeGrupo
				+ ", nomeSubGrupo=" + nomeSubGrupo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkGrupo == null) ? 0 : pkGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (pkGrupo == null) {
			if (other.pkGrupo != null)
				return false;
		} else if (!pkGrupo.equals(other.pkGrupo))
			return false;
		return true;
	}

}