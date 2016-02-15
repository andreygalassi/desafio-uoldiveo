package br.agrego.poker.domain;

import java.util.Set;


public interface IMao {
	public IMao avalia(Set<Carta> cartas);
	public void setProximo(IMao mao);
}
