package br.com.generation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.app.models.Tema;

@Repository
public interface TemaRepository extends JpaRepository< Tema ,Long > {
	public List< Tema > findAllByServicoContainingIgnoreCase (String servico);
}
