package it.corso;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci primo numero:");
		int a = scanner.nextInt();
		System.out.println("inserisci secondo numero:");
		int b = scanner.nextInt();
		controllaPari(a,b);
		scanner.close();
	}
	
	//il test deve essere sterile, ovvero lo si deve richiamare in autonomia senza fare new dell'oggetto
	public static boolean controllaPari(int a, int b) {
		if(a%2==0 && b%2==0){
			return true;
		}
		else if(a%2!=0 && b%2!=0){
				return false;
		}
		else {
			return a>b;
		}
			
	}	

}
