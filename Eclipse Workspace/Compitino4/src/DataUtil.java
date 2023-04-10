import java.time.LocalDate;

public class DataUtil {
	public static int getDataDiOggi() {
		LocalDate oggi = LocalDate.now();
		
		int mese = oggi.getMonthValue();
		String meseS = "" + mese;
		if (mese < 10)
			meseS = "0" + mese;
		
		int giorno = oggi.getDayOfMonth();
		String giornoS = "" + giorno;
		if(giorno < 10 )
			giornoS = "0" + giorno;
		
		String oggiString = oggi.getYear() + "" + meseS + giornoS;
		return Integer.parseInt(oggiString);		
	}
	
		
}
