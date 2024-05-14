package corso.lezione04.prova1;

public class Main {
	/*1)
	 * Scrivere un metodo che, dati un carattere c ed una stringa s, 
	 * restituisce true se c occorre in s, false altrimenti.*/
	public boolean trovaOccorrenza(String s, char c){
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c) {
				return true;
			}
		}
		return false;
	}
	
	/*2)
	 * Scrivere un metodo che, dati un carattere c ed una stringa s, 
	 * restituisce il numero delle occorrenze di c in s.*/
	public int contaOccorrenze(String s, char c){
		int counter=0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c) {
				counter++;
			}
		}
		return counter;
	}

	/*3)
	 * Scrivere un metodo in linguaggio Java che data una stringa s e due caratteri c1 e c2 
	 * determini se il numero di occorrenze di c1 in s sia uguale o meno al numero di occorrenze di c2.*/
	public boolean contaOccorrenze(String s, char c1, char c2){
		int counter1=0;
		int counter2=0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c1) {
				counter1++;
			}
			if(s.charAt(i)==c2) {
				counter2++;
			}
		}
		if(counter1<=counter2){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
