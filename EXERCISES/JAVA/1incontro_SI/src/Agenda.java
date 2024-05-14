import java.util.ArrayList;
import java.util.List;


public class Agenda {
	private ArrayList<String> stringhe;
	private static Agenda agenda;
	
	//il costruttore è necessario, dato che ci serve privato
	private Agenda() {
		
	}
	
	public static Agenda getInstance() {
		if (agenda == null) {
			agenda = new Agenda();
		}
		return agenda;
	}

	private ArrayList<String> getStringhe() {
		if (this.stringhe == null) {
			this.stringhe = new ArrayList<>();
		}
		return stringhe;
	}
	
	public void aggiungiStringa(String nuovaStringa) {
		getStringhe().add(nuovaStringa);
	}
	
	public void visualizzaAgenda() {
		//stream: crea un canale | fa in modo di leggere gli elementi uno alla volta
		getStringhe().stream().forEach(System.out::println); //arrow function
	}


}
