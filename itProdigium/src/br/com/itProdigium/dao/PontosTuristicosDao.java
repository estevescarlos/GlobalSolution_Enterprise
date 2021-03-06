package br.com.itProdigium.dao;

import java.util.List;

import br.com.itProdigium.entity.PontosTuristicos;
import br.com.itProdigium.entity.Tipo;

public interface PontosTuristicosDao extends GenericDao<PontosTuristicos, Integer>{

	List<PontosTuristicos> listar();
	
	List<PontosTuristicos> buscarPeloTipo(Tipo tipo);
	
	List<PontosTuristicos> buscarPelaCidade(String tipo);
	
}
