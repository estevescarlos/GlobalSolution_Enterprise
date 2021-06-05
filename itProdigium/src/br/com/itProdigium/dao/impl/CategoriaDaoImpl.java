package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.CategoriaDao;
import br.com.itProdigium.entity.Categoria;

public class CategoriaDaoImpl extends GenericDaoImpl<Categoria, Integer> implements CategoriaDao{

	public CategoriaDaoImpl(EntityManager em) {
		super(em);
	}

}
