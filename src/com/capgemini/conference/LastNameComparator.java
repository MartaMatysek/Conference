package com.capgemini.conference;

import java.util.Comparator;

/**
 * LastNameComparator służy do porównania obiektów klasy {@link Person}.
 */

public class LastNameComparator implements Comparator<Person>{
	
	/**
	 * Metoda compare porównuje pola name z klasy {@link Person}.
	 * @param p1 pierwszy obiekt klasy {@link Person}, który ma być porównany
	 * @param p2 drugi obiekt klasy {@link Person}, który ma być porównany
	 * @return 0 jeśli obiekty są sobie równe, <0 jeśli pierwszy obiekt jest mniejszy od drugiego, >0 w przeciwnym razie
	 */
	
	public int compare(Person p1, Person p2){
		int c = p1.getName().compareTo(p2.getName());
		
		if(c==0){
			return p1.getFirstName().compareTo(p2.getFirstName());
		}
		else{
			return c;
		}
	}	
}


