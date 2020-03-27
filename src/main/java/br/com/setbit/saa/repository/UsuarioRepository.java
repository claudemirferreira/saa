package br.com.setbit.saa.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.setbit.saa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.login = :login")
	public Usuario findByLogin(@Param("login") String login);

	@Query("select u from Usuario u where u.nome like :nome")
	public List<Usuario> findByNomeLike(@Param("nome") String nome);

	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	public Usuario findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha)
			throws NoResultException;

	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(@Param("email") String email);

	public List<Usuario> findByNomeLike(String nome, Pageable pages);

}