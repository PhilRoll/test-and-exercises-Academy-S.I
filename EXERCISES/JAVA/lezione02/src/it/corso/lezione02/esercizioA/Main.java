package it.corso.lezione02.esercizioA;

public class Main {
	
	public static void stampaNumero(int numero) {
		switch(numero){
		case 0:
			System.out.println("ZERO");
			break;	
			
		case 1:
			System.out.println("UNO");
			break;
			
		case 2:
			System.out.println("DUE");
			break;
			
		case 3:
			System.out.println("TRE");
			break;
			
		case 4:
			System.out.println("QUATTRO");
			break;
			
		case 5:
			System.out.println("CINQUE");
			break;
			
		case 6:
			System.out.println("SEI");
			break;
			
		case 7:
			System.out.println("SETTE");
			break;
		
		case 8:
			System.out.println("OTTO");
			break;
			
		case 9:
			System.out.println("NOVE");
			break;
		
		default:
			System.out.println("OTHER");
		}
	}

	public static void main(String[] args) {
		Main.stampaNumero(10);

	}

}
