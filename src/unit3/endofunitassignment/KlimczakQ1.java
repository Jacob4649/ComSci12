package unit3.endofunitassignment;

public class KlimczakQ1 {

	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 1
	 * March 3, 2020
	 * ICS4U0
	 */
	
	public static void main(String[] args) {
		House.addRoof();
		House.addBase();
		House.addWalk();
	}
	
	static class House {
		
		/**
		 * Displays the roof for the house
		 */
		public static void addRoof() {
			System.out.println("   /\\   ");
			System.out.println("  /  \\  ");
			System.out.println(" /    \\ ");
			System.out.println("/______\\");
		}
		
		/**
		 * Displays the base for the house
		 */
		public static void addBase() {
			System.out.println("|      |");
			System.out.println("|      |");
			System.out.println("|      |");
			System.out.println("|______|");
		}
		
		/**
		 * Displays the walkway for the house
		 */
		public static void addWalk() {
			System.out.println("   **");
			System.out.println("   ***********");
		}	
	}
}
