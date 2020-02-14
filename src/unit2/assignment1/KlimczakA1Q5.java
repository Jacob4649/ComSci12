package unit2.assignment1;

import java.text.DecimalFormat;
import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA1Q5 {

	/*
	 * Jacob Klimczak
	 * Assignment 1, Question 5
	 * February 10, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	static DecimalFormat m_format = new DecimalFormat("#.###");
	
	public static void main(String[] args) {
		
		//intro
		System.out.println("Trig Ratios - Standard And Inverse");
		System.out.println();
		System.out.print("Please Select The Trig You Would Like To Compute:\n(Enter 'Standard' Or 'Inverse')\n--> ");
		
		if ("Inverse".equalsIgnoreCase(ScannerUtils.read(m_input))) {
			
			//inverse ratios
			System.out.println();
			System.out.print("Enter A Ratio: ");
			double ratio = ScannerUtils.readDouble(m_input);
			
			System.out.println("ArcTan (In Degrees): " + m_format.format(Math.toDegrees(Math.atan(ratio))));
			System.out.println("ArcSin (In Degrees): " + m_format.format(Math.toDegrees(Math.asin(ratio))));
			System.out.println("ArcCos (In Degrees): " + m_format.format(Math.toDegrees(Math.acos(ratio))));
		} else {
			
			//standard ratios
			System.out.println();
			System.out.print("Enter An Angle In Degrees: ");
			double angle = Math.toRadians(ScannerUtils.readDouble(m_input));
			
			System.out.println("Tangent: " + m_format.format(Math.tan(angle)));
			System.out.println("Sine: " + m_format.format(Math.sin(angle)));
			System.out.println("Cosine: " + m_format.format(Math.cos(angle)));
		}
	}
}
