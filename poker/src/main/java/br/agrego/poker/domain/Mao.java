package br.agrego.poker.domain;

import java.util.Set;

/**
 * Foi decidido usar o padrão Chain of Responsibility para a classificação de cada mão de jogador.
 * @author Andrey
 *
 */
public abstract class Mao {

	private EValor valorDesempate;
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

	public EValor getValorDesempate() {
		return valorDesempate;
	}

	public void setValorDesempate(EValor cartaDesempate) {
		this.valorDesempate = cartaDesempate;
	}
}