package br.edu.ifgoiano.farmacia.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifgoiano.farmacia.model.Usuario;

@RequestScoped
public class UsuarioDao {
	@PersistenceContext(unitName="sar")
	private final EntityManager em;

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
	
	public void adiciona(Usuario usuario){
		em.persist(usuario);
		
	}
	
	public Usuario busca (Usuario usuario){
		return em.find(Usuario.class, usuario.getPkUsuario());
	}
	
	@SuppressWarnings("unchecked") //Digo pro compilador calar a boca, sei o que estou fazendo e tenho certeza que vai voltar uma list de Usuário
	public List<Usuario> lista(){
		return em.createQuery("select u from Usuario u").getResultList();
	}
	
	public void remove(Usuario usuario){
		em.remove(busca(usuario));
	}
	


}
