package it.corso.gestionale.università;

public class Main {

	public static void main(String[] args) {
		Universita unipa = new Universita();
		Professore p1 = new Professore("Mario", "Rossi", "001");
		Professore p2 = new Professore("Luigi", "Verdi", "002");
		
		Studente s1 = new Studente("Luca", "Bianchi", "1399324", 2024);
		Studente s2 = new Studente("Luisa", "Neri", "1003324", 2023);
		
		Corso c1 = new Corso("Analisi Matematica 1", "A001", 30);
		Corso c2 = new Corso("Analisi Matematica 2", "A002", 30);
		Corso c3 = new Corso("Fisica", "A003", 35);
		
		unipa.registraStudente(s1);
		unipa.registraStudente(s2);
		
		unipa.registraProfessore(p1);
		unipa.registraProfessore(p2);
		
		unipa.creaCorso(c1);
		unipa.creaCorso(c2);
		unipa.creaCorso(c3);
		
		unipa.assegnaProfessoreACorso(p1, c1);
		unipa.assegnaProfessoreACorso(p1, c2);
		unipa.assegnaProfessoreACorso(p2, c3);
		
		unipa.iscriviStudenteACorso(s1, c1);
		unipa.iscriviStudenteACorso(s2, c1);
		unipa.iscriviStudenteACorso(s1, c2);
		unipa.iscriviStudenteACorso(s1, c3);
		
		System.out.println(c1);
		System.out.println();
		System.out.println(c2);
		System.out.println();
		System.out.println(c3);
		System.out.println();
		
		System.out.println("----------------");
		for(Corso corso:p2.getCorsi()){
			System.out.println(corso);
			System.out.println();
		}
	}

}
