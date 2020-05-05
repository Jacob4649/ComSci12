package unit5.assignment1;

import java.util.Arrays;

// @formatter:off

/*
 * Jacob Klimczak
 * Sorting Assignment
 * April 30, 2020
 * ICS4U0
 * 
 * This program represents my own program code.
 * I took my code for convenient boxing of int arrays into arrays from this Stack Overflow question: 
 * https://stackoverflow.com/questions/880581/how-to-convert-int-to-integer-in-java
 */

// @formatter:on

public class KlimczakSorting {

	// Constants

	// Sort Times Indices
	public static final int DUAL_PIV_QUICK = 0;
	public static final int BUBBLE = 1;
	public static final int INSERTION = 2;
	public static final int SELECTION = 3;

	// Array Size Times Indices
	public static final int K5 = 0;
	public static final int K10 = 1;
	public static final int K50 = 2;
	public static final int K75 = 3;
	public static final int K100 = 4;
	public static final int K150 = 5;

	// Static Variables

	static long[][] m_times = new long[4][6];

	public static void main(String[] args) {
		System.out.println("Java Sorting Methods");
		System.out.println();

		// Calculate Times

		System.out.println("\tTesting Bubble Sort");
		System.out.println();

		m_times[BUBBLE] = sortTestSuite(KlimczakSorting::bubbleSort);

		System.out.println("\tFinished Testing Bubble Sort");
		System.out.println();

		System.out.println("\tTesting Selection Sort");
		System.out.println();

		m_times[SELECTION] = sortTestSuite(KlimczakSorting::selectionSort);

		System.out.println("\tFinished Testing Selection Sort");
		System.out.println();

		System.out.println("\tTesting Insertion Sort");
		System.out.println();

		m_times[INSERTION] = sortTestSuite(KlimczakSorting::insertionSort);

		System.out.println("\tFinished Testing Insertion Sort");
		System.out.println();

		System.out.println("\tTesting Arrays.sort");
		System.out.println();

		m_times[DUAL_PIV_QUICK] = sortTestSuite(KlimczakSorting::dualPivotQuickSort);

		System.out.println("\tFinished Testing Arrays.sort");
		System.out.println();

		// Output Times
		for (int i = 0; i < 4; i++) {
			String sortName = "";
			switch (i) {
			case DUAL_PIV_QUICK:
				sortName = "Arrays.sort: O(n log n)";
				break;
			case BUBBLE:
				sortName = "Bubble Sort: O(n^2)";
				break;
			case INSERTION:
				sortName = "Insertion Sort: O(n^2)";
				break;
			default:
			case SELECTION:
				sortName = "Selection Sort: O(n^2)";
			}

			System.out.println("\t" + sortName);
			System.out.println("\t\t5K Items -> " + m_times[i][K5] + " Nanoseconds");
			System.out.println("\t\t10K Items -> " + m_times[i][K10] + " Nanoseconds");
			System.out.println("\t\t50K Items -> " + m_times[i][K50] + " Nanoseconds");
			System.out.println("\t\t75K Items -> " + m_times[i][K75] + " Nanoseconds");
			System.out.println("\t\t100K Items -> " + m_times[i][K100] + " Nanoseconds");
			System.out.println("\t\t150K Items -> " + m_times[i][K150] + " Nanoseconds");
			System.out.println();
		}
	}

	/**
	 * Returns the sort times on random int arrays with elements between 0 and
	 * 1000 (inclusive), for arrays of size 5000, 10000, 50000, 75000, 100000,
	 * and 150000
	 * 
	 * @param sort
	 *            The {@link Sort} to use
	 * @return An array containing the times in their respective indices
	 */
	public static final long[] sortTestSuite(Sort sort) {

		// @formatter:off
		
		return new long[] { sortElapsedTime(sort, 5000), 
				sortElapsedTime(sort, 10000), 
				sortElapsedTime(sort, 50000),
				sortElapsedTime(sort, 75000), 
				sortElapsedTime(sort, 100000), 
				sortElapsedTime(sort, 150000) };
	
		// @formatter:on

	}

