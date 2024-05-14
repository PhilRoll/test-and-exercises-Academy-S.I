package it.corso.lezione02.esercizioB;

public class Main {

	public static void main(String[] args) {
		int somma=0;
		int counter=0;
		for (int i=1; i<=1000 && counter!=5; i++) {
			if(i%3==0 && i%5==0) {
				counter++;
				System.out.println(i);
				somma+=i;
			}
		}
		
		System.out.println("Somma = "+somma);

	}

}
