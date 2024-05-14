package it.corso.eserciziTXT;

import java.util.Random;
import java.util.Scanner;
import java.lang.*;

public class Main {
	
	//esercizio 1
	public static boolean dueStringheUguali(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci la prima stringa");
		String s1 = scanner.nextLine();
		System.out.println("Inserisci la seconda stringa");
		String s2 = scanner.nextLine();
		scanner.close();
		
		if(s1.equals(s2)) 
			return true;
		else 
			return false;
	}
	
	
	//esercizio 2
	public static boolean contieneSottostringa(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci la frase");
		String f = scanner.nextLine();
		System.out.println("Inserisci la seconda stringa");
		String s = scanner.nextLine();
		scanner.close();
		System.out.println(f.toLowerCase());
		if(f.contains(s))
			return true;
		else 
			return false;
	}
	
	
	//esercizio 3
	public static String generaPasswordCasuale(){
		Random random = new Random();
		char[] charArray = new char[20];
		for(int i=0; i<20; i++) {
			charArray[i] = (char) random.nextInt(33, 127); //unicode ascii code
		}
		
		return new String(charArray);
	}

	
	//esercizio 4
	public static int trovaMax(int[] array){
		int max = array[0];
		for(int i=1; i<array.length;i++){
			if(array[i]>max)
				max=array[i];
		}
		return max;
	}
	
	
	//esercizio 5
	public static int sommaInteri(int[] array){
		int somma = 0;
		for(int i=0; i<array.length;i++)
			somma+=array[i];
		
		return somma;
	}
	
	//esercizio 6
	public static void lancioDado(){
		Random random = new Random();
		int val = random.nextInt(6) +1;
		System.out.println("E\' uscito il numero "+val);
		if(val%2==0)
			System.out.println("(il numero è pari)");
		else
			System.out.println("(il numero è dispari)");
			
		if(val<=3)
			System.out.println("(il numero è compreso tra 1 e 3)");
		else
			System.out.println("(il numero è maggiore di 3)");
		
	}
	
	
	public static void main(String[] args) {
		//System.out.println(dueStringheUguali());
		//System.out.println(contieneSottostringa());
		System.out.println(generaPasswordCasuale());
		int array[] = {12,44,3,76,25,43};
		//System.out.println(trovaMax(array));
		//System.out.println(sommaInteri(array));
		//lancioDado();
		
	}
}
