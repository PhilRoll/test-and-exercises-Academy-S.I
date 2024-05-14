package corso.lezione03.esercizio01;

import java.util.Scanner;

public class Main {
	
	public static String generaPassword(){
		String password;
		Scanner scanner = new Scanner(System.in);
		do {		
			System.out.println("Inserisci la password:");
			password = scanner.nextLine();
		}
		
		while(password.length()<8 || 
				!(password.contains("&") || password.contains("$") || password.contains("@"))
				);
		
		scanner.close();
		System.out.println("PASSWORD CREATA");
		return password;
	}
	
	
	public static void main(String[] args) {
		String password = generaPassword();

	}

}
