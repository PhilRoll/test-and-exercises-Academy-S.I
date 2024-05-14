package it.corso.lezione02.esercizioC;

public class Main {

	public static void main(String[] args) {
		int somma = 0;
		boolean flag = false;
		for(int i=0;i<=150;i++) {
			if(i%2==0) {
				System.out.println(i+" (Somma="+somma+")");
				somma+=i;
			}	
			if(!flag && somma>4000){
				flag=true;
				System.out.println("somma maggiore di 4000");
				somma+=1;
			}
			//if(flag && somma>5000){
			if(flag && somma>6000){
				break;
			}
		}

	}

}
