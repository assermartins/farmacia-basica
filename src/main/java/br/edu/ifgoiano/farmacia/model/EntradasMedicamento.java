package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the entradas_medicamentos database table.
 * 
 */
@Entity
@Table(name="entradas_medicamentos")
@NamedQuery(name="EntradasMedicamento.findAll", query="SELECT e FROM EntradasMedicamento e")
public class EntradasMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_entrada")
	private Integer pkEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	private Date dataEntrada;

	private Integer nf;

	@Column(name="pk_fornecedor")
	private Integer pkFornecedor;

	private Integer quantidade;

	//bi-directional many-to-one association to Medicamento
	@ManyToOne
	@JoinColumn(name="pk_medicamento")
	private Medicamento medicamento;

	public EntradasMedicamento() {
	}

	public Integer getPkEntrada() {
		return this.pkEntrada;
	}

	public void setPkEntrada(Integer pkEntrada) {
		this.pkEntrada = pkEntrada;
	}

	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Integer getNf() {
		return this.nf;
	}

	public void setNf(Integer nf) {
		this.nf = nf;
	}

	public Integer getPkFornecedor() {
		return this.pkFornecedor;
	}

	public void setPkFornecedor(Integer pkFornecedor) {
		this.pkFornecedor = pkFornecedor;
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

}