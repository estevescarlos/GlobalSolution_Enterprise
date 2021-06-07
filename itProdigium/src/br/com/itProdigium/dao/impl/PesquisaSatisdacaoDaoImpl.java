package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.PesquisaSatisfacaoDao;
import br.com.itProdigium.entity.PesquisaSatisfacao;

public class PesquisaSatisdacaoDaoImpl extends GenericDaoImpl<PesquisaSatisfacao, Integer> implements PesquisaSatisfacaoDao{

	public PesquisaSatisdacaoDaoImpl(EntityManager em) {
		super(em);
	}

}
