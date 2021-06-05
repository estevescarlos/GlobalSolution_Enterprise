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
@Table(name = "T_GS_CATEGORIA")
@SequenceGenerator(allocationSize = 1, name = "categoria", sequenceName = "SQ_T_GS_CATEGORIA")
public class Categoria {

	@Id
	@Column(name = "cd_categoria", nullable = false)
	@GeneratedValue(generator = "categoria", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "nm_categoria", nullable = false, length = 30)
	private String nome;

	@OneToMany(mappedBy = "categoria")
	private List<PontosTuristicos> pontoTuristico;
	
	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
