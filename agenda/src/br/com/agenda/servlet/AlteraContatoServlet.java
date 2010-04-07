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

import br.com.agenda.jdbc.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;

@SuppressWarnings("serial")
public class AlteraContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco =request.getParameter("endereco");
		
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		// fazendo a convers�o da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			//out.println("Erro ao converter a data");
			return; // retorna para a execu��o do m�todo
		}
		
		// Instancia Contato
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		// Instancia ContatoDAO
		ContatoDAO dao = new ContatoDAO();
		dao.altera(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/contato/lista.view");
		rd.forward(request, response);
	}
}
