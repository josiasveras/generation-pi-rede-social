package br.com.generation.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.app.models.Postagem;
import br.com.generation.app.repositories.PostagemRepository;




@RestController
@RequestMapping("/postagens")
@CrossOrigin ("*")
public class PostagemController {
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Postagem>> findAllPostagem(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Postagem> findByIdPostagem(@PathVariable (value="id") Long id){
		return postagemRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/Titulo/{Titulo}")
	public ResponseEntity<List<Postagem>> findAllByTitulo(@PathVariable (value="titulo") String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	}
	
	@DeleteMapping("/apagar/{id}")
	public void delete(@PathVariable Long id) {
		postagemRepository.deleteById(id);
	}
	
}
