
public class Main {

	public static void main(String[] args) {
		Agenda a1 =  Agenda.getInstance();
		a1.aggiungiStringa("mangiare");
		a1.aggiungiStringa("bere");
		a1.aggiungiStringa("dormire");
		
		Agenda a2 =  Agenda.getInstance();
		a2.visualizzaAgenda();
	}
}
