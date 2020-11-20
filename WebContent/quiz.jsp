<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="control.Treinador"%>
<%@page import="control.quiz.Quiz"%>

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
						Treinador t = (Treinador) session.getAttribute("treinadorAutenticado");;
						try{ 
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

				<div class="box-conteudo quiz">
					<h3>Bem vindo, <%t.getNome(); %>!</h3>
					<h3>Quantidade de pokémon encontrados: <%out.print(request.getAttribute("totalRegistros")); %></h3>

				</div>
				<div class="box-conteudo box-center quiz">
					<h1>Quem é este Pokémon?</h1>
				</div>
				<%Quiz q = (Quiz) request.getAttribute("Quiz"); %>
				<div class="box-conteudo box-center">
					<div class="quiz">
						<div class="caixa-img box-center tipo1-<%out.print(q.getRespostaCorreta().getTipo1());%> tipo2-<%out.print(q.getRespostaCorreta().getTipo2());%>">   
							<img src="./lib/img/pokemon/<%out.print(q.getRespostaCorreta().getDex_number().substring(1) + q.getRespostaCorreta().getNome());%>.png" class="img-quiz oculto" id="imgPergunta" alt="Quem é este pokémon?" title="Quem é este Pokémon?">
						</div>
						<form action="Quiz" method="post">
						<div class="opcoes">
							<button type="button" class="btn btn-secondary opcao" name="opcaoA" value="<%out.print(q.getOpcaoA().getNome());%>" onclick="oQuiz.verificarResposta(this.value)"> <%out.print(q.getOpcaoA().getNome());%></button>
							<button type="button" class="btn btn-secondary opcao" name="opcaoB" value="<%out.print(q.getOpcaoB().getNome());%>" onclick="oQuiz.verificarResposta(this.value)"> <%out.print(q.getOpcaoB().getNome());%></button>
							<button type="button" class="btn btn-secondary opcao" name="opcaoC" value="<%out.print(q.getOpcaoC().getNome());%>" onclick="oQuiz.verificarResposta(this.value)"> <%out.print(q.getOpcaoC().getNome());%></button>
							<button type="button" class="btn btn-secondary opcao" name="opcaoD" value="<%out.print(q.getOpcaoD().getNome());%>" onclick="oQuiz.verificarResposta(this.value)"> <%out.print(q.getOpcaoD().getNome());%></button>
							<input type="hidden" name="respostaCorreta" id="respostaCorreta" value="<%out.print(q.getRespostaCorreta().getNome());%>" >
							<input hidden type="submit" id="botaodesubmit">
						</div>
						</form>
                    </div>                
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