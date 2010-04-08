package br.com.agenda.modelo;

public class Mensagem {

	private String categoria;
	private String mensagem;
	
	public Mensagem(){
		
	}

	public Mensagem(String categoria, String mensagem){
		this.categoria = categoria;
		this.mensagem = mensagem;
	}	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
