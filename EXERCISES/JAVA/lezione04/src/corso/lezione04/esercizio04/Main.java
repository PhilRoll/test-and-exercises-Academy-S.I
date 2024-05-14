package corso.lezione04.esercizio04;

public class Main {

	public static void main(String[] args) {
		Film film = new Film("titolo","nomeRegista","lingua",1995,"nazioneDiProduzione");
		
		FilmDVD dvd = new FilmDVD("titolo", 
									"nomeRegista", 
									"lingua", 
									1995, 
									"nazioneDiProduzione",
									3, 
									3, 
									false);
		
		dvd.setLinguaDVD("italiano");
		dvd.setLinguaDVD("inglese");
		System.out.println(dvd.toString());
		System.out.println(dvd.eq(film));
		
		Videoteca videoteca = new Videoteca(3);
		videoteca.setFilm(dvd);
		
	}

}
