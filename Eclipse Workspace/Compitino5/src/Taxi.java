
public class Taxi {
	Corsa totaleCorseEffettuate[];
	Corsa corsaInSvolgimento = null;

	public Taxi() {
		totaleCorseEffettuate = new Corsa[5];
	}

	public boolean nuovaCorsa(String destinazione) {
		if (destinazione != null &&
				destinazione != "" &&
				isLibero() &&
				getTotaleCorseEffettuate() < totaleCorseEffettuate.length) {
			corsaInSvolgimento = new Corsa(destinazione);
			return true;
		}

		return false;
	}

	public boolean isLibero() {
		return corsaInSvolgimento == null;
	}

	public int getTotaleCorseEffettuate() {
		int value = 0;

		for (int i = 0; i < totaleCorseEffettuate.length; i++) {
			if (totaleCorseEffettuate[i] != null)
				value++;
		}

		return value;
	}

	public void terminaCorsa(int kmPercorsi) {
		if (corsaInSvolgimento != null) {
			corsaInSvolgimento.aggiungiKm(kmPercorsi);

			for (int i = 0; i < totaleCorseEffettuate.length; i++) {
				if (totaleCorseEffettuate[i] == null) {
					totaleCorseEffettuate[i] = corsaInSvolgimento;
					corsaInSvolgimento = null;
					return;
				}
			}
		}
	}

	public Corsa trovaCorsaConCostoMaggiore(String destinazione) {
		if (destinazione != null) {
			double max = 0.0;
			int pos = -1;

			for (int i = 0; i < totaleCorseEffettuate.length; i++) {
				if (totaleCorseEffettuate[i] != null && 
						totaleCorseEffettuate[i].getDestinazione().equals(destinazione) && 
						totaleCorseEffettuate[i].calcolaTariffa() > max) {
					max = totaleCorseEffettuate[i].calcolaTariffa();
					pos = i;
				}
			}

			if (pos != -1)
				return totaleCorseEffettuate[pos];
		}

		return null;
	}
}












