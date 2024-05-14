package corso.lezione03.esercizio02;

import java.util.Scanner;

public class Main {
	public static void calcolaEquazioneQuadratica(){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il coefficiente a: ");
        double a = scanner.nextDouble();
        System.out.println("Inserisci il coefficiente b: ");
        double b = scanner.nextDouble();
        System.out.println("Inserisci il coefficiente c: ");
        double c = scanner.nextDouble();
        
        double delta = (b*b) - (4*a*c);

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("Le soluzioni sono:\nx1="+x1 +"\tx2="+x2);
        } 
        
        else if (delta == 0) {
            double x = -b/(2*a);
            System.out.println("La soluzione è:\nx="+x);
        } 
        
        else {
            System.out.println("L'equazione non ha soluzioni reali");
        }
        scanner.close();
	}

	public static void main(String[] args) {
		calcolaEquazioneQuadratica();

	}

}
