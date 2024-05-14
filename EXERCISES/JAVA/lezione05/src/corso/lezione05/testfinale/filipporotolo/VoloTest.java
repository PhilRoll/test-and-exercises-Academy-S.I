package corso.lezione05.testfinale.filipporotolo;

import java.util.Arrays;

public class VoloTest {

	public static void main(String[] args) {
		//3 aereoporti
		Aereoporto a1 = new Aereoporto("Falcone e Borsellino", "Palermo", "PA");
		Aereoporto a2 = new Aereoporto("Fiumicino", "Roma", "RO");
		Aereoporto a3 = new Aereoporto("Linate", "Milano", "MI");
		
		//3 passeggeri di esempio
		Passeggero p1 = new Passeggero("Pippo", "italiana", "AZ124", "F16", "vegetariano");
		Passeggero p2 = new Passeggero("Paperino", "italiana", "AZ124", "F01", "onnivoro");
		Passeggero p3 = new Passeggero("Pluto", "italiana", "AZ124", "F02", "vegano");
		
		//test swap posti tra passeggero p1 e passeggero p2
		System.out.println(p1.getPostoAssegnato());
		System.out.println(p2.getPostoAssegnato());
		p1.cambiaPostoAssegnato(p2);
		System.out.println(p1.getPostoAssegnato());
		System.out.println(p2.getPostoAssegnato());
		
		
		System.out.println("\n");
		
		
		//volo diretto:
		Volo v1 = new Volo("AZ124", a1, a2, "Airbus300", 3);
		v1.aggiungiPasseggero(p1);
		v1.aggiungiPasseggero(p2);
		v1.aggiungiPasseggero(p3);
		
		//descrizione volo
		System.out.println(v1.descrizioneVolo());
		
		//elenco passeggeri
		System.out.println(Arrays.toString(v1.getNomiPasseggeri()));
		//elenco posti passeggeri che hanno un menu vegetariano
		System.out.println(Arrays.toString(v1.getPostiPasseggeriVegetariani()));
		
		
		
		System.out.println("\n");
		
		//volo non diretto (da Palermo, scalo a Roma, a Milano)
		VoloNonDiretto v2 = new VoloNonDiretto("BA202", a1, a3, "Boeing-727", 3, 1);
		//inserimento aereoporto di scalo
		v2.setScaloIntermedio(a2);
		System.out.println(v2.descrizioneVolo());
		
	}

}
