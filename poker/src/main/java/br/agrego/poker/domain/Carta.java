package br.agrego.poker.domain;


public class Carta implements Comparable<Carta> {

	private final ENaipe naipe;
	private final EValor valor;
	
	public Carta(ENaipe naipe, EValor valor) {
		super();
		this.naipe = naipe;
		this.valor = valor;
	}
	
	public Carta(String carta) throws MyException {
		super();
		if (carta==null || carta.length()!=2) throw new MyException("Criação de carta inválida");
		
		this.valor = EValor.get(carta.toUpperCase().substring(0, 1));
		this.naipe = ENaipe.get(carta.toUpperCase().substring(1, 2));
		

	}

	@Override
	public String toString() {
		return valor.toString()+naipe.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naipe == null) ? 0 : naipe.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (naipe != other.naipe)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	@Override
	public int compareTo(Carta o) {
		if (this.equals(o)) return 0;
		if (this.valor.getValor().compareTo(o.valor.getValor()) == 0) return this.naipe.compareTo(o.naipe);
		return this.valor.getValor().compareTo(o.valor.getValor());
	}

	public EValor getValor() {
		return valor;
	}

	public ENaipe getNaipe() {
		return naipe;
	}

	
	
}
