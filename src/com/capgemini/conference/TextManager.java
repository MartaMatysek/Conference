package com.capgemini.conference;

import java.util.List;

/**
 * TextManager to klasa odpowiadająca za wykonanie odpowiedniego działania na lisie obiektów z klasy {# Person}
 * ze względu na wprowadzony strumień wejściowy.
 */

public class TextManager {
	
	/**
	 * checkInput to metoda, która sprawdza, czy dany strumień wejściwy jest liczbą lub literą. Jeśli tak,
	 * to wykona się odpowiednie działanie na podanej w argumencie liście obiektów (zapisywanie do plików).
	 * Jeśli nie- wywołany zostanie wyjątek z klasy {# RuntimeException}.
	 * @param input strumień wejściowy
	 * @param participants lista obiektów 
	 * @throws RuntimeException wyjątek informujący, że podano zły strumień wejściowy
	 */
	
	public static void checkInput(String input, List<Person> participants) throws RuntimeException{
		
		if(input.matches("\\d+")){
			int number = Integer.parseInt(input);
			if(number < 0 ){
				throw new RuntimeException("Numer must be positive!");
			}
			else if(participants.size()%number != 0){
				throw new RuntimeException("The number must be divisible by the number of objects!");
			}
			else{
				PersonService.saveGroupByNumber(participants, number);
			}
		} 
		else if(input.matches("[a-zA-ZąćęłńóśźżĄĘŁŃÓŚŹŻ]")){
				PersonService.saveGroupByLetter(participants, input.charAt(0));
		}
		else{
			throw new RuntimeException("Wrong input data!");
		}
	}

	
	
}
