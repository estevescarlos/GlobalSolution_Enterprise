package br.com.itProdigium.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.PesquisaSatisfacaoDao;
import br.com.itProdigium.dao.PontosTuristicosDao;
import br.com.itProdigium.dao.UsuarioDao;
import br.com.itProdigium.dao.impl.PesquisaSatisdacaoDaoImpl;
import br.com.itProdigium.dao.impl.PontosTuristicosDaoImpl;
import br.com.itProdigium.dao.impl.UsuarioDaoImpl;
import br.com.itProdigium.entity.Categoria;
import br.com.itProdigium.entity.Companhia;
import br.com.itProdigium.entity.Endereco;
import br.com.itProdigium.entity.EscalaPreco;
import br.com.itProdigium.entity.Estados;
import br.com.itProdigium.entity.PesquisaSatisfacao;
import br.com.itProdigium.entity.PontosTuristicos;
import br.com.itProdigium.entity.SiglaEstados;
import br.com.itProdigium.entity.Status;
import br.com.itProdigium.entity.Tipo;
import br.com.itProdigium.entity.Usuario;
import br.com.itProdigium.exception.CommitException;
import br.com.itProdigium.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PesquisaSatisfacaoDao pesquisaDao = new PesquisaSatisdacaoDaoImpl(em);
		PontosTuristicosDao pontosTuristicosDao = new PontosTuristicosDaoImpl(em);
		UsuarioDao usuarioDao = new UsuarioDaoImpl(em);
		
		/**
		 * 
		 * PERSISTENCIA/
		 * 
		 */
		Usuario user = new Usuario("Carlos", "carlos@fiap.com.br", "abc123");
		Usuario user2 = new Usuario("Gustavo", "gustavo@gmail.com.br", "acdb153");
		Usuario user3 = new Usuario("Nathalia", "nathalia@fiap.com.br", "Ddf820");
		
		Status status = new Status("Aberto");
		Status status2 = new Status("Fechado");
		Status status3 = new Status("Manutenção");
		
		Categoria categoria = new Categoria("Monumento");
		Categoria categoria2 = new Categoria("Parque");
		Categoria categoria3 = new Categoria("Museu");
		
		Endereco endereco = new Endereco(Estados.RIO_DE_JANEIRO, SiglaEstados.RJ, "Rio De Janeiro", "Rua Dr Muniz");
		Endereco endereco2 = new Endereco(Estados.SAO_PAULO, SiglaEstados.SP, "São Paulo", "Avenida Ibirapuera");
		Endereco endereco3 = new Endereco(Estados.MINAS_GERAIS, SiglaEstados.MG, "Belo Horizonte", "Avenida Afonso Pena");
		
		PontosTuristicos pontoTuristico = new PontosTuristicos(user, endereco, categoria, status, "Cristo Redentor", "651651", "165655", EscalaPreco.FREE, Tipo.NATUREZA, Companhia.FAMILIA, new GregorianCalendar(2021, Calendar.JUNE, 07));
		PontosTuristicos pontoTuristico2 = new PontosTuristicos(user2, endereco2, categoria2, status2, "Parque Ibirapuera", "5488005", "548804", EscalaPreco.FREE, Tipo.NATUREZA, Companhia.FAMILIA, new GregorianCalendar(2020, Calendar.MAY, 02));
		PontosTuristicos pontoTuristico3 = new PontosTuristicos(user3, endereco3, categoria3, status3, "Palacio das Artes", "885702", "2000271", EscalaPreco.$, Tipo.EDUCACIONAL, Companhia.AMIGOS, new GregorianCalendar(2020, Calendar.JANUARY, 07));
		
		PesquisaSatisfacao pesquisaSatisfacao = new PesquisaSatisfacao(user, pontoTuristico, 5, Tipo.EDUCACIONAL, Companhia.FAMILIA, "Muito lindo!", new GregorianCalendar(2021, Calendar.JUNE, 17), new GregorianCalendar(2021, Calendar.JUNE, 07));
		PesquisaSatisfacao pesquisaSatisfacao2 = new PesquisaSatisfacao(user, pontoTuristico2, 5, Tipo.EDUCACIONAL, Companhia.CASAL, "Enorme, uma pena que algumas áreas estavam restritas", new GregorianCalendar(2021, Calendar.MAY, 20), new GregorianCalendar(2021, Calendar.JUNE, 07));
		PesquisaSatisfacao pesquisaSatisfacao3 = new PesquisaSatisfacao(user, pontoTuristico3, 5, Tipo.ENTRETERIMENTO, Companhia.AMIGOS, "Apenas consegui ver o exterior, está em manutenção...", new GregorianCalendar(2020, Calendar.JUNE, 18), new GregorianCalendar(2021, Calendar.JUNE, 07));
		PesquisaSatisfacao pesquisaSatisfacao4 = new PesquisaSatisfacao(user2, pontoTuristico2, 5, Tipo.EDUCACIONAL, Companhia.FAMILIA, "Muitas arvores e animais, amei :)", new GregorianCalendar(2021, Calendar.JANUARY, 22), new GregorianCalendar(2021, Calendar.JUNE, 07));
		PesquisaSatisfacao pesquisaSatisfacao5 = new PesquisaSatisfacao(user3, pontoTuristico, 5, Tipo.CALMO, Companhia.AMIGOS, "Encantador...", new GregorianCalendar(2021, Calendar.MAY, 03), new GregorianCalendar(2021, Calendar.JUNE, 07));
		
		try {
			pesquisaDao.create(pesquisaSatisfacao);
			pesquisaDao.create(pesquisaSatisfacao2);
			pesquisaDao.create(pesquisaSatisfacao3);
			pesquisaDao.create(pesquisaSatisfacao4);
			pesquisaDao.create(pesquisaSatisfacao5);
			pesquisaDao.commit();
			System.out.println("Cadastrado com sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		/**
		 * 
		 * PESQUISAS JPQL
		 * 
		 */

		//1 - Pesquisar Pontos Turisticos pelo Tipo (ENUM)
		System.out.println("Buscar Pontos Turisticos pelo tipo");
		List<PontosTuristicos> pontosTuristicosTipo = pontosTuristicosDao.buscarPeloTipo(Tipo.NATUREZA);
		for (PontosTuristicos pt : pontosTuristicosTipo) {
			System.out.println(pt.getNome() + " - " + pt.getTipo().toString());
		}
		
		//2 - Pesquisar Pontos Turisticos pela Cidade sem case sensitive (STRING)
		System.out.println("Buscar Pontos Turisticos pelo tipo");
		List<PontosTuristicos> pontosTuristicosCidade = pontosTuristicosDao.buscarPelaCidade("belo HorizontE");
		for (PontosTuristicos pt : pontosTuristicosCidade) {
			System.out.println(pt.getNome() + " - " + pt.getEndereco().getEstado() + " + " + pt.getEndereco().getCidade());
		}
		
		//3 - Pesquisar Usuários pelo e-mail de forma segmentada (like) e sem case sensitive e ordenado pelo nome
		System.out.println("Buscar Usuário por email");
		List<Usuario> usuarios = usuarioDao.buscarPorEmail("FIAP");
		for (Usuario u : usuarios) {
			System.out.println(u.getNome() + " - " + u.getEmail());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
