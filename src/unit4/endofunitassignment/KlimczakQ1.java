package unit4.endofunitassignment;

import java.util.Arrays;

public class KlimczakQ1 {

	// @formatter:off
	
	/*
	 * Jacob Klimczak
	 * End Of Unit Assignment, Question 1
	 * April 15, 2020
	 * ICS4U0
	 * 
	 * This program represents my own program code.
	 * I have not received any help in designing, writing, or debugging this program.
	 */
	
	// @formatter:on

	/**
	 * I wasn't sure if the program was intended to work with the values
	 * provided in the example output, or with random values. Due to this I
	 * included this flag. Please set it to true if you want to enable random
	 * values, otherwise, it will work with the values from the example.
	 */
	static final boolean POPULATE_RANDOM = false;

	static double[][] m_grades = new double[12][5];
	static double[] m_studentAverages = new double[12];
	static double[] m_assessmentAverages = new double[5];
	static double m_overallAverage = 0;

	public static void main(String[] args) {

		// Populate Grades Array Prior To Calculations

		if (POPULATE_RANDOM) {
			// Populate grades array with random values from
			// 1 to 100, all ints cast to double
			for (double[] student : m_grades) {
				for (int i = 0; i < student.length; i++) {
					student[i] = (double) ((int) (Math.random() * 101));
					// 101 is used as Math.random() never returns 1.0, so when
					// cast to an int, Math.random() * x returns values in the
					// range [0, x-1], or in this case [0, 100]
				}
			}
		} else {

			// @formatter:off
			
			m_grades = new double[][] {
				{99, 42, 74, 83, 75},
				{90, 91, 72, 88, 85},
				{88, 61, 74, 89, 78},
				{61, 89, 82, 98, 82},
				{93, 73, 75, 78, 80},
				{50, 65, 92, 87, 73},
				{43, 98, 78, 56, 69},
				{63, 89, 87, 64, 76},
				{88, 78, 85, 87, 84},
				{43, 49, 52, 56, 51},
				{88, 78, 85, 87, 84},
				{43, 49, 52, 56, 51}
			};
			
			// @formatter:on

		}

		// Calculate Values

		// Calculate Student Averages
		for (int i = 0; i < m_grades.length; i++) {
			// Iterate Through Students
			for (int j = 0; j < m_grades[i].length; j++) {
				// Iterate Through Grades And Calculate Averages
				m_studentAverages[i] += m_grades[i][j] / m_grades[i].length;
			}
			// Round Student Average To One Decimal Place
			m_studentAverages[i] = Math.round(m_studentAverages[i] * 10) / 10d;
		}

		// Calculate Assessment Averages
		for (int i = 0; i < m_grades[0].length; i++) {
			// Iterate Through Assessments
			for (int j = 0; j < m_grades.length; j++) {
				// Iterate Through Student Grades And Calculate Averages
				m_assessmentAverages[i] += m_grades[j][i] / m_grades.length;
			}
			// Round Assessment Average To One Decimal Place
			m_assessmentAverages[i] = Math.round(m_assessmentAverages[i] * 10) / 10d;
		}

		// Calculate Overall Average
		for (double grade : m_studentAverages) {
			m_overallAverage += grade / m_studentAverages.length;
		}
		// Round Overall Average To One Decimal Place
		m_overallAverage = Math.round(m_overallAverage * 10) / 10d;

		// Output Values

		System.out.println("Student Grades");
		System.out.println();

		for (int i = 0; i < m_grades.length; i++) {
			System.out.println("Student\t" + (i + 1) + "\t=\t" + Arrays.toString(m_grades[i])
					+ "\t The Student's Average Is " + m_studentAverages[i]);
		}

		System.out.println();
		System.out.println("Assessment Averages: " + Arrays.toString(m_assessmentAverages));
		System.out.println("The Overall Average Is " + m_overallAverage);
	}

}
