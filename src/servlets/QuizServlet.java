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
import control.quiz.Quiz;
import model.MPokemon;
import model.MRegistro;

@WebServlet("/Quiz")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Treinador t = (Treinador) sessao.getAttribute("treinadorAutenticado");
		List<Registro> listaRegistro = new MRegistro().listarTodos(t);

		List<Pokemon> lista = new MPokemon().listarTodos();
		Quiz q = new Quiz(lista);

		request.setAttribute("totalRegistros", listaRegistro.size());
		request.setAttribute("Quiz", q);
		sessao.setAttribute("Quiz", q);
		request.getRequestDispatcher("quiz.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Treinador t = (Treinador) sessao.getAttribute("treinadorAutenticado");
		Quiz q = (Quiz) sessao.getAttribute("Quiz");
		Pokemon p = q.getRespostaCorreta();
		System.out.println(p);
		Registro r = new Registro(t, p);
		r.cadastrar();
		response.sendRedirect("Quiz");
	}

}
