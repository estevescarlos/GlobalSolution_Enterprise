package br.com.itProdigium.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a unica inst�ncia da EntityManagerFactory
 */
public class EntityManagerFactorySingleton {

//	1 - Atributo est�tico que armazena a �nica inst�ncia
	private static EntityManagerFactory fabrica;

//	2 - Construtor privado -> ningu�m consegue instanciar
	private EntityManagerFactorySingleton() {
	}

//	3 - M�todo est�tico que retorna a �nica inst�ncia
	public static EntityManagerFactory getInstance() {

//		Validar se existe a fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("hsql");
		}
		return fabrica;
	}
}
