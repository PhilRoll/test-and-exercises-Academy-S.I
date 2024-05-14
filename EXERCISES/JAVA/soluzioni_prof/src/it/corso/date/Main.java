package it.corso.date;
import java.time.LocalDate;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Main orario = new Main();
		orario.esempioDate();
		System.out.println("///////////");
		orario.esempioCalendar();
		System.out.println("///////////");
		orario.esempioLocalDate();
		
	}
	
	@SuppressWarnings("deprecation")
	public void esempioDate() {
		
		Date data = new Date();
		data.getDate();
		System.out.println(data.getDate());
		// data in timestamp
		System.out.println(data.getTime());
	}
	
	public void esempioCalendar() {
		
		// istanza della classe Calendar
//		Calendar cal = Calendar.getInstance();
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(new Date());
		cal2.set(2024, 04, 03);
		System.out.println(cal2.getTime());
		System.out.println(cal2.get(Calendar.YEAR));
	}
	
	public void esempioLocalDate() {
		
		LocalDate ld = LocalDate.of(2024, 04, 03);
		System.out.println(ld);
		System.out.println(ld.lengthOfMonth());
		LocalDate ldAg = ld.plusMonths(3);
		System.out.println(ldAg);
		
	}

}
