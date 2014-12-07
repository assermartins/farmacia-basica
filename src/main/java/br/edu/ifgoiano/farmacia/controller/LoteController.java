package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ifgoiano.farmacia.dao.LoteDAO;
import br.edu.ifgoiano.farmacia.model.EntradasMedicamento;
import br.edu.ifgoiano.farmacia.model.Grupo;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medicamento;

@Controller
public class LoteController {

	private Result result;
	private LoteDAO loteDAO;
	private Validator validator;

	private Medicamento medicamento;
	private Grupo grupo;
	private EntradasMedicamento entradas;

	@Deprecated
	public LoteController() {
		this(null, null, null);
	}

	public LoteController(Result result, LoteDAO loteDAO, Validator validator) {
		this.result = result;
		this.loteDAO = loteDAO;
		this.validator = validator;

	}

	public void formulario() {
	}

	public void salvar(Lote lote) {
		loteDAO.salvar(lote);
	}

	public void editar(Lote lote) {

		medicamento = loteDAO.recuperarMedicamentoById(lote.getMedicamento()
				.getPkMedicamento());

		grupo = loteDAO.recuperarGrupoById(medicamento.getGrupo().getPkGrupo());

		medicamento.setGrupo(grupo);

		entradas = loteDAO.entradaById(lote.getEntradasMedicamento()
				.getPkEntrada());

		lote = loteDAO.recuperarById(lote.getPkLote());

		this.loteDAO.salvar(lote);
	}

	public List<Lote> listarTodosLotes() {
		return loteDAO.recupearTodos();
	}

}
