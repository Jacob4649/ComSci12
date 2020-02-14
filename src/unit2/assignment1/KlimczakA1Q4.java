package unit2.assignment1;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA1Q4 {

	/*
	 * Jacob Klimczak
	 * Assignment 1, Question 4
	 * February 10, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	static double m_mass;
	static double m_energy;
	
	public static void main(String[] args) {
		
		//intro
		System.out.println("Energy Solver");
		System.out.println();
		System.out.print("Enter The Mass In Kilograms:\n--> ");
		
		m_mass = ScannerUtils.readDouble(m_input);
		
		System.out.println();
		
		m_energy = m_mass * Math.pow(3.0 * Math.pow(10, 8), 2);
		
		System.out.println("The Energy Produced In Joules Is " + m_energy + " J");
		System.out.println("The Number Of 100-Watt Light Bulbs That Could Be Powered For One Hour Is " + m_energy / 360000d);
		
	}
}
