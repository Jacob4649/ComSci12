package unit3.endofunitassignment;

import java.util.ArrayList;

public class KlimczakQ4 {

	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 4
	 * March 4, 2020
	 * ICS4U0
	 */
	
	public static void main(String[] args) {
		System.out.println("Perfect Numbers");
		System.out.println();
		
		System.out.println("Here Are All Perfect Numbers Less Than 100:");
		
		for (int i = 1; i < 101; i++) {
			if (isPerfect(i)) {
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Indicaters whether the specified number is perfect
	 * (equal to the sum of its non inclusive factors)
	 * @param i The specified number
	 * @return {@code true} if i is perfect
	 */
	static boolean isPerfect(int i) {
		return sumArray(getNonInclusiveFactors(i)) == i;
	}
	
	/**
	 * Sums all the elements in the specified array
	 * @param i The {@code int[]} to sum the elements of
	 * @return The sum of the elements in the specified array
	 */
	static int sumArray(int[] i) {
		int sum = 0;
		for (int q : i) {
			sum += q;
		}
		return sum;
	}
	
	/**
	 * Finds all factors of a specified number, except for the number itself, and including 1
	 * @param i The number to find factors of
	 * @return An {@code int[]} containing all the factors of i
	 */
	static int[] getNonInclusiveFactors(int i) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Search until sqrt because each factor less than the sqrt
		// has a corresponding factor greater than the
		// sqrt that can be found by i/q for any factor q
		
		for (int q = 1; q <= Math.sqrt(i); q++) {
			if (isFactor(i, q)) {
				
				// Checks if q is the number we are searching for factors of,
				// only adds to list if it isn't
				// only used in cases where i is 1 since searching for
				// values of q less than sqrt of i
				
				if (q != i) {
					list.add(q);	
				}
				
				// Add the corresponding factor greater than the sqrt
				// unless it is equal to the factor just added
				// or it is the number itself
				// (i.e. perfect square case or i/q == i (q == 1))
				
				if (i/q != q && i/q != i) { 
					list.add(i/q);	
				}
			}
		}
		
		int[] ret = new int[list.size()];
		for (int q = 0; q < list.size(); q++) {
			ret[q] = list.get(q);
		}
		return ret;
	}
	
	/**
	 * Checks if the indicated number is a factor
	 * @param a the potential multiple
	 * @param b the potential factor
	 * @return {@code true} if a is a factor of b
	 */
	static boolean isFactor(int a, int b) {
		return a % b == 0;
	}
	
}
