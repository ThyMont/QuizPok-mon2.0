<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PokéQUIZ - Login</title>
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
				</ul>
			</div>
		</header>
		<div id="separador-menu"></div>
		<div id="conteudo">
			<div class="container">
				<div class="box-conteudo box-center">
				<p>Bem vindo ao <strong>PokéQuiz</strong>!<br>
				Um quiz onde cada resposta correta é um Pokémon capturado!
				Entre e divirta-se!
				</p>
				</div>
				<div class="box-conteudo box-center">
					<fieldset>
						<h2>Login</h2>
						<form action="autenticador" method="post">
							<label for="nome">Treinador: </label> <input type="text"
								id="nome" name="nome" placeholder="Nome de usuário"> <br>
							<label for="senha">Senha</label> <input type="password"
								id="senha" name="senha" placeholder="Senha">
							<br>
							<input type="submit" value="Logar"><br>
							
								<%
									if(request.getAttribute("msgErro")!=null) {
										out.print("<strong>Usuário ou senha incorretos</strong>");
									}
								%>
						</form>
					</fieldset>
					<p>
						Não possui cadastro? <a href="cadastro_treinador.html">Clique
							Aqui!</a>
					</p>
				</div>
				
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