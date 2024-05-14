package it.corso.lezione02.esercizio02;

public class Main {
	
	public static void stampaStringa(String s){
		s = s.toLowerCase();
		String c="";
		for (int i=0; i<s.length();i++) {
			if(s.charAt(i)=='a' || s.charAt(i)=='b')
				c+=s.charAt(i);
		}
		
		System.out.println(c);
	}	
	
	
	public static void main(String[] args) {
		Main.stampaStringa("libellula");
		Main.stampaStringa("albatro");
		Main.stampaStringa("anaconda");
		Main.stampaStringa("balena");

	}
}
