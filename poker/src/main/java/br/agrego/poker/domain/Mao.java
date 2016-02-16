package br.agrego.poker.domain;

import java.util.Set;

public abstract class Mao {

	private Carta cartaDesempate;
	private Mao	mao;
	private final Integer	ponto;
	private Set<Carta>	cartas;
	
	public Mao(Integer ponto) {
		this.ponto = ponto;
	}

	protected abstract Mao executa() ;
	
	public Mao avalia(Set<Carta> cartas) {
		this.cartas = cartas;
		return executa();
	}
	
	public void setProximo(Mao mao) {
		this.mao = mao;
	}

	@Override
	public abstract String toString() ;

	public Integer getPonto() {
		return ponto;
	}
	
	public abstract int desempate(Mao other) ;

	public Set<Carta> getCartas() {
		return cartas;
	}		
	
	public Mao proximo() {
		return this.mao;
	}

	public Carta getCartaDesempate() {
		return cartaDesempate;
	}

	public void setCartaDesempate(Carta cartaDesempate) {
		this.cartaDesempate = cartaDesempate;
	}
}