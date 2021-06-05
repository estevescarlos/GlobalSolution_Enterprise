package br.com.itProdigium.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_GS_ENDERECO")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "endereco", sequenceName = "SQ_T_GS_ENDERECO")
public class Endereco {

	@Id
	@Column(name = "cd_endereco", nullable = false)
	@GeneratedValue(generator = "endereco", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "ds_estado", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private Estados estado;

	@Column(name = "sg_estado", nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private SiglaEstados siglaEstado;

	@Column(name = "nm_cidade", nullable = false, length = 40)
	private String cidade;

	@Column(name = "ds_logradouro", nullable = false, length = 80)
	private String logradouro;

	@OneToMany(mappedBy = "endereco")
	private List<PontosTuristicos> pontosTuristicos;
	
	public Endereco() {
	}

	public Endereco(Estados estado, SiglaEstados siglaEstado, String cidade, String logradouro) {
		this.estado = estado;
		this.siglaEstado = siglaEstado;
		this.cidade = cidade;
		this.logradouro = logradouro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public SiglaEstados getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(SiglaEstados siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public List<PontosTuristicos> getPontosTuristicos() {
		return pontosTuristicos;
	}

	public void setPontosTuristicos(List<PontosTuristicos> pontosTuristicos) {
		this.pontosTuristicos = pontosTuristicos;
	}

}
