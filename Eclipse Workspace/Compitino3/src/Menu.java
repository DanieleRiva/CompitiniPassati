
public class Menu {
	Piatto piatti[];

	public Menu(int maxPortate) {
		if (maxPortate <= 0 || maxPortate > 5)
			piatti = new Piatto[5];
		else
			piatti = new Piatto[maxPortate];
	}

	public Menu() {
		piatti = new Piatto[5];
	}

	public int tipoPiattoPresente(int tipo) {
		for (int i = 0; i < piatti.length; i++) {
			if (piatti[i].getTipo() == tipo)
				return i;
		}

		return -1;
	}

	public boolean aggiungiPiatto(Piatto piatto) {
		if (piatto != null) {
			for (int i = 0; i < piatti.length; i++) {
				if (piatti[i] != null && piatti[i].getTipo() == piatto.getTipo())
					return false;
			}

			for (int i = 0; i < piatti.length; i++) {
				if (piatti[i] == null) {
					piatti[i] = piatto;
					return true;
				}
			}
		}

		return false;
	}

	public boolean rimuoviPiatto(Piatto piatto) {
		for (int i = 0; i < piatti.length; i++) {
			if (piatti[i] != null && piatti[i].equals(piatto)) {
				piatti[i] = null;
				return true;
			}
		}

		return false;
	}

	public boolean sostituisciPiatto(Piatto piatto) {
		if (piatto != null)
			for (int i = 0; i < piatti.length; i++) {
				if (piatti[i] != null && piatti[i].equals(piatto)) {
					piatti[i] = piatto;
					return true;
				}
			}

		return false;
	}

	public int calcolaCosto() {
		int costo = 0;

		for (int i = 0; i < piatti.length; i++) {
			if (piatti[i] != null)
				costo += piatti[i].getCosto();
		}

		return costo;
	}
	
	public int dimensioneMenu() {
		return piatti.length;
	}
}













