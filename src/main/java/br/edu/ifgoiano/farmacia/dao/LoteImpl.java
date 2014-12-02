package br.edu.ifgoiano.farmacia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifgoiano.farmacia.model.EntradasMedicamento;
import br.edu.ifgoiano.farmacia.model.Grupo;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medicamento;

public class LoteImpl implements LoteDAO {
	EntityManager manager;

	public LoteImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void salvar(Lote lote) {
		try {
			manager.getTransaction().begin();
			if (lote.getPkLote() == null)
				manager.persist(lote);
			else
				manager.merge(lote);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}

	}

	@Override
	public void deletar(Lote lote) {
		try {
			manager.getTransaction().begin();
			lote = manager.find(Lote.class, lote.getPkLote());
			manager.remove(lote);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}

	}

	@Override
	public Lote recuperarById(Integer id) {
		return manager.find(Lote.class, id);
	}

	@Override
	public List<Lote> recupearTodos() {
		String consulta = "select l from Lote l";
		TypedQuery<Lote> query;

		query = manager.createQuery(consulta, Lote.class);

		return query.getResultList();
	}

	@Override
	public Lote recupearTodosPorNumeroLote(String numeroLote) {
		String consulta = "select m from Lote m where m.lote = :mLote";

		TypedQuery<Lote> query = manager.createQuery(consulta, Lote.class);

		query.setParameter("mLote", numeroLote);

		return query.getSingleResult();
	}

	@Override
	public Medicamento recuperarMedicamentoById(Integer id) {
		return manager.find(Medicamento.class, id);
	}

	@Override
	public Grupo recuperarGrupoById(Integer id) {
		return manager.find(Grupo.class, id);
	}

	@Override
	public EntradasMedicamento entradaById(Integer id) {
		return manager.find(EntradasMedicamento.class, id);
	}

}
