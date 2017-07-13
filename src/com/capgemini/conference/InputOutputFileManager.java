package com.capgemini.conference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * InputOutputFileManager to klasa służąca do zapisywania danych do pliku oraz odczytywania danych z pliku.
 */

public class InputOutputFileManager {
	
	/**
	 * fileReader pozwala na odczytywanie danych z pliku.
	 * @param csvName nazwa pliku, który ma być odczytany
	 * @return List<Person> - lista obiektów z klasy {@link Person} 
	 * @throws FileNotFoundException informuje, że próba otwarcia pliku oznaczonego daną ścieżą nie powiodła się
	 * @throws IOException oznacza, że wystąpił wyjątek innego rodzaju w wyniku nieudanych operacji
	 */
	
	public static List<Person> fileReader(String csvName){
		List<Person> participants = new ArrayList<Person>();
		String line = "";
		
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(csvName));
			
			while( (line = bufferedReader.readLine()) != null){
				Person person = new Person(line);
				participants.add(person);
				}
		
	        bufferedReader.close();
		}
		catch (FileNotFoundException e) {
            System.out.println("File not found!");
		}
		catch (IOException e){
			System.out.println("Error loading file!");
		}
			
		return participants;
	}
	
	/**
	 * saveToFile pozwala na zapisywanie danych do pliku.
	 * @param participants lista obiektów z klasy {@link Person} 
	 * @param fileName nazwa pliku do którego mają być zapisane dane
	 * @IOException wyjątek informujący, że nie udało się poprawnie zapisać danych do pliku
	 */
	
	public static void saveToFile(List<Person> participants, String fileName){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
			
			for(Person p : participants){
				bufferedWriter.write(p.toString());
				bufferedWriter.newLine();
			}
		bufferedWriter.close();
		}
		catch(IOException e){
			System.out.println("Error with save to file!");
		}
		
		System.out.println("File saved correctly.");
	}
}
