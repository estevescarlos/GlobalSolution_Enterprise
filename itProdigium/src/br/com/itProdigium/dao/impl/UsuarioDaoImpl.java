package br.com.itProdigium.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.UsuarioDao;
import br.com.itProdigium.entity.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Usuario> listar() {
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	@Override
	public List<Usuario> buscarPorEmail(String e) {
		return em.createQuery("from Usuario u where lower(u.email) like lower(:e) order by u.nome", Usuario.class)
				.setParameter("e", "%" + e + "%").getResultList();
	}

}
