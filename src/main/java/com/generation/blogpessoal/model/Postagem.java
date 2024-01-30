package com.generation.blogpessoal.model;

import java.time.LocalDateTime;


import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;



@Entity
@Table(name="tb_postagens")
public class Postagem {

	@Id /*torna esse atributo uma chave primaria */
	@GeneratedValue(strategy=GenerationType.IDENTITY)/*para adicionar o id como autoincrement*/
	private Long id;
	
	/*essa anotação valida o atributo tendo um valor maximo e minimo de caracteres*/
   @Size(min=5, max=100, message= "O titulo deve ter no minimo 5 caracteres o máximo de 100")
   @NotBlank(message= "atributo titulo é obrigayorio")
   private String titulo;
	
   @Size(min=10, max=1000, message="O texto deve ter no minimo 10 caracteres e no maximo 1000")
   @NotBlank(message="Atributo texto é obrigatório")
   private String texto; 
   
   @UpdateTimestamp /* pega a data do sistema ao cadastrar um registro*/
   private LocalDateTime data;
   
   @ManyToOne
   @JsonIgnoreProperties("postagem")
   private Tema tema; 
   
   @ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public LocalDateTime getData() {
	return data;
}

public void setData(LocalDateTime data) {
	this.data = data;
}

public Tema getTema() {
	return tema;
	
	
}

public void setTema(Tema tema) {
	this.tema = tema;
}
	
	
	
}




