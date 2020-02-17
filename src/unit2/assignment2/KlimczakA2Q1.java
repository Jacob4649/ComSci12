package unit2.assignment2;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA2Q1 {

	/*
	 * Jacob Klimczak
	 * Assignment 2, Question 1
	 * February 16, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//intro
		
		System.out.println("Negater:");
		System.out.println();
		System.out.println("\t- Replaces The Phrase 'Will' In The Input With 'Will Not'");
		System.out.println();
		
		while (true) {
			System.out.print("Enter Input (Quit To Terminate The Program):\n\t>>> ");
			String input = ScannerUtils.read(m_input);
			
			if (input.matches("(?i)quit")) {
				break;
			} else {
				System.out.println();
				System.out.println("Output: " + input.replaceAll("(?i)\\bwill\\b", "will not"));
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("Terminating Program");
		
	}
	
}
