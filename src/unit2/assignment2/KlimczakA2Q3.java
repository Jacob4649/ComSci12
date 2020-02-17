package unit2.assignment2;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA2Q3 {

	/*
	 * Jacob Klimczak
	 * Assignment 2, Question 3
	 * February 17, 2020
	 * ICS4U0
	 */

	Scanner m_input = new Scanner(System.in);

	double m_a, m_b, m_c, m_determinant, m_root1, m_root2;

	public static void main(String[] args) {
		//intro

		System.out.println("Quadratic Solver");
		System.out.println();
		System.out.print("Enter A Value For A: ");
		m_a = ScannerUtils.readDouble(m_input);
		System.out.print("Enter A Value For B: ");
		m_b = ScannerUtils.readDouble(m_input);
		System.out.print("Enter A Value For C: ");
		m_c = ScannerUtils.readDouble(m_input);

		m_determinant = Math.sqrt(Math.pow(b, 2) - 4 * m_a * m_c);
		
		m_root1 = (-m_b + m_determinant) / (4 * m_a * m_c);
		m_root2 = (-m_b - m_determinant) / (4 * m_a * m_c);

		if (Double.isNaN(m_determinant)) {
			//0 roots
			System.out.println("No Roots, Function Is Above Or Below The X-Axis");
		} else if (m_determinant == 0.0) {
			//1 root
			System.out.println("One Root, Zero Is On The X-Axis");
			System.out.println("Root: " + m_root1);
		} else {
			//2 roots
			System.out.println("Two Roots");
			System.out.println("Roots Are: " + m_root1 + " And " + m_root2);
		}
	}
}