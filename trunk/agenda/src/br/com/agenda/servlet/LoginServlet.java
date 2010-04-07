package br.com.agenda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.agenda.jdbc.dao.UsuarioDAO;
import br.com.agenda.modelo.Usuario;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.autenticar(login, senha);
		
		RequestDispatcher rd;
		
		if(usuario != null){
			session.setAttribute("usuarioWeb", usuario);
			rd = request.getRequestDispatcher("/contato/lista.view");	
		} else {
			rd = request.getRequestDispatcher("/agenda/login.jsp");
		}
		rd.forward(request, response);
	}
}
