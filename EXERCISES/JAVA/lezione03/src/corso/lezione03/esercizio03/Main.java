package corso.lezione03.esercizio03;

import java.util.Scanner;

public class Main {
	
	public static void generaNumero() {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {		
			System.out.println("Inserisci un numero (tra 1 e 7)");
			num = scanner.nextInt();
		}
		while(num<1 || num>7);
		
		scanner.close();
		switch(num) {
		case 1:
			System.out.println("LUNEDI");
			break;
		case 2:
			System.out.println("MARTEDI");
			break;
		case 3:
			System.out.println("MERCOLEDI");
			break;
		case 4:
			System.out.println("GIOVEDI");
			break;
		case 5:
			System.out.println("VENERDI");
			break;
		case 6:
			System.out.println("SABATO");
			break;
		case 7:
			System.out.println("DOMENICA");
			break;
		default:
			System.out.println("errore");
		}
	}

	public static void main(String[] args) {
		generaNumero();

	}

}
