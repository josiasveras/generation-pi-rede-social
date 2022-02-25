package br.com.generation.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.app.models.Usuario;

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional <Usuario> findByUsuario (String usuario);
}
