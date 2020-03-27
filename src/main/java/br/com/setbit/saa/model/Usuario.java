package br.com.setbit.saa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.setbit.saa.enumerated.ProfileEnum;

/**
 * 
 * @author altitdb
 */
@Entity
@Table(name = "saa_usuario")
public class Usuario extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -7789936704890560797L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioPerfilPk.usuario", cascade = CascadeType.ALL)
	private List<UsuarioPerfil> usuarioPerfil = new ArrayList<UsuarioPerfil>();

	@Column(unique = true, length = 30)
	private String login;

	@Column(name = "senha")
	private String senha;

	@Column(name = "status", length = 1, columnDefinition = "CHAR(1)", nullable = false)
	private String status;

	private ProfileEnum profile;

	@Lob
	@Column(name = "logomarca")
	private byte[] logomarca;

	@Column(unique = true, length = 100)
	private String email;

	@OneToMany(mappedBy = "sistema")
	private List<Perfil> perfils;

	@Column(length = 100, nullable = false)
	private String nome;

	public Usuario() {
	}

	public Usuario(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Transient
	public UsuarioPerfil getUsuarioPerfilByPerfil(Perfil perfil) {
		for (UsuarioPerfil up : usuarioPerfil) {
			if (up.getUsuarioPerfilPk().getPerfil().equals(perfil)) {
				return up;
			}
		}
		return null;
	}

	@Transient
	public boolean containsPerfil(Perfil perfil) {
		return getUsuarioPerfilByPerfil(perfil) != null;
	}

	public List<UsuarioPerfil> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(List<UsuarioPerfil> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public byte[] getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(byte[] logomarca) {
		this.logomarca = logomarca;
	}

	public ProfileEnum getProfile() {
		if (profile == null)
			profile = ProfileEnum.ROLE_TECHNICIAN;

		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}