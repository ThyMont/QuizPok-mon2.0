package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.Pokemon;
import control.Registro;
import control.Treinador;
import model.MPokemon;
import model.MRegistro;

@WebServlet("/National-dex")
public class PokedexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MPokemon mp = new MPokemon();
		List<Pokemon> lista = mp.listarTodos();
		request.setAttribute("lista-pokemon", lista);
		
		HttpSession sessao = request.getSession();
		MRegistro mr = new MRegistro();
		List<Registro> listaRegistros =  mr.listarTodos((Treinador) sessao.getAttribute("treinadorAutenticado"));
		request.setAttribute("lista-registro", listaRegistros);
		sessao.setAttribute("lista-registro", listaRegistros);
		
		request.getRequestDispatcher("pokedex.jsp").forward(request, response);
		
	}

}
