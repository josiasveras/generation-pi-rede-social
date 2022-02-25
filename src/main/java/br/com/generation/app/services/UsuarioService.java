package br.com.generation.app.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.generation.app.models.UserLogin;
import br.com.generation.app.models.Usuario;
import br.com.generation.app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return usuarioRepository.save(usuario);

	}
	
	public Optional<UserLogin> logar(Optional<UserLogin> userLogin){ 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(userLogin.get().getUsuario());
		
		if (usuario.isPresent()) {
			if (encoder.matches(userLogin.get().getSenha(), usuario.get().getSenha())) {
				String auth = userLogin.get().getUsuario() + ":" + usuario.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic" + new String(encodedAuth);
				userLogin.get().setToken(authHeader);
				userLogin.get().setNome(usuario.get().getNome());
				userLogin.get().setId(usuario.get().getIdUsuario());
				userLogin.get().setSenha(usuario.get().getSenha());
				userLogin.get().setFoto(usuario.get().getFoto());
				userLogin.get().setTipo(usuario.get().getTipo());
				return userLogin;
			}
		}
		
		return null;
	}
}	
