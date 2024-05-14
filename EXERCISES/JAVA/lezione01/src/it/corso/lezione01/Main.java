package it.corso.lezione01;

public class Main {
	public static void main(String[] args) {
		/* Esercizio ripasso (Slide 58) */
		System.out.println("Esercizio ripasso (Slide 58)");
		int a = 5;
		int b = 3;
		// r1=a/b
		double r1 = (double) a/b; // casting esplicito
		System.out.println(a + "/" + b + " = " + r1);

		char c = 'a'; // valore in ascii = 97
		short s = 5000;
		// r2= c*s
		int r2 = c*s; // casting implicito
		System.out.println(c + "*" + s + " = " + r2);

		int i = 6;
		float f = 3.14f;
		// r3= i+f
		float r3 = f+i; // casting implicito
		System.out.println(i + "+" + f + " = " + r3);

		// r4= r1-r2-r3
		double r4 = r1-r2-r3; // casting implicito
		System.out.println(r1 + "-" + r2 + "-" + r3 + " = " + r4);

		// ------------------------------------------

		/* Esercizio 3.1 (Slide 60) */
		System.out.println("\n\nEsercizio 3.1 (Slide 60)");
		byte var1 = 100;
		short var2 = 10000;
		int var3 = 1000000000;
		long var4 = 50000 + (10 * ((long) var1+var2+var3));
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println("Risultato operazione= " + var4);
	}
}
