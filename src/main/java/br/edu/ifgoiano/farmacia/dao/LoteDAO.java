package br.edu.ifgoiano.farmacia.dao;

import java.util.List;

import br.edu.ifgoiano.farmacia.model.EntradasMedicamento;
import br.edu.ifgoiano.farmacia.model.Grupo;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medicamento;

public interface LoteDAO {

	void salvar(Lote lote);

	void deletar(Lote lote);

	Lote recuperarById(Integer id);

	Medicamento recuperarMedicamentoById(Integer id);

	Grupo recuperarGrupoById(Integer id);

	EntradasMedicamento entradaById(Integer id);

	List<Lote> recupearTodos();

	Lote recupearTodosPorNumeroLote(String numeroLote);

}
