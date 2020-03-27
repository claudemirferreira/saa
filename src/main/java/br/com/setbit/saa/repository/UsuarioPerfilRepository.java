package br.com.setbit.saa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.setbit.saa.model.Perfil;
import br.com.setbit.saa.model.Usuario;
import br.com.setbit.saa.model.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {
	
	String LISTA_PERFIL_NOTIN_USUARIO = "select p.* from saa_perfil p " + "where p.id_perfil not in ( "
			+ "select id_perfil from saa_usuario_perfil up " + "where up.id_usuario = ";

	@Query("select up from UsuarioPerfil up " + " where up.usuarioPerfilPk.usuario = :usuario "
			+ " and up.usuarioPerfilPk.perfil = :perfil ")
	public UsuarioPerfil findByUsuarioAndPerfil(@Param("usuario") Usuario usuario, @Param("perfil") Perfil perfil);

	@Query("select up from UsuarioPerfil up " + " where up.usuarioPerfilPk.usuario = :usuario ")
	public List<UsuarioPerfil> findByUsuario(@Param("usuario") Usuario usuario);
	
	
}