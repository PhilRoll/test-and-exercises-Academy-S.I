package it.corso.strutture.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<>();
		
		linkedList.add("Elemento 1");
		linkedList.add("Elemento 2");
		linkedList.add("Elemento 3");
		
//		System.out.println(linkedList);
		
		// aggiunta elemento iniziale e finale 
		
		linkedList.addFirst("Elemento iniziale");
		linkedList.addLast("Elemento finale");
		
		
//		System.out.println(linkedList);
		
		linkedList.removeLast();

//		System.out.println(linkedList);
		
		Iterator<String> iterator = linkedList.iterator();
		while(iterator.hasNext()) {
			
			String elemento = iterator.next();
//			System.out.println(elemento);
		}
		
		ListIterator<String> listIterator = linkedList.listIterator();
		while (listIterator.hasPrevious()) {
			String elemento1 =  listIterator.previous();
//			System.out.println(elemento1);
			
		}
		System.out.println(linkedList);
		System.out.println("-------------------------------------------");

		// rimuove e restituisce l'elemento all'inizio della coda. Restituisce null se la coda è vuota. Utile per First in, first out FIFO
		String elementoRimosso = linkedList.poll();
		System.out.println(elementoRimosso);
		System.out.println(linkedList);
		System.out.println("-------------------------------------------");

		String elementoEstrattoNonRimosso = linkedList.peek();
		System.out.println(elementoEstrattoNonRimosso);
		System.out.println(linkedList);
		System.out.println("-------------------------------------------");

		boolean verificaInserimento = linkedList.offer("Elemento aggiunto con offer");
		if(verificaInserimento) {
		System.out.println(linkedList);

		} else {
			
		}
		
	}
}
