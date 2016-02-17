package br.agrego.poker.view;

import java.util.Scanner;

import br.agrego.poker.domain.Jogador;
import br.agrego.poker.domain.Juiz;
import br.agrego.poker.exception.MyException;
import br.agrego.poker.util.JogadorFactory;



public class Programa {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String nmJogador1;
		String nmJogador2;
		String cartasJogador1;
		String cartasJogador2;
		
		System.out.print("Nome do Jogador1: ");
		nmJogador1 = sc.nextLine();

		System.out.print("Nome do Jogador2: ");
		nmJogador2 = sc.nextLine();
		
		System.out.println("As cartas devem ser digitadas separadas por espaço e um total de 5 cartas válidas.");
		
		System.out.print("Cartas do Jogador1: ");
		cartasJogador1 = sc.nextLine().toUpperCase();
		
		System.out.print("Cartas do Jogador2: ");
		cartasJogador2 = sc.nextLine().toUpperCase();
		
		try {
			Jogador jogador1 = JogadorFactory.constroiJogador(nmJogador1, cartasJogador1);
			Jogador jogador2 = JogadorFactory.constroiJogador(nmJogador2, cartasJogador2);
			
			Juiz juiz = new Juiz(jogador1, jogador2);
			
			System.out.println(juiz.avalia());
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
