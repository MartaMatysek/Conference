package com.capgemini.conference;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 
 * Sort to klasa odpowiadająca za sortowanie listy obiektów
 */
public class Sort {
	
	/**
	 * insertSort to metoda, która sortuje listę obiektów z klasy {@link Person} przez wstawianie obiektów w odpowiednie miejsce, 
	 * tzn. po młodszej, ale przed starszą. 
	 * @param participants lista, którą chcemy posortować
	 * @param comparator klasa definująca po czym sortujemy
	 * @return posortowana lista obiektów
	 */

	public static List<Person> insertSort(List<Person> participants, Comparator<Person> comparator){
		Person temp = participants.get(0);
		int j = 0;
		
		for(int i=1; i<participants.size(); i++){
			j = i;
			temp = participants.get(i);
			while ( j>0 && (comparator.compare(participants.get(j-1), temp)>0) ){
				Collections.swap(participants, j-1, j);
				j--;
			}			
		}
		return participants;
	}
}