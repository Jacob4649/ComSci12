package unit2.assignment2;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA2Q6 {

	/*
	 * Jacob Klimczak
	 * Assignment 2, Question 6
	 * February 17, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//intro
		System.out.println("Divisibility By Digits Checker");
		System.out.println();
		System.out.print("Enter A Number To Check If It Is Divisible By It's Digits:\n\t>>> ");
		System.out.println("\nDivisible By Digits: " + (dividesByDigits(ScannerUtils.readInt(m_input)) ? "True" : "False"));
	}
	
	static boolean dividesByDigits(int i) {
		for (char c : ("" + i).toCharArray()) {
			if (c == '0' || i % Integer.parseInt("" + c) != 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
