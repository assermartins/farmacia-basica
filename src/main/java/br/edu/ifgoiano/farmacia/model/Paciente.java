package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_paciente")
	private Integer pkPaciente;

	private String bairro;

	private String cep;

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

	private String diabetico;

	private Boolean gestante;

	private String hipertenso;

	private String logradouro;

	private String nome;

	@Column(name="nome_mae")
	private String nomeMae;

	@Column(name="nome_pai")
	private String nomePai;

	private String numero;

	private String sexo;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="pk_cidade")
	private Cidade cidade;

	//bi-directional many-to-one association to Psf
	@ManyToOne
	@JoinColumn(name="pk_psf")
	private Psf psf;

	//bi-directional many-to-one association to SaidaMedicamento
	@OneToMany(mappedBy="paciente")
	private List<SaidaMedicamento> saidaMedicamentos;

	public Paciente() {
	}

	public Integer getPkPaciente() {
		return this.pkPaciente;
	}

	public void setPkPaciente(Integer pkPaciente) {
		this.pkPaciente = pkPaciente;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDiabetico() {
		return this.diabetico;
	}

	public void setDiabetico(String diabetico) {
		this.diabetico = diabetico;
	}

	public Boolean getGestante() {
		return this.gestante;
	}

	public void setGestante(Boolean gestante) {
		this.gestante = gestante;
	}

	public String getHipertenso() {
		return this.hipertenso;
	}

	public void setHipertenso(String hipertenso) {
		this.hipertenso = hipertenso;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Psf getPsf() {
		return this.psf;
	}

	public void setPsf(Psf psf) {
		this.psf = psf;
	}

	public List<SaidaMedicamento> getSaidaMedicamentos() {
		return this.saidaMedicamentos;
	}

	public void setSaidaMedicamentos(List<SaidaMedicamento> saidaMedicamentos) {
		this.saidaMedicamentos = saidaMedicamentos;
	}

	public SaidaMedicamento addSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
		getSaidaMedicamentos().add(saidaMedicamento);
		saidaMedicamento.setPaciente(this);

		return saidaMedicamento;
	}

	public SaidaMedicamento removeSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
		getSaidaMedicamentos().remove(saidaMedicamento);
		saidaMedicamento.setPaciente(null);

		return saidaMedicamento;
	}

}