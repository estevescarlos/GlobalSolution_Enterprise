package br.com.itProdigium.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.itProdigium.dao.PontosTuristicosDao;
import br.com.itProdigium.entity.PontosTuristicos;
import br.com.itProdigium.entity.Tipo;

public class PontosTuristicosDaoImpl extends GenericDaoImpl<PontosTuristicos, Integer> implements PontosTuristicosDao {

	public PontosTuristicosDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<PontosTuristicos> listar() {
		TypedQuery<PontosTuristicos> query = em.createQuery("from PontosTuristicos", PontosTuristicos.class);
		return query.getResultList();
	}

	@Override
	public List<PontosTuristicos> buscarPeloTipo(Tipo tipo) {
		return em.createQuery("from PontosTuristicos p where p.tipo = :t", PontosTuristicos.class)
				.setParameter("t", tipo).getResultList();
	}

	@Override
	public List<PontosTuristicos> buscarPelaCidade(String cidade) {
		return em.createQuery("from PontosTuristicos p where lower(p.endereco.cidade) = lower(:c)",
				PontosTuristicos.class).setParameter("c", cidade).getResultList();
	}

}
