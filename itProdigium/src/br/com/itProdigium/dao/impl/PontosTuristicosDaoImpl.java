package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.PontosTuristicosDao;
import br.com.itProdigium.entity.PontosTuristicos;

public class PontosTuristicosDaoImpl extends GenericDaoImpl<PontosTuristicos, Integer> implements PontosTuristicosDao{

	public PontosTuristicosDaoImpl(EntityManager em) {
		super(em);
	}

}