	/**
	 * Gets the time elapsed while sorting a random array filled with integers
	 * from 1 to 1000 (inclusive) with a specified sort
	 * 
	 * @param sort
	 *            The {@link Sort} to use
	 * @param size
	 *            The size of the array to generate
	 * @return The time elapsed in nano seconds
	 */
	public static final long sortElapsedTime(Sort sort, int size) {
		// Output to console so user is aware system is not inactive
		System.out.println("\t\tTesting " + size + " Elements");

		// Generate array
		int[] array = randomArray(size);

		// Box values for use with generic sort methods
		Integer[] intArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

		// Initialize start and end times
		long start, end;

		// Sort and time
		start = System.nanoTime();
		sort.sort(intArray);
		end = System.nanoTime();

		// Report finished test
		System.out.println("\t\tFinished Testing " + size + " Elements");
		System.out.println();

		// Return elapsed time
		return end - start;
	}

	/**
	 * Generates and populates an int array with random values from 1 to 1000
	 * 
	 * @param size
	 *            the size of the array to generate
	 * @return The generated and populated array
	 */
	public static final int[] randomArray(int size) {
		int[] output = new int[size];
		for (int i = 0; i < size; i++) {
			output[i] = (int) (1001d * Math.random());
		}
		return output;
	}

	// Sorting Methods

	/**
	 * Sorts array of type T where T implements the {@link Comparable}
	 * interface. Uses the bubble sort algorithm, sorts in O(n^2)
	 * 
	 * @param array
	 *            The array to sort
	 * @return A reference to the sorted array, is the array provided as
	 *         argument, just sorted, not a clone
	 */
	public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int swaps = 0; // Track number of swaps made
			for (int j = 0; j < i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					// Elements are out of order
					T temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					swaps++;
					// Increment swaps to indicate changes have been
					// made to the array in this pass
				}
			}
			if (swaps == 0) {
				break; // If no swaps are made in a pass, the array is sorted
			}
		}
		return array;
	}

	/**
	 * Sorts an array of type T where T implements the {@link Comparable}
	 * interface. Uses the insertion sort algorithm, sorts in O(n^2)
	 * 
	 * @param array
	 *            The array to sort
	 * @return A reference to the sorted array, is the array provided as
	 *         argument, just sorted, not a clone
	 */
	public static <T extends Comparable<T>> T[] insertionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T temp = array[i];
			int j = i;
			while (j > 0 && array[j - 1].compareTo(temp) > 0) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
		return array;
	}

	/**
	 * Sorts an array of type T where T implements the {@link Comparable}
	 * interface. Uses the selection sort algorithm, sorts in O(n^2)
	 * 
	 * @param array
	 *            The array to sort
	 * @return A reference to the sorted array, is the array provided as
	 *         argument, just sorted, not a clone
	 */
	public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min].compareTo(array[j]) < 0) {
					min = j;
				}
			}
			if (min != i) {
				T temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
		return array;
	}

	/**
	 * Sorts an array using Arrays.sort, this method is necessary as the
	 * {@link Sort} interface uses generic methods with type parameters, making
	 * them impossible to use with lambda expressions. Method references;
	 * however, are allowed to generic methods. As such, this method is needed
	 * to allow the sortElapsedTime method to use Java's Arrays.sort method. No
	 * unboxing is done as the Arrays.sort(Object[]) method should handle
	 * {@link Integer} arrays easily.
	 * 
	 * @param array
	 *            The array to sort
	 * @return A reference to the sorted array, is the array provided as
	 *         argument, just sorted, not a clone
	 */
	public static <T extends Comparable<T>> T[] dualPivotQuickSort(T[] array) {
		Arrays.sort(array);
		return array;
	}

	/**
	 * Interface for a single sort for a generic array
	 * 
	 * @author Jacob
	 *
	 */
	static interface Sort {
		/**
		 * Sorts a generic array from least to greatest
		 * 
		 * @param array
		 *            The array to sort
		 * @return The sorted array
		 */
		public <T extends Comparable<T>> T[] sort(T[] array);
	}

}
