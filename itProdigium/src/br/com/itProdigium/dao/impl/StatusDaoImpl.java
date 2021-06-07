package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.StatusDao;
import br.com.itProdigium.entity.Status;

public class StatusDaoImpl extends GenericDaoImpl<Status, Integer> implements StatusDao{

	public StatusDaoImpl(EntityManager em) {
		super(em);
	}

}
