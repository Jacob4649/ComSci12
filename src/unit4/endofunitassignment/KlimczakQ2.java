package unit4.endofunitassignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakQ2 {

	// @formatter:off
	
	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 2
	 * April 15, 2020
	 * ICS4U0
	 * 
	 * This program represents my own program code.
	 * I have not received any help in designing, writing, or debugging this program.
	 */
	
	// @formatter:on

	static final int NUMBERS_ARRAY_SIZE = 10;

	static Scanner m_input = new Scanner(System.in);

	static ArrayList<Integer> m_numbers = new ArrayList<Integer>();
	static int m_num = 0;
	static int m_slot = -1;

	public static void main(String[] args) {
		// Populate Numbers ArrayList
		for (int i = 0; i < NUMBERS_ARRAY_SIZE; i++) {
			m_numbers.add((int) (Math.random() * 101));
			// 101 is used as Math.random() never returns 1.0, so when
			// cast to an int, Math.random() * x returns values in the
			// range [0, x-1], or in this case [0, 100]
		}
		
		// Display List
		System.out.println("ArrayList: " + m_numbers.toString());

		// Prompt User For Number To Find From 0 To 100
		System.out.print("Value To Find (0-100): ");

		boolean end = false;
		
		while (!end) {
			try {
				m_num = ScannerUtils.readIntRange(m_input, 0, 100);	
				end = true;	
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input, Please Enter An Int In Range (0-100)");
			}
		}

		for (int i = 0; i < m_numbers.size(); i++) {
			// Iterate Through Numbers ArrayList, Update Slot If Value Matches
			// Value Inputed
			m_slot = (m_num == m_numbers.get(i) ? i : m_slot);
		}

		if (m_slot == -1) {
			// If No Value Was Found
			System.out.println(m_num + " Is Not In The ArrayList");
		} else {
			// Value Was Found
			System.out.println(m_num + " Is In Slot " + m_slot);
		}
	}

}
