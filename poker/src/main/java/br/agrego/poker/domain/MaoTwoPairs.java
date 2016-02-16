package br.agrego.poker.domain;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Two Pairs: A mão contém 2 pares diferentes. Quando as mãos de ambos contêm 2 pares são classificados pelo valor de seu par mais alto. 
 * Mãos com o mesmo par mais alto são classificados pelo valor do seu outro par. 
 * Se estes os valores são os mesmos as mãos são classificados pelo valor da carta restante.
 */
public class MaoTwoPairs extends Mao {
	
	public MaoTwoPairs(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		EValor primeiroPar = null;
		for (Carta carta1 : getCartas()) {
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor() && primeiroPar!=carta1.getValor()) {
					if (primeiroPar==null) {
						primeiroPar = carta1.getValor();						
					}else {
						return this;
					}
				}
			}
		}
		return proximo().avalia(getCartas());
	}
	
	@Override
	public String toString() {
		return "Two Pairs";
	}

	@Override
	public int desempate(Mao other) {
		Set<Carta> duqueThis = separaDuques(getCartas());
		Set<Carta> duqueOther = separaDuques(other.getCartas());
		
		Carta cartaThis=null;
		Carta cartaOther=null;
		for (Iterator<Carta> iThis = duqueThis.iterator(), iOther = duqueOther.iterator(); iThis.hasNext();) {
			cartaThis = iThis.next();
			cartaOther = iOther.next();

			if (cartaThis.getValor()==cartaOther.getValor()) continue;
			if (cartaThis.getValor().getValor()>cartaOther.getValor().getValor()) {
				setCartaDesempate(cartaThis);
				return 1;
			}
			if (cartaThis.getValor().getValor()<cartaOther.getValor().getValor()) {
				setCartaDesempate(cartaOther);
				return -1;
			}
			
		}
		
		setCartaDesempate(cartaThis);
		return 0;
	}
	
	private Set<Carta> separaDuques(Set<Carta> cartas){ 
		TreeSet<Carta> duque = new TreeSet<Carta>();
		
		EValor primeiroPar = null;
		for (Carta carta1 : getCartas()) {
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor() && primeiroPar!=carta1.getValor()) {
					if (primeiroPar==null) {
						duque.add(carta1);
						primeiroPar = carta1.getValor();						
					}else {
						duque.add(carta1);
					}
				}
			}
		}
		return duque;
		
	}


}
