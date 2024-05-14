package it.corso.gestionevoti;

public class Main {

	public static void main(String[] args) {
		StudentGrades s = new StudentGrades();
		s.addgrade("Pippo", 30);
		s.addgrade("Paperino", 25);
		s.addgrade("Pluto", 18);
		System.out.println(s.getGrade("Pippo"));
		System.out.println(s.getGrade("Paperino"));
		System.out.println(s.getGrade("Pluto"));
		System.out.println(s.getGrade("Topolino"));
		System.out.println("-------------");
		s.printGrades();
	}
}
