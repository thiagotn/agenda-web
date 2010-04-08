package br.com.agenda.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.agenda.jdbc.dao.UsuarioDAO;
import br.com.agenda.modelo.Mensagem;
import br.com.agenda.modelo.Usuario;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		List<Mensagem> errors = new ArrayList<Mensagem>();
		
		String login = request.getParameter("login").trim();
		String senha = request.getParameter("senha").trim();
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.autenticar(login, senha);
		
		RequestDispatcher rd;
		
		if(usuario != null){
			session.setAttribute("usuarioWeb", usuario);
			rd = request.getRequestDispatcher("/contato/lista.view");	
		} else {
			errors.add(new Mensagem("autenticacao","Login ou senha inválidos"));
			request.setAttribute("errors", errors);
			rd = request.getRequestDispatcher("/login.jsp");
		}
		rd.forward(request, response);
	}
}
