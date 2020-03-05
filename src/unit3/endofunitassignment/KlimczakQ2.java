package unit3.endofunitassignment;

public class KlimczakQ2 {

	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 2
	 * March 4, 2020
	 * ICS4U0
	 */
	
	public static void main(String[] args) {
		System.out.println("Pythagorea Triples");
		System.out.println();
		
		System.out.println("Displaying All Pythagorean Triples With Values Of A and B less than 100 (A^2 + B^2 = C^2):");
		
		// Iterate through all possible values for A and B where A and B are both less than 100
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				// If A^2 + B^2 is a perfect square (i.e. C is an integer),
				// print the current values
				
				if (isPerfectSquare((int) (Math.pow(i, 2) + Math.pow(j, 2)))) {
					System.out.println("A: " + i + ", B: " + j + ", C: " + (int) (Math.pow(i, 2) + Math.pow(j, 2)));
				}
			}
		}
	}
	
	/**
	 * Indicates whether the specified number is whole (i.e. an integer)
	 * @param d The number to check
	 * @return true if the number is an integer, false otherwise
	 */
	static boolean isInteger(double d) {
		
		// Truncate and then compare to original value,
		// for integers, truncation will change nothing and this check
		// will return true
		
		return (int) d == d;
	}
	
	/**
	 * Indicates whether the specified number is a perfect square
	 * @return true if the number is a perfect square
	 */
	static boolean isPerfectSquare(int i) {
		return isInteger(Math.sqrt(i));
	}
	
}
