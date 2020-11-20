package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Registro;
import control.Treinador;

@WebServlet("/DeletarTreinador")
public class DeletarTreinadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Treinador t = (Treinador) request.getSession().getAttribute("treinadorAutenticado");
		Registro r = new Registro();
		r.deletar(t);
		t.deletar();
		request.getSession().setAttribute("treinadorAutenticado", null);
		response.sendRedirect("index.jsp");
	}

}
