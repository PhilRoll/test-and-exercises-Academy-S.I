package corso.lezione03.esercizio04;

public class Esercizio {
	
	/* esercizio A
	 * verifica l'occorrenza di un carattere c all'interno di una stringa s
	 * restituisce true se il carattere è presente, false altrimenti*/
	public boolean trovaOccorrenza(String s, char c){
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c) {
				return true;
			}
		}
		return false;
	}
	
	
	//esercizio B
	public int contaOccorrenze(String s, char c){
		int counter=0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c) {
				counter++;
			}
		}
		return counter;
	}
	
	
	//esercizio C
	public int trovaPosizioneOccorrenza(String s, char c){
		int pos=0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c) {
				return i;
			}
		}
		return -1;
	}
	
}
