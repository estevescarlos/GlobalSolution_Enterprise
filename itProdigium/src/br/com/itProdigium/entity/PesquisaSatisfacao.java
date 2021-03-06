package br.com.itProdigium.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_GS_SATISFACAO")
@SequenceGenerator(name = "pesquisa", allocationSize = 1, sequenceName = "SQ_T_GS_SATISFACAO")
public class PesquisaSatisfacao {

	@Id
	@Column(name = "cd_satisfacao", nullable = false)
	@GeneratedValue(generator = "pesquisa", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_pontos", nullable = false)
	private PontosTuristicos pontosTuristicos;

	@Column(name = "nr_nota", nullable = false, length = 1)
	private int notaAvalicao;

	@Column(name = "ds_tipo", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "ds_companhia", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private Companhia companhia;

	@Column(name = "ds_comentario", nullable = false, length = 500)
	private String comentario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pesquisa", nullable = false)
	private Calendar dtPesquisa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_sistema", nullable = false)
	private Calendar dtCadastro;

	public PesquisaSatisfacao() {
	}

	public PesquisaSatisfacao(Usuario usuario, PontosTuristicos pontosTuristicos, int notaAvalicao, Tipo tipo,
			Companhia companhia, String comentario, Calendar dtPesquisa, Calendar dtCadastro) {
		this.usuario = usuario;
		this.pontosTuristicos = pontosTuristicos;
		this.notaAvalicao = notaAvalicao;
		this.tipo = tipo;
		this.companhia = companhia;
		this.comentario = comentario;
		this.dtPesquisa = dtPesquisa;
		this.dtCadastro = dtCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PontosTuristicos getPontosTuristicos() {
		return pontosTuristicos;
	}

	public void setPontosTuristicos(PontosTuristicos pontosTuristicos) {
		this.pontosTuristicos = pontosTuristicos;
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Companhia getComQuemIr() {
		return companhia;
	}

	public void setComQuemIr(Companhia comQuemIr) {
		this.companhia = comQuemIr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNotaAvalicao() {
		return notaAvalicao;
	}

	public void setNotaAvalicao(int notaAvalicao) {
		this.notaAvalicao = notaAvalicao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Calendar getDtPesquisa() {
		return dtPesquisa;
	}

	public void setDtPesquisa(Calendar dtPesquisa) {
		this.dtPesquisa = dtPesquisa;
	}

	public Calendar getDtSistema() {
		return dtCadastro;
	}

	public void setDtSistema(Calendar dtSistema) {
		this.dtCadastro = dtSistema;
	}

}
