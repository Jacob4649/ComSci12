package unit2.assignment2;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA2Q2 {

	/*
	 * Jacob Klimczak
	 * Assignment 2, Question 2
	 * February 16, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//intro
		System.out.println("Detect Duplicate Ones");
		System.out.println();
		
		while (true) {
			System.out.print("Enter A Number (Enter Quit To Terminate Program):\n\t>>> ");
			String input = ScannerUtils.read(m_input);
			if (input.matches("(?i)quit")) { //if the input is any variant of 'quit' end the program
				break;
			} else {
				System.out.println();
				if (input.matches("\\d*")) { //checks if input is an integer
					System.out.println("Output: " + input.matches("\\d*[1]{2}\\d*")); //if the input contains '11'
				} else {
					System.out.println("Invalid Input"); //input is not an integer
				}
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("Terminating Program");
	}
	
}
