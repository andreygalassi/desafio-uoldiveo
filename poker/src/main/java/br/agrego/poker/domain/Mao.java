package br.agrego.poker.domain;

import java.util.Set;

public abstract class Mao {

	protected Mao	mao;

	public abstract Mao avalia(Set<Carta> cartas) ;
	
	public void setProximo(Mao mao) {
		this.mao = mao;
	}

	@Override
	public abstract String toString() ;

}