
public class Corsa {
	private String destinazione;
	private double costoKm;
	private int kmPercorsi;
	
	public Corsa(String destinazione, double costoKm) {
		this.destinazione = destinazione;
		this.costoKm = costoKm;
		kmPercorsi = 0;
	}
	
	public Corsa(String destinazione) {
		this.destinazione = destinazione;
		costoKm = 0.5;
		kmPercorsi = 0;
	}
	
	public String getDestinazione() {
		return destinazione;
	}
	
	public double getCostoKm() {
		return costoKm;
	}
	
	public double getKmPercorsi() {
		return kmPercorsi;
	}
	public void aggiungiKm(int kmPercorsi) {
		if (kmPercorsi >= 0)
			this.kmPercorsi += kmPercorsi;
	}
	
	public double calcolaTariffa() {
		return costoKm * kmPercorsi;
	}
	
	public double calcolaTariffa(int supplemento) {
		return ( costoKm * kmPercorsi ) + supplemento;
	}
}
