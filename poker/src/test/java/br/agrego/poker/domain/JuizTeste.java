package br.agrego.poker.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.agrego.poker.exception.MyException;
import br.agrego.poker.util.JogadorFactory;

public class JuizTeste {
	
	@Test(expected=MyException.class)
	public void naoDevePermirtirCartasRepetidasParaOsJogadores() throws MyException {
			
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AP 2O 3E 4O 7P");
			new Juiz(black, white);
			
	}
	
	@Test
	public void vitoriaParaBlackComHighCardDesempate() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC 2O 3E 4O 7P");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("Black wins High Card: 8".equals(juiz.avalia()));
			
	}
	@Test
	public void vitoriaParaWhiteComHighCardDesempate() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC 2O 9E 4O 8O");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("White wins High Card: 9".equals(juiz.avalia()));
			
	}
	@Test
	public void empateComHighCard() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC 2O 3E 4O 8O");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("tie High Card:".equals(juiz.avalia()));
			
	}
	
	@Test
	public void vitoriaParaBlackComPairs() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 9C 9O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC 2O 3E 4O 7P");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("Black wins Pairs:".equals(juiz.avalia()));
			
	}
	@Test
	public void vitoriaParaWhiteComPairs() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC AO 9E 4O 8O");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("White wins Pairs:".equals(juiz.avalia()));
			
	}
	@Test
	public void empateComPairs() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 8E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "8C 2O 3E 4O 8O");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("tie Pairs:".equals(juiz.avalia()));
			
	}
	@Test
	public void vitoriaParaBlackComPairsComDesempate() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 9C 9O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC 2O 8E 8O 7P");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("Black wins Pairs: 9".equals(juiz.avalia()));
			
	}

	@Test
	public void vitoriaParaBlackComStraightFlush() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "5P 6P 7P 8P 9P");
			Jogador white = JogadorFactory.constroiJogador("White", "AC 3O 3E 4O 7O");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("Black wins Straight Flush:".equals(juiz.avalia()));
			
	}
	@Test
	public void vitoriaParaWhiteComStraightFlush() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 8P");
			Jogador white = JogadorFactory.constroiJogador("White", "8C 9C 10C JC QC");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("White wins Straight Flush:".equals(juiz.avalia()));
			
	}
	@Test
	public void empateComStraightFlush() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "2P 3P 4P 5P 6P");
			Jogador white = JogadorFactory.constroiJogador("White", "2C 3C 4C 5C 6C");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("tie Straight Flush:".equals(juiz.avalia()));
	}
	@Test
	public void vitoriaParaBlackComStraightFlushComDesempate() throws MyException {
			Jogador black = JogadorFactory.constroiJogador("Black", "9P 10P JP QP KP");
			Jogador white = JogadorFactory.constroiJogador("White", "4O 5O 6O 7O 8O");
			Juiz juiz = new Juiz(black, white);
			
			assertTrue("Black wins Straight Flush: K".equals(juiz.avalia()));
			
	}
	
}
