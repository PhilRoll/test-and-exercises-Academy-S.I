package it.corso.lezione08.testinputfile;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		byte[] array = new byte[100];
		String filePath = "C:\\Users\\filip\\Desktop\\Lavoro\\AZIENDE\\Academy - Sistemi Informativi\\Modulo Java\\testi esercizi\\lezione08\\file.txt";
		//String filePath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "file.txt";
		try {
			
			
			InputStream input = new FileInputStream(filePath);
			//available() utilizzato per ottenere il numero di byte disponibili per la lettura del flusso
			System.out.println("Byte disponibile nel file: " + input.available());

			int byteRead = input.read(array);
			String data = new String(array, 0, byteRead);
			System.out.println(data);
			input.close();
			
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("File non trovato: "+filePath);
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
