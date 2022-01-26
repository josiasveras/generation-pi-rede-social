


package br.com.generation.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temas")


public class TemaController {
	
	@Autowired
	private TemaController temaController;

}
