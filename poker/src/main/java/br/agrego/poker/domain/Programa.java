package br.agrego.poker.domain;

import java.util.Set;
import java.util.TreeSet;


public class Programa {
	
	public static void main(String[] args) {
	
//		Set<Carta> cartas = new LinkedHashSet<Carta>();
		Set<Carta> cartas = new TreeSet<Carta>();

		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.AS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.DEZ));
		cartas.add(new Carta(ENaipe.OUROS, EValor.DAMA));

		Set<Carta> cartas2 = new TreeSet<Carta>();
		
		cartas2.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas2.add(new Carta(ENaipe.COPAS, EValor.CINCO));
		cartas2.add(new Carta(ENaipe.ESPADA, EValor.CINCO));
		cartas2.add(new Carta(ENaipe.COPAS, EValor.DEZ));
		cartas2.add(new Carta(ENaipe.OUROS, EValor.DEZ));
		
		
		Mao m1 = new MaoTwoPairs();
		Mao m2 = new MaoPairs();
		Mao m3 = new MaoHighCard();
		
		m1.setProximo(m2);
		m2.setProximo(m3);
		
		System.out.println(m1.avalia(cartas).toString());
//		System.out.println(m1.avalia(cartas2).toString());
		
	}
}
