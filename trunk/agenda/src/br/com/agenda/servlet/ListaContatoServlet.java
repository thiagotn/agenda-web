package br.com.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.jdbc.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;

@SuppressWarnings("serial")
public class ListaContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		
		request.setAttribute("contatos", contatos);	
				
		RequestDispatcher rd = request.getRequestDispatcher("/contato/lista.jsp");
		rd.forward(request, response);
	}
}
