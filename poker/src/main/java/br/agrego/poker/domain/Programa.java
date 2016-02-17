package br.agrego.poker.domain;

import br.agrego.poker.exception.MyException;
import br.agrego.poker.util.JogadorFactory;



public class Programa {
	
	public static void main(String[] args) {
	
		Jogador black;
		Jogador white;
		try {
			black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 7P");
			white = JogadorFactory.constroiJogador("White", "AP 2C 3O 4E 8P");
			Juiz juiz = new Juiz(black, white);
			System.out.println(juiz.avalia());
			
			black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 7P");
			white = JogadorFactory.constroiJogador("White", "AP 2C 3O 4E 8P");
			juiz = new Juiz(black, white);
			System.out.println(juiz.avalia());
			
			black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 7P");
			white = JogadorFactory.constroiJogador("White", "AP 2C 3O 4E 8P");
			juiz = new Juiz(black, white);
			System.out.println(juiz.avalia());
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		
//		
//		
////		Set<Carta> cartas = new LinkedHashSet<Carta>();
//		Set<Carta> cartas = new TreeSet<Carta>();
//
//		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
//		cartas.add(new Carta(ENaipe.COPAS, EValor.CINCO));
//		cartas.add(new Carta(ENaipe.ESPADA, EValor.AS));
//		cartas.add(new Carta(ENaipe.COPAS, EValor.DEZ));
//		cartas.add(new Carta(ENaipe.OUROS, EValor.DAMA));
//
//		Set<Carta> cartas2 = new TreeSet<Carta>();
//		
//		cartas2.add(new Carta(ENaipe.COPAS, EValor.DOIS));
//		cartas2.add(new Carta(ENaipe.COPAS, EValor.CINCO));
//		cartas2.add(new Carta(ENaipe.ESPADA, EValor.CINCO));
//		cartas2.add(new Carta(ENaipe.COPAS, EValor.DEZ));
//		cartas2.add(new Carta(ENaipe.OUROS, EValor.DEZ));
//		
//		
//		Mao m1 = new MaoTwoPairs();
//		Mao m2 = new MaoPairs();
//		Mao m3 = new MaoHighCard();
//		
//		m1.setProximo(m2);
//		m2.setProximo(m3);
//		
//		System.out.println(m1.avalia(cartas).toString());
//		System.out.println(m1.avalia(cartas2).toString());
		
	}
}
