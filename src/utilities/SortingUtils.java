package utilities;

/**
 * Collection of common array sorting methods
 * 
 * @author Jacob
 *
 */
public class SortingUtils {

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
			for (int j = i+1; j < array.length; j++) {
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

}
