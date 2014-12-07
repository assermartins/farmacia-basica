package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk_usuario")
	private Integer pkUsuario;

	private String email;

	private Boolean entrou;

	private String nome;

	private String permissao;

	private String senha;

	private String usuario;

	public Usuario() {
	}

	public Integer getPkUsuario() {
		return this.pkUsuario;
	}

	public void setPkUsuario(Integer pkUsuario) {
		this.pkUsuario = pkUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEntrou() {
		return this.entrou;
	}

	public void setEntrou(Boolean entrou) {
		this.entrou = entrou;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPermissao() {
		return this.permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}