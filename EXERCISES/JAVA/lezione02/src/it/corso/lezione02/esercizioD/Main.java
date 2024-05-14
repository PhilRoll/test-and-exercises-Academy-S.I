package it.corso.lezione02.esercizioD;

public class Main {

	public static void main(String[] args) {
		String s = "tassa";
		//String s = "letto";
		//String s = "mimmo pippo ciccio";
		s = s.toLowerCase();
		for(int i=0; i<s.length()-1;i++) {
			if((s.charAt(i)!='p' || s.charAt(i)!='s') &&
					s.charAt(i)==s.charAt(i+1)){
				System.out.println("c\'e\' una doppia "+s.charAt(i));
			}
		}

	}

}
