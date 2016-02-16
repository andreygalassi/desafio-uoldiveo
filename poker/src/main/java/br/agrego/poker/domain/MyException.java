package br.agrego.poker.domain;

public class MyException extends Exception{

	private static final long	serialVersionUID	= 1L;
	public MyException(String motivo) {
		super(motivo);
	}


}
