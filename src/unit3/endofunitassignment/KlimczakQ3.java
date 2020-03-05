package unit3.endofunitassignment;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakQ3 {
	
	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 3
	 * March 4, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	static int m_size = 0;
	
	public static void main(String[] args) {
		System.out.println("Isosceles Triangle Builder");
		System.out.println();
		System.out.print("Enter Triangle Size: " );
		m_size = ScannerUtils.readInt(m_input);
		
		System.out.println();
		
		for (int i = 1; i <= m_size; i++) {
			addSpaces(m_size - i);
			drawBar(2 * i - 1);
			addSpaces(m_size - 1);
			System.out.println();
		}
	}
	
	/**
	 * Prints a specified number of asterisks to the screen, forming a bar
	 * @param i The number of asterisks to print
	 */
	static void drawBar(int i) {
		for (int q = 0; q < i; q++) {
			System.out.print("*");
		}
	}
	
	/**
	 * Prints a specified number of spaces to the screen
	 * @param i The number of spaces to print
	 */
	static void addSpaces(int i) {
		for (int q = 0; q < i; q++) {
			System.out.print(" ");
		}
	}
}
