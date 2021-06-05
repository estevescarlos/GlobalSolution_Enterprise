package br.com.itProdigium.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_T_GS_USUARIO", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "cd_usuario", nullable = false)
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_usuario", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "ds_email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "ds_password", length = 50, nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<PesquisaSatisfacao> pesquisaSatisfacao;
	
	@OneToMany(mappedBy = "usuario")
	private List<PontosTuristicos> pontosTuristicos;

	public Usuario() {
	}

	public Usuario(int codigo, String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<PesquisaSatisfacao> getPesquisaSatisfacao() {
		return pesquisaSatisfacao;
	}

	public void setPesquisaSatisfacao(List<PesquisaSatisfacao> pesquisaSatisfacao) {
		this.pesquisaSatisfacao = pesquisaSatisfacao;
	}

	public List<PontosTuristicos> getPontosTuristicos() {
		return pontosTuristicos;
	}

	public void setPontosTuristicos(List<PontosTuristicos> pontosTuristicos) {
		this.pontosTuristicos = pontosTuristicos;
	}

}
