package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.Pokemon;
import control.Treinador;

@WebServlet("/CadastrarTreinador")
public class CadastrarTreinadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarTreinadorServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Treinador t;
		String nome = request.getParameter("nome");
		Date data_nascimento = null;
		try {
			data_nascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_nascimento"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String avatar = request.getParameter("avatar");
		String genero = request.getParameter("genero");
		Pokemon mascote = new Pokemon(request.getParameter("mascote"));
		String senha = request.getParameter("senha");

		t = new Treinador(nome, data_nascimento, avatar, genero, mascote, senha);
		Treinador treinadorAutenticado;
		HttpSession sessao = request.getSession();
		if (t.cadastrar()) {
			treinadorAutenticado = t;
			sessao.setAttribute("treinadorAutenticado", treinadorAutenticado);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			treinadorAutenticado = null;
			sessao.setAttribute("treinadorAutenticado", treinadorAutenticado);
			request.getRequestDispatcher("cadastro_treinador.html").forward(request, response);
		}
	}

}
