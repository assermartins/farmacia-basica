package br.edu.ifgoiano.farmacia.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifgoiano.farmacia.model.Usuario;
import br.edu.ifgoiano.farmacia.util.JPAUtil;

public class TestaConsulta {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.criaEntityManager();

		Usuario usuario = new Usuario();
		usuario.setUsuario("admin");
		usuario.setSenha("123");

		System.out.println(usuario.getUsuario());

		String consulta = "SELECT u FROM Usuario u WHERE u.usuario =:pNome";
		TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class)
				.setParameter("pNome", usuario.getUsuario());

		List<Usuario> users = query.getResultList();
		for (Usuario u : users) {
			System.out.println(u.getUsuario());

		}

		// System.out.println(!em.createQuery("select u from Usuario u where u.nome = "
		// + ":pUser and u.senha = :pSenha", Usuario.class)
		// .setParameter("pUser", usuario.getNomeUser())
		// .setParameter("pSenha", usuario.getSenha())
		// .getResultList().isEmpty());
		//
		// }
	}

}
