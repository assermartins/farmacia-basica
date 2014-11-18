package br.edu.ifgoiano.farmacia.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifgoiano.farmacia.model.Usuario;


public class UsuarioDao {
	
private final EntityManager em;

//	private final EntityManager em = JPAUtil.criaEntityManager();

	@Inject
	public UsuarioDao(EntityManager em) {
		this.em = em;
		
	}
	
	@Deprecated
	public UsuarioDao() {
		this(null); // para uso do CDI
	}
	
	public boolean existe(Usuario usuario) {
		System.out.println("Usuário: "+usuario.getUsuario());
		System.out.println("Senha: "+usuario.getSenha());
		return !em.createQuery("select u from Usuario u where u.usuario = "
			+ ":pUsuario and u.senha = :pSenha", Usuario.class)
			.setParameter("pUsuario", usuario.getUsuario())
			.setParameter("pSenha", usuario.getSenha())
			.getResultList().isEmpty();
	}

}
