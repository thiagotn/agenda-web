package br.com.agenda.modelo;

import java.util.Calendar;

public class Contato {
	
	// atributos
	private Integer id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	private Usuario usuario;
	
	// métodos getters e setters
	public String getNome(){
		return this.nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEndereco(){
		return this.endereco;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
