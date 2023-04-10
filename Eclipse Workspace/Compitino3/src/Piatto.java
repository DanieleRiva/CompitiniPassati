
public class Piatto {
	private String nome;
	private int tipo;
	private int costo;

	public static final int ANTIPASTO = 0;
	public static final int PRIMO = 1;
	public static final int SECONDO = 2;
	public static final int CONTORNO = 3;
	public static final int DOLCE = 4;

	public Piatto(String nome, int tipo, int costo) {
		this.nome = nome;
		this.tipo = tipo;
		this.costo = costo;
	}

	public boolean equals(Piatto piatto) {
		return (nome.toLowerCase().equals(piatto.nome.toLowerCase()) && tipo == piatto.getTipo());
	}

	public int getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getCosto() {
		return costo;
	}
}
