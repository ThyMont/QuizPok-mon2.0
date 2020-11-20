package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Pokemon;
import control.Tipo;
import model.MPokemon;

@WebServlet("/Pokemon")
public class PokemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			MPokemon mp = new MPokemon();
			List<Pokemon> lista = mp.listarTodos();
			request.setAttribute("lista-pokemon", lista);
			Pokemon p = new Pokemon(nome);
			List<Tipo> f = p.fraquezas();
			List<Tipo> r = p.resistencias();
			request.setAttribute("pokemon", p);
			request.setAttribute("fraquezas", f);
			request.setAttribute("resistencias", r);
			request.getRequestDispatcher("pokemon.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/National-dex").forward(request, response);
		}
	}

}
