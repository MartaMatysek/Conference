package com.capgemini.conference;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Person to klasa reprezentująca osoby, zawierająca firstName, name oraz birthDate.
 */

public class Person{
	private String firstName;
	private String name;
	private LocalDate birthDate;
	
	/**Konstruktor klasy - przyjmuje napis i dzieli go na odpowiednie elementy rozdzielone separatorem tworząc obiekt
	 * @param line
	 */
	
	public Person(String line){
		String[] lineSeparator = line.split(",");
		this.firstName = lineSeparator[0];
		this.name = lineSeparator[1];
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.birthDate = LocalDate.parse(lineSeparator[2], format);
	}
	
	/**
	 * Konstruktor klasy - tworzy obiekt
	 * @param firstName
	 * @param name
	 * @param birthDate
	 */
	
	public Person(String firstName, String name, String birthDate){
		this.firstName = firstName;
		this.name = name;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.birthDate = LocalDate.parse(birthDate, format);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	/**
	 * countPersonAge oblicza wiek danej osoby 
	 * @return wiek danej osoby
	 */

	private int countPersonAge(){
		LocalDate currentDay = LocalDate.now();
		return Period.between(birthDate, currentDay).getYears();
	}
	
	@Override
	public String toString() {
		return firstName + "," + name + "," + countPersonAge();
	}
	

}
