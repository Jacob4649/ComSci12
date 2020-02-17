package unit2.assignment2;

import java.util.Scanner;

import utilities.ScannerUtils;

import java.lang.*;

public class KlimczakA2Q5 {

	/*
	 * Jacob Klimczak
	 * Assignment 2, Question 5
	 * February 17, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	
	static int m_startHour, m_elapsed;

	static long m_startTime;
	
	public static void main(String[] args) {
		//intro
		System.out.println("Elapsed Time Calculator (Modified Edition)");
		System.out.println();
		System.out.print("Enter The Starting Hour: ");
		m_startHour = ScannerUtils.readIntRange(m_input, 1, 12);
		m_startTime = System.currentTimeMillis();
		System.out.print("Enter AM Or PM: ");
		while (true) {
			String input = ScannerUtils.read(m_input);
			if (input.matches("(?i)^am$")) {
				m_startHour = (m_startHour == 12 ? 0 : m_startHour);
				break;
			} else if (input.matches("(?i)^pm$")) {
				m_startHour += (m_startHour == 12 ? 0 : 12);
				break;
			} else {
				System.out.println("Invalid Input");
			}
		}
		System.out.print("Enter The Number Of Elapsed Hours: ");
		m_elapsed = ScannerUtils.readInt(m_input);
		int time = (m_startHour + m_elapsed) % 24;
		System.out.println("The Time Is " + (time % 12 == 0 ? 12 : time % 12) + " " + (time > 11 ? "PM" : "AM"));
		System.out.println();
		long diff = (System.currentTimeMillis() - m_startTime);
		System.out.println("Time Elapsed Since User Input: " + diff + " Milliseconds Or " + (((double) diff) / 1000d) + " Seconds");
	}
	
}
