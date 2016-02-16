package br.agrego.poker.util;

import br.agrego.poker.domain.Carta;
import br.agrego.poker.domain.Jogador;
import br.agrego.poker.domain.MyException;

public class JogadorFactory {

	/**
	 * 
	 * @param nome do jogador
	 * @param cartas devem ser sepadadas por espaço e nomeadas com o valor seguido de uma das letras representando o nipe
	 * 	P=Paus, C=Copas, O=Ouros, E=Espada
	 * @return retorna o Jogador
	 * @throws MyException quando o nome é inválido ou quando a quantidade de cartas é inválida para o jogador
	 */
	public static Jogador constroiJogador(String nome, String cartas) throws MyException {
		Jogador jogador = new Jogador(nome);
		
		String[] _cartas = cartas.split(" ");
		
		if (nome==null || nome.length()==0) throw new MyException("Nome inválido para o jogador");
		if (_cartas.length!=5) throw new MyException("Quantidade de Cartas Inválidas para o jogador " + nome);
		
		for (String carta : _cartas) {
			jogador.addCarta(new Carta(carta));
		}
		
		if (jogador.getCartas().size()!=5) throw new MyException("Quantidade de Cartas Inválidas para o jogador " + nome);
		
		return jogador;
	}
}
