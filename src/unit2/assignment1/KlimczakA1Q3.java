package unit2.assignment1;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA1Q3 {

	/*
	 * Jacob Klimczak
	 * Assignment 1, Question 3
	 * February 10, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	
	static double m_radius, m_height;
	static boolean m_isCone = false;
	
	public static void main(String[] args) {
		
		//intro
		System.out.println("Geometric Property Solver - Cones And Cylinders");
		System.out.println();
		System.out.print("Select A Polyhedron:\n\t1 - Cone\n\t2 - Cylinder\n--> ");
		
		m_isCone = ScannerUtils.readIntRange(m_input, 1, 2) == 1; //m_isCone will be true if input is 1
		
		System.out.println();
		
		System.out.print("Input Height:\n--> ");
		m_height = ScannerUtils.readDouble(m_input);
		
		System.out.print("Input Radius:\n--> ");
		m_radius = ScannerUtils.readDouble(m_input);
		
		System.out.println();
		
		if (m_isCone) {
			
			//calculate cone area and volume
			
			//solve for side length with pythagorean theorem
			double side = Math.sqrt(Math.pow(m_radius, 2) + Math.pow(m_height, 2));
			
			double area = (Math.PI * m_radius * side) + (Math.PI * Math.pow(m_radius, 2));
			double volume = (m_height * Math.PI * Math.pow(m_radius, 2)) / 3d;
			
			System.out.println("The area of the cone is " + area + " square units.");
			System.out.println("The volume of the cone is " + volume + " cubic units.");
			
		} else {
			
			//calculate cylinder area and volume

			double area = (2 * Math.PI * Math.pow(m_radius, 2)) + (2 * Math.PI * m_radius * m_height);
			double volume = (m_height * Math.PI * Math.pow(m_radius, 2));
			
			System.out.println("The area of the cylinder is " + area + " square units.");
			System.out.println("The volume of the cylinder is " + volume + " cubic units.");
			
		}
	}
}
