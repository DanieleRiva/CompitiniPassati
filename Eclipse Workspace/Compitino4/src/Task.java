
public class Task {
	private String titolo;
	private int data;
	private int durata;
	private boolean eseguito = false;

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		if (titolo != null)
			this.titolo = titolo;
		else
			this.titolo = "Da specificare";
	}

	public int getData() {
		return data;	
	}
	public void setData(int data) {
		if (data >= DataUtil.getDataDiOggi())
			this.data = data;
	}

	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		if (durata >= 1 && durata <= 8)
			this.durata = durata;
		else
			this.durata = 1;
	}

	public boolean isEseguito() {
		return eseguito;
	}
	public void eseguito() {
		eseguito = true;
	}

	public Task(String titolo, int data, int durata) {
		setTitolo(titolo);
		setData(data);
		setDurata(durata);
	}

	public Task(String titolo, int durata) {
		setTitolo(titolo);
		setData(DataUtil.getDataDiOggi());
		setDurata(durata);
	}

	public boolean equals(Task task) {
		if (task != null)
			return ( 
					titolo.toLowerCase().equals(task.titolo.toLowerCase()) && 
					data == task.getData() && 
					durata == task.getDurata()
					);
		else
			return false;
	}
	
	public String toString() {
		return "Titolo: " + titolo +
				"\nData: " + data +
				"\nDurata: " + durata +
				"\nEseguito: " + eseguito;
	}
}
















