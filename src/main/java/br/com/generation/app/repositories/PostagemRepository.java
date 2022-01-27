package br.com.generation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.app.models.Postagem;



public interface PostagemRepository extends JpaRepository< Postagem ,Long > {
	public List<Postagem>findAllByTituloContainingIgnoreCase (String titulo);

}
