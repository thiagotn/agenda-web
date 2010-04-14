package br.com.agenda.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.agenda.jdbc.dao.ContatoDAO;
import br.com.agenda.mail.Mensageiro;
import br.com.agenda.mail.Mensagem;
import br.com.agenda.modelo.Contato;
import br.com.agenda.modelo.Usuario;

@SuppressWarnings("serial")
public class AdicionaContatoServlet extends HttpServlet {
 //asdfsadfa
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioWeb");
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco =request.getParameter("endereco");
		
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		// fazendo a conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			System.out.println("Erro ao converter a data");
			return; // retorna para a execução do método
		}
		
		// Instancia Contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		contato.setUsuario(usuario);
		
		// Instancia ContatoDAO
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		
		enviarEmailNovoUsuario(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/contato/lista.view");
		rd.forward(request, response);
	}
	
	public void enviarEmailNovoUsuario(Contato contato){
		Mensageiro mensageiro = new Mensageiro();
		String template = mensageiro.carregaTemplate("/novocontato.mail");
		String mensagemTxt = String.format(template,contato.getNome(),contato.getEmail());
		Mensagem mensagem = new Mensagem();
		mensagem.setPara(contato.getEmail());
		mensagem.setAssunto("Olá " + contato.getNome() +  " - Você foi adicionado a Agenda Web");
		mensagem.setMensagem(mensagemTxt);
		mensageiro.enviarMensagem(mensagem);
	}

}
