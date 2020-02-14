package unit2.assignment1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.ScannerUtils;

public class KlimczakA1Q2 {

	/*
	 * Jacob Klimczak
	 * Assignment 1, Question 2
	 * February 10, 2020
	 * ICS4U0
	 */
	
	static Scanner m_input = new Scanner(System.in);
	static String m_text = "";
	static int m_count = 0;
	
	public static void main(String[] args) {
		
		//intro
		System.out.println("Ja_a Counter");
		System.out.println();
		System.out.print("Please Enter Some Text:\n--> ");
		
		m_text = ScannerUtils.read(m_input); //get text to search
		
		Matcher matcher = Pattern.compile("(?i)ja\\wa").matcher(m_text);
		
		while (matcher.find()) {
			m_count++;
		}
		
		System.out.println();
		
		System.out.println(m_count + " Occurences Of Ja_a");
		
	}
	
}
