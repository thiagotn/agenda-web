package br.com.agenda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.jdbc.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;

@SuppressWarnings("serial")
public class RemoveContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		ContatoDAO dao = new ContatoDAO();
		Contato contato = dao.pesquisar(id);
		dao.remove(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contato.view");
		rd.forward(request, response);
	}
}
