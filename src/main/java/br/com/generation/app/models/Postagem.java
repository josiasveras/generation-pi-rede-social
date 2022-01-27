package br.com.generation.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_postagem")
public class Postagem {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long idPostagem;

@NotBlank 
@Size(min=2,max=255)
private String titulo;
	
@NotBlank 
@Size(min=2,max=1300)
private String conteudo;

@NotNull
private Double  valor;

@NotBlank 
@Size(min=2,max=500)
private String proposta;


@ManyToOne
@JoinColumn(name="fk_tema")
@JsonIgnoreProperties("postagem")
private Tema tema;

@ManyToOne
@JoinColumn(name="fk_usuario")
@JsonIgnoreProperties("postagem")
private Usuario usuario;

public long getIdPostagem() {
	return idPostagem;
}

public void setIdPostagem(long idPostagem) {
	this.idPostagem = idPostagem;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getConteudo() {
	return conteudo;
}

public void setConteudo(String conteudo) {
	this.conteudo = conteudo;
}

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}

public String getProposta() {
	return proposta;
}

public void setProposta(String proposta) {
	this.proposta = proposta;
}

public Tema getTema() {
	return tema;
}

public void setTema(Tema tema) {
	this.tema = tema;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

}
