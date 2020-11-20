<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="control.Treinador"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PokéQUIZ - Início</title>
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
						try{
							Treinador t = (Treinador) session.getAttribute("treinadorAutenticado");
							if (t.getNome().toUpperCase().equals("THYMONT") || t.getNome().toUpperCase().equals("ADMIN")) {
								out.print("<li><a href=\"Administrador\">Administrador</a></li>");
							}
						} catch(Exception e){
						}
					%>
				</ul>
			</div>
		</header>
		<div id="separador-menu"></div>
		<div id="conteudo">
			<div class="container">
				<!--Início do conteúdo da página-->
				<div class="box-conteudo">
					<a href="cadastro_treinador.html">Cadastro</a><br> <a
						href="autenticador">Sair</a>
				</div>

				<div class="box-conteudo">
					<p>Pokem ipsum dolor sit amet Ninetales Pokemon Blastoise
						Kirlia Bug Pignite. Pikachu Heatmor Pokemon The Movie 2000 Fraxure
						Braviary Super Potion Leech Life. Pokemon The Movie 2000 ut enim
						ad minim veniam Remoraid Slowking Golbat Ice Piplup. Rock
						Gardevoir Yamask Scratch Abomasnow Kanto Lopunny. Water Shuckle
						lorem ipsum dolor sit amet Octillery Metagross Pokemon Dragonair.
					</p>
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