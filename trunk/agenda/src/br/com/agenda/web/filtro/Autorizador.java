package br.com.agenda.web.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.agenda.modelo.Usuario;

public class Autorizador implements Filter {

	private String urlRequisitada;
	
	@Override
	public void destroy() {
		System.out.println("Finalizando Filtro Autorizador");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		urlRequisitada = httpRequest.getRequestURI();
		
		if((urlRequisitada.contains("login.view")) || (urlRequisitada.contains("logout.view")) ){
			chain.doFilter(request, response);
		} else {
			Usuario usuario = (Usuario) session.getAttribute("usuarioWeb");
			if(usuario != null) {
				chain.doFilter(request, response);
			} else {
				httpResponse.sendRedirect("/agenda/login.jsp");
			}	
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Iniciando Filtro Autorizador");
	}
}
