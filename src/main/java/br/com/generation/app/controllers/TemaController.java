

package br.com.generation.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.app.models.Tema;
import br.com.generation.app.repositories.TemaRepository;

@RestController
@RequestMapping("/temas")


public class TemaController {
	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Tema>> findAllTema(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Tema> findByIdTema(@PathVariable (value="id") Long id){
		return temaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/Tema/{Tema}")
	public ResponseEntity<List<Tema>> findAllByTema(@PathVariable (value="tema") String tema){
		return ResponseEntity.ok(temaRepository.findAllByServicoContainingIgnoreCase(tema));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Tema> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Tema> put (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
	}
	
	@DeleteMapping("/apagar/{id}")
	public void delete(@PathVariable Long id) {
		temaRepository.deleteById(id);
	}
	

		
	}
