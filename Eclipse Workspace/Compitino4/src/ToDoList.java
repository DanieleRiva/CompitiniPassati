
public class ToDoList {
	Task toDo[];

	public ToDoList(int maxTasks) {
		if (maxTasks <= 0)
			toDo = new Task[5];
		else
			toDo = new Task[maxTasks];
	}

	public int getDurataTaskGiorno(int data) {
		int somma = 0;

		for (int i = 0; i < toDo.length; i++)
			if (toDo[i] != null && toDo[i].getData() == data)
				somma += toDo[i].getDurata();

		return somma;
	}

	public int getPosizioneTask(Task task) {
		if (task != null) {
			for (int i = 0; i < toDo.length; i++)
				if (toDo[i] != null && toDo[i].equals(task))
					return i;
		}

		return -1;
	}

	public boolean aggiungiTask(Task task) {
		if (task != null && 
				getDurataTaskGiorno(task.getData()) + task.getDurata() <= 8) {
			int pieno = 0;

			for (int i = 0; i < toDo.length; i++) {
				if (toDo[i] != null)
					pieno++;

				if (toDo[i] != null && toDo[i].equals(task))
					return false;
			}
			if (pieno == toDo.length)
				return false;

			for (int i = 0; i < toDo.length; i++)
				if (toDo[i] == null) {
					toDo[i] = task;
					return true;
				}
		}
		
		return false;
	}
	
	public boolean aggiungiTask(String titolo, int durata) {
		return aggiungiTask(new Task(titolo, durata));
	}
	
	public boolean rimuoviTask(Task task) {
		if (task != null) {
			for (int i = 0; i < toDo.length; i++)
				if (toDo[i] != null && task.equals(toDo[i])) {
					toDo[i] = null;
					return true;
				}
		}
		
		return false;
	}
}









