package br.agrego.poker.domain;

import java.util.HashSet;
import java.util.Set;

import br.agrego.poker.exception.MyException;
import br.agrego.poker.util.MaoFactory;

/**
 * O juiz é o responsável pelo resultado da disputa.
 * @author Andrey
 *
 */
public class Juiz {

	private static final String	TIE	= " tie ";
	private static final String	WINS	= " wins ";
	
	private final Jogador	jogador1;
	private final Jogador	jogador2;
	private final Mao	mao1;
	private final Mao	mao2;
	
	private Mao maoVencedora;
	private Boolean empate;
	private Jogador jogadorVencedor;

	public Juiz(Jogador jogador1, Jogador jogador2) throws MyException {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		
		validaCartasDasMaos(jogador1.getCartas(),jogador2.getCartas());
		
		this.mao1 = MaoFactory.controiMao();
		this.mao2 = MaoFactory.controiMao();
		
		this.empate=false;
		this.maoVencedora=null;
		this.jogadorVencedor=null;
	}
	
	private void validaCartasDasMaos(Set<Carta> cartas1, Set<Carta> cartas2) throws MyException {
		Set<Carta> deck = new HashSet<Carta>();
		deck.addAll(cartas1);
		deck.addAll(cartas2);
		if (deck.size()!=10) throw new MyException("Cartas repetidas em alguma Mão ou quantidade invalida de cartas para um dos jogadores.");
		
	}

	public String avalia() {
		Mao maoJogador1 = mao1.avalia(jogador1.getCartas());
		Mao maoJogador2 = mao2.avalia(jogador2.getCartas());
		
		String retorno = "";
		
		if (maoJogador1.getPonto() > maoJogador2.getPonto()) {
			this.jogadorVencedor = jogador1;
			this.maoVencedora = maoJogador1;
			retorno = jogador1.getNome() + WINS + maoJogador1;
		}else if (maoJogador1.getPonto() < maoJogador2.getPonto()) {
			this.jogadorVencedor = jogador2;
			this.maoVencedora = maoJogador2;
			retorno = jogador2.getNome() + WINS + maoJogador2;
		}else {
			if (maoJogador1.desempate(maoJogador2)==-1) {
				this.jogadorVencedor = jogador2;
				this.maoVencedora = maoJogador2;
				retorno = jogador2.getNome() + WINS + maoJogador2 + maoJogador1.getValorDesempate() ;
			}else if (maoJogador1.desempate(maoJogador2)==0) {
				this.empate=true;
				this.maoVencedora = maoJogador1;
				retorno = TIE + maoJogador1;
			}else if (maoJogador1.desempate(maoJogador2)==1) {
				this.jogadorVencedor = jogador1;
				this.maoVencedora = maoJogador1;
				retorno = jogador1.getNome() + WINS + maoJogador1 + maoJogador1.getValorDesempate();
			}
		}
		return retorno.trim();
		
	}

	public Mao getMaoVencedora() {
		return maoVencedora;
	}

	public Boolean getEmpate() {
		return empate;
	}

	public Jogador getJogadorVencedor() {
		return jogadorVencedor;
	}
	
	
}
