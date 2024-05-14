package it.corso.lezione02.esercizio01;

public class Main {
	public final static double lbTokg = 0.45359237;
	
	public static double lbToKg(double weight){
		return lbTokg*weight;
	}

	
	public static void main(String[] args) {
		double lbWeight = 12.543;
		System.out.println(Main.lbToKg(lbWeight));

	}

}
