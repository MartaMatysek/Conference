package com.capgemini.conference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Person Service to klasa odpowiadająca za zapisanie odpowiednio posortowanych i podzielonych danych do plików.
 * Dane dzielone są na grupy ze względu na docelową liczbę obiektów w plikach lub pierwszą literę nazwiska osób, 
 * a sortowanie odbywa się odpowiednio ze względu na pierwsza literę nazwiska lub imienia.
 */

public class PersonService{
	
	/** 
	 * locationToSaveFile to stała lokalizacja do której zapisywane są pliki
	 */

	final static String locationToSaveFile = "C:\\projects\\crash_course\\workspaces\\crash_course\\Conference\\";
	
	/**
	 * saveGroupByLetter zapisuje dane do plików, które posortowane są ze względu na imię, 
	 * a podzielone są ze względu na pierwsza literę nazwiska przez metodę {@link #findLetterName(List, char)}. 
	 * @param participants lista obiektów z klasy {@link Person}
	 * @param letter litera według której sorujemy listę
	 */
	
	public static void saveGroupByLetter(List<Person> participants, char letter){
		List<Person> outputParticipants = findLetterName(participants, letter);
		
		Comparator<Person> comparator = new FirstNameComparator();
		outputParticipants = Sort.insertSort(outputParticipants, comparator);

		InputOutputFileManager.saveToFile(outputParticipants, locationToSaveFile + "uczestnicy_" + letter + ".csv");
	}
	
	/**
	 * findLetterName to metoda zwracająca listę obiektów, których nazwiska zaczynają się na literę podaną w argumencie 
	 * @param participants lista obiektów klasy {@link Person}
	 * @param letter pierwsza litera nazwiska
	 * @return
	 */
	
	private static List<Person> findLetterName(List<Person> participants, char letter){
		List<Person> peopleNameLetter = new ArrayList<Person>();
		
		for(Person p : participants){
			if(p.getName().charAt(0) == Character.toUpperCase(letter)){
				peopleNameLetter.add(p);		
			}
		}
		return peopleNameLetter;		
	}
	
	/**
	 * saveGroupByNumebr zapisuje dane do plików, które posortowane są ze względu na pierwszą literę nazwiska, 
	 * a podzielone są ze względu na docelową liczbę grup.
	 * @param participants lista obiektów z klasy {@link Person}
	 * @param number numer docelowej liczby obiektów w nowo powstałych plikach
	 */
	
	public static void saveGroupByNumber(List<Person> participants, Integer number){
		List<Person> outputParticipants = new ArrayList<Person>();

		Comparator<Person> comparator = new LastNameComparator();
		participants= Sort.insertSort(participants, comparator);
		
		if( (participants.size()%number == 0) ){
			for(int i= 0; i<participants.size()/number; i++){
				for(int j= 0; j<number; j++){
					outputParticipants.add(participants.get(i*number + j));
				}
				InputOutputFileManager.saveToFile(outputParticipants, locationToSaveFile+"grupa"+(i+1)+".csv");
				outputParticipants.clear();
			}
		}
	}
	
}
