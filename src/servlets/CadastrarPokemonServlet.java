package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Pokemon;
import control.Tipo;

@WebServlet("/CadastrarPokemonServlet")
public class CadastrarPokemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarPokemonServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pokemon p;

		String nome = request.getParameter("nome");
		String dex_number = request.getParameter("dex_number");
		String categoria = request.getParameter("categoria");
		String descricao = request.getParameter("descricao");
		Double altura = Double.parseDouble(request.getParameter("altura"));
		Double peso = Double.parseDouble(request.getParameter("peso"));
		Integer geracao = Integer.parseInt(request.getParameter("geracao"));
		Tipo tipo1 = new Tipo(request.getParameter(request.getParameter("tipo1")));
		Tipo tipo2 = new Tipo(request.getParameter(request.getParameter("tipo2")));

		p = new Pokemon(dex_number, nome, categoria, descricao, altura, peso, geracao, tipo1, tipo2);
		if (p.cadastrar()) {
			request.getRequestDispatcher("cadastroSucesso.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
