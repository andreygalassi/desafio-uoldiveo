package br.agrego.poker.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.agrego.poker.util.JogadorFactory;

public class JogadorTest {

	@Test
	public void deveCriarJogadorCom5CartasValidas() throws MyException {
		Jogador jogador = JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 5P");
		
		assertEquals("Black", jogador.getNome());
		assertNotNull(jogador.getCartas());
		assertEquals(5,jogador.getCartas().size());
	}

	@Test(expected=MyException.class)
	public void deveCriarJogadorCom4CartasValidas() throws MyException {
		JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E");
	}

	@Test(expected=MyException.class)
	public void deveCriarJogadorCom6CartasValidas() throws MyException {
		JogadorFactory.constroiJogador("Black", "AP 2C 3O 4E 5P 6P");
	}

	@Test(expected=MyException.class)
	public void deveCriarJogadorComUmaCartaRepetida() throws MyException {
		JogadorFactory.constroiJogador("Black", "AP 3O 3O 4E 5P");
	}

	@Test(expected=MyException.class)
	public void deveCriarJogadorComNomeNull() throws MyException {
		JogadorFactory.constroiJogador(null, "AP 2C 3O 4E 5P");
		
	}

	@Test(expected=MyException.class)
	public void deveCriarJogadorSemNome() throws MyException {
		JogadorFactory.constroiJogador("", "AP 2C 3O 4E 5P");
		
	}

}
