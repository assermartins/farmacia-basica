package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_medicamento")
	private Integer pkMedicamento;

	@Column(name="cod_barras")
	private String codBarras;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private String descricao;

	@Column(name="estoque_minimo")
	private Integer estoqueMinimo;

	@Column(name="tot_estoque")
	private Integer totEstoque;

	private String unidade;

	//bi-directional many-to-one association to EntradaMedicamento
	@OneToMany(mappedBy="medicamento")
	private List<EntradaMedicamento> entradaMedicamentos;

	//bi-directional many-to-one association to Lote
	@OneToMany(mappedBy="medicamento")
	private List<Lote> lotes;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="pk_grupo")
	private Grupo grupo;

	//bi-directional many-to-one association to SaidaMedicamento
	@OneToMany(mappedBy="medicamento")
	private List<SaidaMedicamento> saidaMedicamentos;

	public Medicamento() {
	}

	public Integer getPkMedicamento() {
		return this.pkMedicamento;
	}

	public void setPkMedicamento(Integer pkMedicamento) {
		this.pkMedicamento = pkMedicamento;
	}

	public String getCodBarras() {
		return this.codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEstoqueMinimo() {
		return this.estoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Integer getTotEstoque() {
		return this.totEstoque;
	}

	public void setTotEstoque(Integer totEstoque) {
		this.totEstoque = totEstoque;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public List<EntradaMedicamento> getEntradaMedicamentos() {
		return this.entradaMedicamentos;
	}

	public void setEntradaMedicamentos(List<EntradaMedicamento> entradaMedicamentos) {
		this.entradaMedicamentos = entradaMedicamentos;
	}

	public EntradaMedicamento addEntradaMedicamento(EntradaMedicamento entradaMedicamento) {
		getEntradaMedicamentos().add(entradaMedicamento);
		entradaMedicamento.setMedicamento(this);

		return entradaMedicamento;
	}

	public EntradaMedicamento removeEntradaMedicamento(EntradaMedicamento entradaMedicamento) {
		getEntradaMedicamentos().remove(entradaMedicamento);
		entradaMedicamento.setMedicamento(null);

		return entradaMedicamento;
	}

	public List<Lote> getLotes() {
		return this.lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public Lote addLote(Lote lote) {
		getLotes().add(lote);
		lote.setMedicamento(this);

		return lote;
	}

	public Lote removeLote(Lote lote) {
		getLotes().remove(lote);
		lote.setMedicamento(null);

		return lote;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<SaidaMedicamento> getSaidaMedicamentos() {
		return this.saidaMedicamentos;
	}

	public void setSaidaMedicamentos(List<SaidaMedicamento> saidaMedicamentos) {
		this.saidaMedicamentos = saidaMedicamentos;
	}

	public SaidaMedicamento addSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
		getSaidaMedicamentos().add(saidaMedicamento);
		saidaMedicamento.setMedicamento(this);

		return saidaMedicamento;
	}

	public SaidaMedicamento removeSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
		getSaidaMedicamentos().remove(saidaMedicamento);
		saidaMedicamento.setMedicamento(null);

		return saidaMedicamento;
	}

}