package it.corso.lezione02.esercizioE;

public class Main {

	public static void main(String[] args) {
		String s = "tassa";
		//String s = "mimmo pippo ciccio";
		s = s.toLowerCase();
		for(int i=0; i<s.length();i++){
			for(int j=i+1; j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					System.out.println("c\'e\' una doppia "+s.charAt(i));
				}
			}
		}

	}

}
