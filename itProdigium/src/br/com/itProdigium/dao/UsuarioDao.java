package br.com.itProdigium.dao;

import java.util.List;

import br.com.itProdigium.entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer>{

	List<Usuario> listar();
	
	List<Usuario> buscarPorEmail(String e);
}
