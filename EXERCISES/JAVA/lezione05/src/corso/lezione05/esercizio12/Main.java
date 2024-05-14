package corso.lezione05.esercizio12;

public class Main {
	
	public static boolean isPalindroma(String parola) {
		 parola = parola.toLowerCase();
		 int lunghezza = parola.length();

		  if (lunghezza <= 1) {
		    return true;
		    }

		  for (int i=0, j=lunghezza-1; i<j; i++,j--) {
			  if (parola.charAt(i) != parola.charAt(j)) {
				  return false;
		      }
		    }

		  return true;
		}
	
	public static void main(String[] args) {
		System.out.println(isPalindroma("aba"));

	}

}
