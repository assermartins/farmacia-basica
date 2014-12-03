package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_medicamento")
	@SequenceGenerator(allocationSize = 1, sequenceName = "seq_pk_medicamento", name = "pk_medicamento")
	@Column(name = "pk_medicamento")
	private Integer pkMedicamento;

	private String descricao;

	private String nomeMedicamento;

	private List<Lote> lotes;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pk_grupo", referencedColumnName = "pk_grupo")
	private Grupo grupo;


	}

	public Integer getPkMedicamento() {
		return pkMedicamento;
	}

	public void setPkMedicamento(Integer pkMedicamento) {
		this.pkMedicamento = pkMedicamento;
	}

	public String getDescricao() {
		return descricao;
	}

	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	}

}