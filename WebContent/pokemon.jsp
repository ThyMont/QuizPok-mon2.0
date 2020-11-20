<%@page import="java.util.List"%>
<%@page import="control.Pokemon"%>
<%@page import="control.Tipo"%>
<%@page import="control.Treinador"%>
<%@page import="control.Registro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Pokemon p = (Pokemon) request.getAttribute("pokemon");
	List<Tipo> fraquezas = (List<Tipo>) request.getAttribute("fraquezas");
	List<Tipo> resistencias = (List<Tipo>) request.getAttribute("resistencias");
	List<Pokemon> listaPokemon = (List<Pokemon>) request.getAttribute("lista-pokemon");
	List<Registro> listaRegistro = (List<Registro>) request.getSession().getAttribute("lista-registro");
	boolean visto = false;
	for(Registro r:listaRegistro){
		if (r.getPokemon().getId()==p.getId()){
			visto = true;
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PokéQUIZ - <%
	p.getNome();
%></title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="lib/css/estilo.css">
<script src="./lib/jquery/jquery.min.js"></script>
<script src="./lib/js/script.js"></script>
</head>
<body>
	<div id="background">
		<header>
			<div id="menu" class="container">
				<ul>
					<li><a href="index.jsp" class="primeiro">Home</a></li>
					<li><a href="National-dex">Pokédex</a></li>
					<li><a href="Quiz">Quiz</a></li>
					<li><a href="Treinador">Treinador</a></li>
					<%
						try {
						Treinador t = (Treinador) session.getAttribute("treinadorAutenticado");
						if (t.getNome().toUpperCase().equals("THYMONT") || t.getNome().toUpperCase().equals("ADMIN")) {
							out.print("<li><a href=\"Administrador\">Administrador</a></li>");
						}
					} catch (Exception e) {
					}
					%>
				</ul>
			</div>
		</header>
		<div id="separador-menu"></div>
		<div id="conteudo">
			<div class="container">
				<!--Início do conteúdo da página-->

				<div class="box-conteudo" >
					<select name="nome" id="lista-pokedex" onChange="pokemonFactory(this.value)">
						<%
							for (int i = 0; i < listaPokemon.size(); i++) {
							Pokemon po = listaPokemon.get(i);
							out.print("<option value=\"" + po.getNome() + "\" " + (po.getId() == p.getId() ? "selected" : "") + ">"
							+ po.getDex_number() + " - " + po.getNome() + "</option>");
						}
						%>
					</select>

					<div class="box-conteudo box-pokemon">
						<%
							out.print("<img src=\"./lib/img/pokemon/" + p.getDex_number().substring(1) + p.getNome() + ".png\" alt=\""
								+ p.getDex_number() + "-" + p.getNome() + "\" class=\"img-pokedex "+(visto?"visto":"nao-visto") +"\">");
						%>
					</div>
					<div class="box-conteudo box-pokedex">
						<h1>
							<%
								out.print(p.getDex_number().substring(1) + " - " + p.getNome());
							%>
						</h1>
						<br>
						<h3>
							Categoria:
							<%
							out.print(visto?"Pokémon " + p.getCategoria():"?????");
						%>
						</h3>
						<br>
						<div class="tipo">
							<%
								out.print(visto?"<img src=\"./lib/img/tipos/" + p.getTipo1() + ".png\" class=\"tipo-img\" alt=\"tipo1\" title=\""
									+ p.getTipo1() + "\">"
									+ (!p.getTipo2().toString().toUpperCase().equals("NOTYPE")
									? "<img src=\"./lib/img/tipos/" + p.getTipo2() + ".png\" class=\"tipo-img\" alt=\"tipo2\" title=\""
											+ p.getTipo2() + "\"><br>\""
									: ""):"");
							%>
						</div>
						<hr>
						<br>
						<p>
							<b>Altura:</b>
							<%
								out.print(visto?p.getAltura():"????");
							%>
							m <br> <b>Peso:</b>
							<%
								out.print(visto?p.getPeso():"????");
							%>
							kg
						</p>
						<p>
							<b>Descrição: </b>
							<%
								out.print(visto?p.getDescricao():"????");
							%>
						</p>
						<hr>

						<%
							if (!fraquezas.isEmpty()&&visto) {
							out.print("<h4>Fraquezas</h4><br>");
							out.print("<div class=\"tipo\"> ");
							for (Tipo t : fraquezas) {
								out.print("<img src=\"./lib/img/tipos/" + t + ".png\" class=\"tipo-img\" alt=\"tipo1\" title=\"" + t + "\">");
							}
							out.print("<br></div><hr>");
						}
						%>
						<%
							if (!resistencias.isEmpty()&&visto) {
							out.print("<h4>Resistências</h4><br>");
							out.print("<div class=\"tipo\"> ");
							for (Tipo t : resistencias) {
								out.print("<img src=\"./lib/img/tipos/" + t + ".png\" class=\"tipo-img\" alt=\"tipo1\" title=\"" + t + "\">");
							}
							out.print("<br></div>");
						}
						%>
					</div>
					<div class="clear"></div>
				</div>

				<!--Fim do conteúdo da página-->
			</div>
		</div>
		<footer>
			<p>
				Desenvolvido por <a href="http://github.com/thymont">ThyMont</a> -
				2020
			</p>
		</footer>
	</div>
</body>
</html>