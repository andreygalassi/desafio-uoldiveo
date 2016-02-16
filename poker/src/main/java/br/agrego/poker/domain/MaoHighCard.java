package br.agrego.poker.domain;

import java.util.Iterator;
import java.util.Set;

/**
 * High Card: Mãos que não se encaixam qualquer categoria superior são classificado pelo valor de sua carta mais alta. 
 * Se o maior carta têm o mesmo valor, o valor eh definida pela próximo carta mais elevada, e assim por diante.
 */
public class MaoHighCard extends Mao{

	public MaoHighCard(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao avalia(Set<Carta> cartas) {
		return this;
	}
	
	@Override
	public String toString() {
		return "High Card";
	}

	@Override
	public int desempate(Set<Carta> cartas1, Set<Carta> cartas2) {
		for (Iterator<Carta> iterator1 = cartas1.iterator(), iterator2 = cartas2.iterator(); iterator1.hasNext(); iterator2.hasNext()) {
			Carta carta1 = iterator1.next(); 
			Carta carta2 = iterator2.next();
			if (carta1.getValor()==carta2.getValor()) continue;
			if (carta1.getValor().getValor()>carta2.getValor().getValor()) return 1;
			if (carta1.getValor().getValor()<carta2.getValor().getValor()) return -1;
			
		}
		
		return 0;
	}

}