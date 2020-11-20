package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Registro;
import control.Treinador;
import model.MRegistro;

@WebServlet("/Treinador")
public class TreinadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Treinador t = (Treinador) request.getSession().getAttribute("treinadorAutenticado");
		List<Registro> listaRegistro = new MRegistro().listarTodos(t);

		request.setAttribute("treinador", t);
		request.setAttribute("totalRegistros", listaRegistro.size());
		request.getRequestDispatcher("treinador.jsp").forward(request, response);
		;
	}

}
