package br.com.itProdigium.entity;

import java.util.Calendar;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_GS_PONTOS_TURISTICOS")
@SequenceGenerator(name = "pontoTuristico", sequenceName = "SQ_T_GS_PONTO_TURISTICO", allocationSize = 1)
public class PontosTuristicos {

	@Id
	@Column(name = "cd_pontos", nullable = false)
	@GeneratedValue(generator = "pontoTuristico", strategy = GenerationType.SEQUENCE)
	private int id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_endereco", nullable = false)
	private Endereco endereco;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_categoria", nullable = false)
	private Categoria categoria;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_status", nullable = false)
	private Status status;

	@Column(name = "nm_ponto", nullable = false, length = 100)
	private String nome;

	@Column(name = "ds_latitude", nullable = false, length = 50)
	private String latitude;

	@Column(name = "ds_longitude", nullable = false, length = 50)
	private String longitude;

	@Column(name = "ds_escala_preco", nullable = false, length = 5)
	@Enumerated(EnumType.STRING)
	private EscalaPreco escalaPreco;

	// TESTE
	@Column(name = "ds_tipo", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	// TESTE
	@Column(name = "ds_companhia", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
	private Companhia companhia;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_criacao", updatable = false)
	private Calendar dtCriacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_atualizao")
	private Calendar dtAtualizacao;

	@OneToMany(mappedBy = "pontosTuristicos")
	private List<PesquisaSatisfacao> pesquisaSatisfacao;

	public PontosTuristicos() {
	}

	public PontosTuristicos(Usuario usuario, Endereco endereco, Categoria categoria, Status status, String nome,
			String latitude, String longitude, EscalaPreco escalaPreco, Tipo tipo, Companhia companhia,
			Calendar dtAtualizacao) {
		this.usuario = usuario;
		this.endereco = endereco;
		this.categoria = categoria;
		this.status = status;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.escalaPreco = escalaPreco;
		this.tipo = tipo;
		this.companhia = companhia;
		this.dtAtualizacao = dtAtualizacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public EscalaPreco getEscalaPreco() {
		return escalaPreco;
	}

	public void setEscalaPreco(EscalaPreco escalaPreco) {
		this.escalaPreco = escalaPreco;
	}

	public Calendar getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Calendar dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Calendar getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Calendar dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public List<PesquisaSatisfacao> getPesquisaSatisfacao() {
		return pesquisaSatisfacao;
	}

	public void setPesquisaSatisfacao(List<PesquisaSatisfacao> pesquisaSatisfacao) {
		this.pesquisaSatisfacao = pesquisaSatisfacao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}

}
