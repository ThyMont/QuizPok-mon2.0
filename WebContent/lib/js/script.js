
function pokemonFactory(nome){
    let url = window.location.origin+ "/Projeto_Final_Step/Pokemon?nome="+nome;
    window.open(url,"_self");
}

oQuiz={
	alternativaCorreta: '',
	verificarResposta: function(alternativa){
	    if(alternativa==oQuiz.alternativaCorreta){
            $("#imgPergunta").addClass("apareceu");
            setTimeout(function(){ 
                alert("Você acertou!");
                $('#botaodesubmit').click();
            }, 500);
 	    }else{
            $("#imgPergunta").removeClass("apareceu"); 
            setTimeout(function(){ 
                alert("Errou =(");
                let url = window.location.origin+ "/Projeto_Final_Step/Quiz";
                window.open(url,"_self");  
            }, 500);
            
        }
	}
}

$(document).ready(function(){
    let _alternativacorreta = $('#respostaCorreta').val();
    oQuiz.alternativaCorreta = _alternativacorreta; 
});

function atualizarAvatar(avatar){
    document.getElementById('img-avatar').src = window.location.origin+ "/Projeto_Final_Step/lib/img/treinador/"+avatar+".png";
}

function atualizarPokemon(mascote){
    document.getElementById('img-mascote').src = window.location.origin+ "/Projeto_Final_Step/lib/img/pokemon/mascote/"+mascote+".png";
}