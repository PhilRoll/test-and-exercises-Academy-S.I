package corso.lezione03.esercizio05;

public class MainQuadrato {

	public static void main(String[] args) {
		Quadrato quadrato = new Quadrato(10);
		System.out.println("lato = "+quadrato.getLato());
		System.out.println("perimetro = "+quadrato.calcolaPerimetro());
		System.out.println("area = "+quadrato.calcolaArea());
		
		System.out.println(Quadrato.perimetro(20));

	}

}
