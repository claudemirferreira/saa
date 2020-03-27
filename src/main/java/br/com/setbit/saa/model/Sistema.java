package br.com.setbit.saa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the saa_sistema database table.
 * 
 */
@Entity
@Table(name = "saa_sistema")
public class Sistema extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -1348896933495695497L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sistema")
	private Integer id;

	@Column(length = 6, nullable = false, unique = true)
	private String codigo;

	@Column(length = 200, nullable = false)
	private String descricao;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String imagem;

	@OneToMany(mappedBy = "sistema")
	@JsonIgnore
	private List<Perfil> perfils;

	public Sistema() {
	}

	public Sistema(int id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setSistema(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setSistema(null);

		return perfil;
	}
	
	public Sistema(Integer id, String codigo, String descricao, String nome, String imagem) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.imagem = imagem;
	}

}