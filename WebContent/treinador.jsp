<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
					<%Treinador t = (Treinador) session.getAttribute("treinadorAutenticado");
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
                <div class="box-conteudo box-center">
                    <h1>Olá, <%out.print(t.getNome()); %></h1>
                    <h6>Você já registrou <%out.print(request.getAttribute("totalRegistros")); %> novos Pokémon!</h6>
                </div>

                <div class="box-conteudo">
                    <div id="formulario"> 
                        <form action="" method="post">
                            <label for="nome">Nome de treinador:</label>
                            <input type="hidden" name="id" value="<% out.print(t.getId());%>">
                            <input type="text"
                                id="nome" name="nome" maxlength="20" required
                                placeholder="Insira seu nome de usuário aqui" value="<%out.print(t.getNome()); %>"> <br>
                            <label for="data_nascimento">Data de Nascimento: </label> <input
                                type="date" required id="data_nascimento" name="data_nascimento" value="<% 
                                Date data = t.getData_nascimento();
                                DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                            	out.print(formatDate.format(data)); %>">
                            <br> <label for="avatar">Avatar</label> 
                            <select name="avatar" id="avatar" onchange="atualizarAvatar(this.value)">
                                <option value="RED" <%out.print(t.getAvatar().equals("RED")?" selected":""); %>>Red</option>
                                <option value="LEAF"<%out.print(t.getAvatar().equals("LEAF")?" selected":""); %>>Leaf</option>
                                <option value="ETHAN" <%out.print(t.getAvatar().equals("ETHAN")?" selected":""); %>>Ethan</option>
                                <option value="KRIS" <%out.print(t.getAvatar().equals("KRIS")?" selected":""); %>>Kris</option>
                                <option value="LUCAS" <%out.print(t.getAvatar().equals("LUCAS")?" selected":""); %>>Lucas</option>
                                <option value="MAY" <%out.print(t.getAvatar().equals("MAY")?" selected":""); %>>May</option>
                                <option value="LUCAS" <%out.print(t.getAvatar().equals("LUCAS")?" selected":""); %>>Lucas</option>
                                <option value="DAWN" <%out.print(t.getAvatar().equals("DAWN")?" selected":""); %>>Dawn</option>
                            </select>
                            <br> <label for="genero">Gênero: </label><br> <input
                                type="radio" id="male" name="genero" value="male" <%out.print(t.getGenero().equals("male")?" CHECKED":"");%>>
                            <label for="male">Homem</label><br> <input type="radio"
                                id="female" name="genero" value="female" <%out.print(t.getGenero().equals("female")?" CHECKED":"");%>> <label
                                for="female">Mulher</label><br> <input type="radio"
                                id="other" name="genero" value="other" <%out.print(t.getGenero().equals("other")?" CHECKED":"");%>> <label
                                for="other">Outro</label><br> <label for="mascote">Pokémon
                            Inicial</label> 
                            <select name="mascote" id="mascote" onchange="atualizarPokemon(this.value)">
                                <option value="Bulbasaur" <%out.print(t.getMascote().getNome().toUpperCase().equals("BULBASAUR")?" selected":""); %>>Bulbasaur</option>
                                <option value="Charmander" <%out.print(t.getMascote().getNome().toUpperCase().equals("CHARMANDER")?" selected":""); %>>Charmander</option>
                                <option value="Squirtle" <%out.print(t.getMascote().getNome().toUpperCase().equals("SQUIRTLE")?" selected":""); %>>Squirtle</option>
                                <option value="Pikachu" <%out.print(t.getMascote().getNome().toUpperCase().equals("PIKACHU")?" selected":""); %>>Pikachu</option>
                            </select>
                            <br> <label for="senha" >Senha</label> <input type="password"
                                id="senha" name="senha" required><br>
                                <input type="submit" value="Atualizar" formaction="UpdateTreinador" formmethod="POST">
                                <input type="submit" value="Excluir" formaction="DeletarTreinador" formmethod="POST">
                        </form>
                    </div>
                    <div class="box-imagens">
                   		<div class="avatar-box">
	                        <img id="img-avatar" src="./lib/img/treinador/<%out.print(t.getAvatar());%>.png" alt="Avatar" height="300px">
	                    </div>
	                     <div class="pokemon-box">
	                        <img id="img-mascote" src="./lib/img/pokemon/mascote/<%out.print(t.getMascote().getNome());%>.png" alt="Avatar" height="150px">
	                    </div>
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