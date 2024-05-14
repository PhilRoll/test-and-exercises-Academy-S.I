package it.corso.prestazioni;

import java.util.*;

public class Main {

	 public static void main(String[] args) {
	        // Creazione di un ArrayList e una LinkedList
	        List<Integer> arrayList = new ArrayList<>();
	        List<Integer> linkedList = new LinkedList<>();

	        // Aggiunta di elementi alla lista
	        for (int i = 0; i < 1000000; i++) {
	            arrayList.add(i);
	            linkedList.add(i);
	        }

	        // utilizzata per la misurazione delle prestazioni. 
	        long startTime = System.nanoTime();
	        // Accesso casuale all'elemento alla posizione 500000 in un ArrayList
	        int elementArrayList = arrayList.get(500000);
	        long endTime = System.nanoTime();
	        long durationArrayList = endTime - startTime;
	        System.out.println("Tempo impiegato per l'accesso casuale con ArrayList: " + durationArrayList + " nanosecondi");

	        startTime = System.nanoTime();
	        // Accesso casuale all'elemento alla posizione 500000 in una LinkedList
	        int elementLinkedList = linkedList.get(500000);
	        endTime = System.nanoTime();
	        long durationLinkedList = endTime - startTime;
	        System.out.println("Tempo impiegato per l'accesso casuale con LinkedList: " + durationLinkedList + " nanosecondi");
	    }
	

}
