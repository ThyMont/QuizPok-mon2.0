package control.quiz;

import java.util.List;
import java.util.Random;

import control.Pokemon;

public class Quiz {
	private Pokemon pergunta;
	private Pokemon respostaCorreta;
	private Pokemon opcaoA;
	private Pokemon opcaoB;
	private Pokemon opcaoC;
	private Pokemon opcaoD;
	
	public Quiz(List<Pokemon> lista) {
		gerarQuiz(lista);
	}
	

	public void gerarQuiz(List<Pokemon> lista) {
		Random r = new Random();
		int total = lista.size();
		this.respostaCorreta = lista.get(r.nextInt(total));
		this.pergunta = respostaCorreta;
		int i = r.nextInt(4);
		switch (i) {
		case 0:{
			opcaoA = respostaCorreta;
			opcaoB = respostaErrada(lista, r);
			do {
				opcaoC=respostaErrada(lista, r);
			}while(opcaoC.getId()==opcaoB.getId());
			do {
				opcaoD=respostaErrada(lista, r);
			}while(opcaoD.getId()==opcaoB.getId()||opcaoD.getId()==opcaoC.getId());
			
			break;
		}
		case 1:{
			opcaoB = respostaCorreta;
			opcaoC = respostaErrada(lista, r);
			do {
				opcaoD=respostaErrada(lista, r);
			}while(opcaoD.getId()==opcaoC.getId());
			do {
				opcaoA=respostaErrada(lista, r);
			}while(opcaoA.getId()==opcaoC.getId()||opcaoA.getId()==opcaoD.getId());
			break;
		}
		case 2:{
			opcaoC = respostaCorreta;
			opcaoD = respostaErrada(lista, r);
			do {
				opcaoA=respostaErrada(lista, r);
			}while(opcaoA.getId()==opcaoD.getId());
			do {
				opcaoB=respostaErrada(lista, r);
			}while(opcaoB.getId()==opcaoD.getId()||opcaoA.getId()==opcaoA.getId());
			break;
		}
		case 3:{
			opcaoD = respostaCorreta;
			opcaoA = respostaErrada(lista, r);
			do {
				opcaoB=respostaErrada(lista, r);
			}while(opcaoB.getId()==opcaoA.getId());
			do {
				opcaoC=respostaErrada(lista, r);
			}while(opcaoC.getId()==opcaoA.getId()||opcaoC.getId()==opcaoB.getId());
			break;
		}
		}
	}

	private Pokemon respostaErrada(List<Pokemon> lista, Random r) {
		int total = lista.size();
		Pokemon respostaErrada;
		do{
			respostaErrada = lista.get(r.nextInt(total));
		} while (respostaErrada.getId()==respostaCorreta.getId());
		return respostaErrada;
	}

	public Pokemon getPergunta() {
		return pergunta;
	}

	public Pokemon getRespostaCorreta() {
		return respostaCorreta;
	}

	public Pokemon getOpcaoA() {
		return opcaoA;
	}

	public Pokemon getOpcaoB() {
		return opcaoB;
	}

	public Pokemon getOpcaoC() {
		return opcaoC;
	}

	public Pokemon getOpcaoD() {
		return opcaoD;
	}

}
