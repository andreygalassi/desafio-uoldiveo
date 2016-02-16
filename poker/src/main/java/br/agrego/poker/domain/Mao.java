package br.agrego.poker.domain;

import java.util.Set;

public abstract class Mao {

	protected Mao	mao;
	private final Integer	ponto;
	
	public Mao(Integer ponto) {
		this.ponto = ponto;
	}

	public abstract Mao avalia(Set<Carta> cartas) ;
	
	public void setProximo(Mao mao) {
		this.mao = mao;
	}

	@Override
	public abstract String toString() ;

	public Integer getPonto() {
		return ponto;
	}
}