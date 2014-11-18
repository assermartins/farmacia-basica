package br.edu.ifgoiano.farmacia.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.ifgoiano.farmacia.model.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable{
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void logout() {
		this.usuario = null;
	}
	
	

}
