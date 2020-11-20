package servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.Treinador;

@WebFilter("/*")
public class FiltroAutenticar implements Filter {

	public FiltroAutenticar() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// HttpSession sessao = request.getSession();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		String url = httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession();

		if (sessao.getAttribute("treinadorAutenticado") != null || url.lastIndexOf("login.jsp") > -1
				|| url.lastIndexOf("index.jsp") > -1 || url.lastIndexOf("autenticador") > -1
				|| url.lastIndexOf("CadastrarTreinador") > -1 || url.lastIndexOf("cadastro_treinador") > -1 ) {
			chain.doFilter(request, response);
		} else if (url.toUpperCase().lastIndexOf("ADMINISTRADOR") > -1) {
			Treinador t = (Treinador) sessao.getAttribute("treinadorAutenticado");

			if (t.getNome().toUpperCase().equals("THYMONT") || t.getNome().toUpperCase().equals("ADMIN")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect("index.jsp");
			}
		} else if (url.lastIndexOf("lib/") > -1) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
