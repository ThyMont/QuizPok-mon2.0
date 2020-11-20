package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.Treinador;

@WebServlet("/autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		Treinador t = new Treinador(nome, senha);
		Treinador treinadorAutenticado;
		if (t.autenticar()) {
			treinadorAutenticado = t;
			HttpSession sessao = request.getSession();
			sessao.setAttribute("treinadorAutenticado", treinadorAutenticado);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			treinadorAutenticado = null;
			request.setAttribute("msg", "Usu�rio ou senha incorretos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
