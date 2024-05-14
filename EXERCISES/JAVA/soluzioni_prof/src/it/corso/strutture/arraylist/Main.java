package it.corso.strutture.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
	
	public static void main(String[] args) {
		
		// inizializzato l'arrayList che è una implementazione dell'interfaccia List
		ArrayList<String> lista1 = new ArrayList<>();
		
		// aggiunta di elementi
		
		lista1.add("Elemento 1");
		lista1.add("Elemento 2");
		// shift elemento corrente
		lista1.add(1, "elemento inserito in una posizione specifica");
		
//		System.out.println(lista1);
		
		// ciclo for 
		for (int i = 0; i < lista1.size(); i++) {
			
			String valore = lista1.get(i);
			System.out.println("Elemento alla posizione " + i + " il valore è " + valore);
		}
		
		System.out.println("-------------------------------------------");
		
		// ciclo for-each 
		for (String elementoLista : lista1) {
			
			System.out.println(elementoLista);
		}
		
		System.out.println("-------------------------------------------");

		// metodo foreach
		lista1.forEach(e -> System.out.println(e));
	
		System.out.println("-------------------------------------------");

		// eliminare un elemento in una determinata posizione ovvero indice
		lista1.remove(1);
		System.out.println(lista1);
		
		System.out.println("-------------------------------------------");

		// verificare se un elemento appartiene oppure no
		boolean presente = lista1.contains("Elemento 1");
		System.out.println(presente);
		
		System.out.println("-------------------------------------------");

		// verificare se l'arrayList è valorizzato oppure no
		boolean vuoto = lista1.isEmpty();
		System.out.println(vuoto);
		
		System.out.println("-------------------------------------------");
		
//		lista1.clear();
//		System.out.println(lista1);
		
		
		Iterator<String> iterator = lista1.iterator();
		while (iterator.hasNext()) {
			String elemento = iterator.next();
			// stampando gli elementi della lista in avanti
			System.out.println(elemento);
		}
		/*
		 * 
		 */
		ListIterator<String> listIterator = lista1.listIterator();
		
		while (listIterator.hasNext()) {
			String elementoAvanti = listIterator.next();
			// stampa gli elementi della lista in avanti
			System.out.println(elementoAvanti);
			if(elementoAvanti.equals("B")) {
				listIterator.remove();
				
			}
			
		}
		
		while (listIterator.hasPrevious()) {
			String elementoIndietro = listIterator.previous();
			// stampa gli elementi della lista all'indietro
			System.out.println(elementoIndietro);
		}
		
		System.out.println("-------------------------------------------");

		ArrayList<String> listaSpesa = new ArrayList<>();
		
		listaSpesa.add("Pomodori");
		listaSpesa.add("Panino");
		listaSpesa.add("Latte");
		// creazione di un listIterator per iterare attraverso la lista
		ListIterator<String> iteratorSpesa = listaSpesa.listIterator();
		
		for(int i = 0; i<listaSpesa.size()/2; i++) {
			iteratorSpesa.next();
		}
		iteratorSpesa.add("Nuovo elemento");
		
		System.out.println(listaSpesa);
		
	

	}
	
	
}
