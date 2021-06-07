package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.EnderecoDao;
import br.com.itProdigium.entity.Endereco;

public class EnderecoDaoImpl extends GenericDaoImpl<Endereco, Integer> implements EnderecoDao {

	public EnderecoDaoImpl(EntityManager em) {
		super(em);
	}

}
