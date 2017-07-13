package com.capgemini.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 /**
  * UserManager odpowiada za komunikację z użytkownikiem. 
  */

public class UserManager {
	
	static Scanner sc = new Scanner(System.in);
 
	public static void main(String[] args ){
		List<Person> participants = new ArrayList<Person>();
		String text= "";
				
		do{
			System.out.println("Enter a file name: ");
			text = sc.nextLine();
			try{
				participants = InputOutputFileManager.fileReader(text);
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("This file is empty!");
			}
		}while(participants.size()==0);
		
		
		boolean status = false;
		do{
			System.out.println("Enter a letter or a number to gruop people: ");
			text = sc.nextLine();
			try{
				TextManager.checkInput(text, participants);
				status = true;
			}
			catch(RuntimeException e){
				System.out.println(e);
			}
		}while(!status);
	}
}
