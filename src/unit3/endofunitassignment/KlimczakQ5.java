package unit3.endofunitassignment;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakQ5 {

	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 5
	 * March 4, 2020
	 * ICS4U0
	 */
	
	static final int MAX_STONES = 30;
	static final int MIN_STONES = 15;
	
	static Scanner m_input = new Scanner(System.in);
	static int m_stones = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Jacob's Nim");
		
		do {
			System.out.println();
			
			// The +1 is in the difference because Math.random() never returns 1.0 
			// thus when the result is truncated to an int, the max value will never be attained.
			// All this does is move the possible values for stones from the open ended interval [15, 30),
			// to the closed ended interval [15, 30]
			
			m_stones = MIN_STONES + (int) (Math.random() * (MAX_STONES - MIN_STONES + 1));
			
			while (true) {
				
				// Player takes his turn
				
				playerTurn();
				
				// Check if player has lost
				
				if (m_stones == 0) {
					System.out.println("The computer beats the player!");
					break;
				}
				
				// Computer takes his turn
				
				computerTurn();
				
				// Check if opponent has lost
				
				if (m_stones == 0) {
					System.out.println("The player beats the computer!");
					break;
				}
				
			}
			
			// Query For Play Again
			
			System.out.println();
			System.out.print("Would You Like To Play Again (y/n)? ");
		} while (ScannerUtils.yesQuery(m_input));
		
		System.out.println();
		System.out.println("Program Terminated");
	}
	
	/**
	 * Indicates whether a move removing the specified number of stones would be valid
	 * @param i The hypothetical number of stones to remove
	 * @return true if the move is valid, false otherwise
	 */
	static boolean isValidEntry(int i) {
		return m_stones - i >= 0 && i >= 1 && i <= 3;
	}
	
	/**
	 * Generates a random number of stones for the computer to take from 1 to 3,
	 * or less if fewer stoens are available
	 * @return The generated random number of stones
	 */
	static int drawStones() {
		
		// Generates a random number from 0 to 2, adds 1 to it.
		// Resulting range of possible values is [1, 3], or in cases
		// where fewer than 3 stones are available, [1, # of stones]
		
		return (int) (Math.random() * (m_stones > 3 ? 3 : m_stones)) + 1;
	}
	
	/**
	 * Takes a turn for the player
	 */
	static void playerTurn() {
		System.out.print("There are " + m_stones + " stones. How many would you like (1-3)? ");
		
		int stones = 0;
		while (true) {
			stones = ScannerUtils.readInt(m_input);
			if (isValidEntry(stones)) {
				break;
			}
			System.out.println("Invalid Entry, Please Enter A Number From 1 - 3");
		}
		
		// Remove stones 
		
		m_stones -= stones;
	}
	
	/**
	 * Takes a turn for the computer
	 */
	static void computerTurn() {
		int stones = drawStones();
		
		System.out.println("There are " + m_stones + " stones. The computer takes " + stones);
		
		// Remove stones
		
		m_stones -= stones;
	}
}
