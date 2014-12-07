package br.edu.ifgoiano.farmacia.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ifgoiano.farmacia.annotations.Public;
import br.edu.ifgoiano.farmacia.dao.UsuarioDao;
import br.edu.ifgoiano.farmacia.model.Usuario;

@Controller
public class LoginController {
	
	private final UsuarioDao dao;
	private final Validator validator;
	private final Result result;
	private final UsuarioLogado usuarioLogado;

	@Inject
	public LoginController(UsuarioDao dao, Validator validator, Result result,
			UsuarioLogado usuarioLogado) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	@Deprecated
	public LoginController() {
		this(null, null, null, null); // para uso do CDI
	}
	
	
	@Get @Public
	public void formulario(){
		
	}
	
	@Post @Public
	public void autentica(Usuario usuario ){
		System.out.println("Vou buscar o usuario " + usuario.getUsuario());
		System.out.println(!dao.existe(usuario));
		
		if (!dao.existe(usuario)) {
			validator.add(new I18nMessage("login", "login.invalido"));
			validator.onErrorUsePageOf(this).formulario();
		}
		usuarioLogado.setUsuario(usuario);
		System.out.println("Estou logado? -> "+usuarioLogado.getUsuario().getUsuario());
		result.redirectTo(UsuarioController.class).lista();
		
	}
	
	public void logout() {
		this.usuarioLogado.logout();
		result.redirectTo(LoginController.class).formulario();
	}

}
