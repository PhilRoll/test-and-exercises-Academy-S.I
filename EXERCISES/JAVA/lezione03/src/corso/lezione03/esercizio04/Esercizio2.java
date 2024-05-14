package corso.lezione03.esercizio04;

public class Esercizio2 {
	
	public String modificaStringa(String s, char c){
		StringBuilder tmp = new StringBuilder();
		for(int i=0; i<s.length()-1; i++) {
			tmp.append(s.charAt(i));
			tmp.append(c);
		}
		tmp.append(s.charAt(s.length()-1));
		return tmp.toString();
	}
	
	
	public int calcolaFibonacci(int num){
		if(num<0){
			return -1;
		}
		
		if(num==0 || num==1) {
			return 1;
		}
		
		int[] fibonacci = new int[num];
		fibonacci[0]=1;
		fibonacci[1]=1;
		for(int i=2;i<num;i++){
			fibonacci[i]= fibonacci[i-1]+fibonacci[i-2];
			
		}
		return fibonacci[num-1];
	}
	
}
