package br.com.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.agenda.jdbc.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;
import br.com.agenda.modelo.Usuario;

@SuppressWarnings("serial")
public class ListaContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioWeb");
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = dao.getLista(usuario);
		
		request.setAttribute("contatos", contatos);	
				
		RequestDispatcher rd = request.getRequestDispatcher("/contato/lista.jsp");
		rd.forward(request, response);
	}
}
