package it.corso.prestazioni;
import java.util.*;

public class Main1 {
	
	public static void main(String[] args) {
		

		 // Creazione di un ArrayList e una LinkedList
	    List<Integer> arrayList = new ArrayList<>();
	    List<Integer> linkedList = new LinkedList<>();

	    // Inserimento di elementi all'inizio della lista
	    long startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	    	// aggiunge un elmento i all'arrayList nella posizione 0
	        arrayList.add(0, i);
	    }
	    long endTime = System.nanoTime();
	    long durationArrayListInsertion = endTime - startTime;
	    System.out.println("Tempo impiegato per l'inserimento iniziale con ArrayList: " + durationArrayListInsertion + " nanosecondi");

	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        linkedList.add(0, i);
	    }
	    endTime = System.nanoTime();
	    long durationLinkedListInsertion = endTime - startTime;
	    System.out.println("Tempo impiegato per l'inserimento iniziale con LinkedList: " + durationLinkedListInsertion + " nanosecondi");

	    // Rimozione di elementi dall'inizio della lista
	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        arrayList.remove(0);
	    }
	    endTime = System.nanoTime();
	    long durationArrayListRemoval = endTime - startTime;
	    System.out.println("Tempo impiegato per la rimozione iniziale con ArrayList: " + durationArrayListRemoval + " nanosecondi");

	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	        linkedList.remove(0);
	    }
	    endTime = System.nanoTime();
	    long durationLinkedListRemoval = endTime - startTime;
	    System.out.println("Tempo impiegato per la rimozione iniziale con LinkedList: " + durationLinkedListRemoval + " nanosecondi");
	}

	
}
