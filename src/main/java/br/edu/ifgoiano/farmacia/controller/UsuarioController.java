package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Session;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.ifgoiano.farmacia.dao.UsuarioDao;
import br.edu.ifgoiano.farmacia.model.Usuario;

@Controller
@Transactional
public class UsuarioController {
	
	
	private final Result result;
	private final UsuarioDao usuarioDao;
	private final Validator validator;
	
	@Inject
	public UsuarioController(Result result, UsuarioDao usuarioDao, Validator validator) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.validator = validator;
	}
	
	@Deprecated
	public UsuarioController() {
		this(null, null, null);
	}
	
	public void cadastro() {

	}
	
	@Post
	public void adiciona(@Valid Usuario usuario){
		System.out.println("Nome de Usuário: "+usuario.getUsuario());
		System.out.println("Senha: "+usuario.getSenha());
		System.out.println("Nome completo: "+usuario.getNome());
		System.out.println("E-mail: "+usuario.getEmail());
		validator.onErrorRedirectTo(this).cadastro(); // Se o usuário não for válido (@Valid) vai dar um erro,
													 //e este validador vai redirecionar para a página de cadastro de novo.
		usuarioDao.adiciona(usuario);
		result.include("mensagem", "Usuário Adicionado com Sucesso");
		result.redirectTo(this).lista();
		
	}

	@Get
	public void lista() {
		result.include("usuarioList", usuarioDao.lista());
		
	}
	
	@Get
	public void remove(Usuario usuario){
		usuarioDao.remove(usuario);
		result.redirectTo(this).lista();
	}
	
	@Post 
	public void apagaOsSafadosTodos(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			this.remove(usuario);
		}
	}
	
	
	@Get
	public void listaJSON() {
		List<Usuario> lista = usuarioDao.lista();
		result.use(Results.json()).from(lista).serialize();
	}
	
	@Get
	public void listaXML(){
		List<Usuario> lista = usuarioDao.lista();
		result.use(Results.xml()).from(lista).serialize();
		
	}
	
}
