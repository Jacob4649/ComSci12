package unit6.assignment1;

import java.util.ArrayList;

//@formatter:off

/*
* Jacob Klimczak
* Classes Assignment
* May 10, 2020
* ICS4U0
* 
* This program represents my own program code.
* I have not received any help in designing, writing, or debugging this program.
*/

//@formatter:on

/**
 * Class representing a single student and all his/her information
 * 
 * @author Jacob
 *
 */
public class Student {

	// Properties

	private String m_firstName;
	private String m_lastName;
	private String m_middleName;

	private String m_preferredName;

	private boolean m_sexFemale;

	private int m_credits = 0;
	private int m_hours = 0;

	private boolean m_literacyTestPassed = false;

	private long m_studentID;

	// Get/Set

	public String getFirstName() throws DataNotFoundException {
		if (m_firstName == null) {
			throw new DataNotFoundException(DataNotFoundException.FIRST_NAME);
		}
		return m_firstName;
	}

	public String getMiddleName() throws DataNotFoundException {
		if (m_middleName == null) {
			throw new DataNotFoundException(DataNotFoundException.MIDDLE_NAME);
		}
		return m_middleName;
	}

	public String getLastName() throws DataNotFoundException {
		if (m_lastName == null) {
			throw new DataNotFoundException(DataNotFoundException.LAST_NAME);
		}
		return m_lastName;
	}

	public String getFullName() throws DataNotFoundException {
		return getFirstName() + " " + getMiddleName() + " " + getLastName();
	}
	
	public String getFirstLast() throws DataNotFoundException {
		return getFirstName() + " " + getLastName();
	}
	
	public String getLastFirst() throws DataNotFoundException {
		return getLastName() + ", " + getFirstName();
	}
	
	public String getFirstInitialLast() throws DataNotFoundException {
		return getFirstName().charAt(0) + ". " + getLastName();
	}
	
	public String getLastFirstInitial() throws DataNotFoundException {
		return getLastName() + ", " + getFirstName().charAt(0);
	}
	
	public String getFirstLastInitial() throws DataNotFoundException {
		return getFirstName() + " " + getLastName().charAt(0);
	}
	
	public void setFirstName(String name) {
		m_firstName = name;
	}
	
	public void setLastName(String name) {
		m_lastName = name;
	}
	
	public void setMiddleName(String name) {
		m_middleName = name;
	}
	
	public String getPreferredName() throws DataNotFoundException {
		if (m_preferredName == null) {
			throw new DataNotFoundException(DataNotFoundException.PREFERRED_NAME);
		}
		return m_preferredName;
	}
	
	public void setPreferredName(String name) {
		m_preferredName = name;
	}
	
	public boolean isFemale() {
		return m_sexFemale;
	}
	
	public void setFemale(boolean female) {
		m_sexFemale = female;
	}

	public int getCredits() {
		return m_credits;
	}
	
	public void setCredits(int credits) {
		m_credits = credits;
	}
	
	public void addCredits(int credits) {
		setCredits(getCredits() + credits);
	}
	
	public int getHours() {
		return m_hours;
	}
	
	public void setHours(int hours) {
		m_hours = hours;
	}
	
	public void addHours(int hours) {
		setHours(getHours() + hours);
	}
	
	public void setLiteracyTest(boolean pass) {
		m_literacyTestPassed = pass;
	}
	
	public boolean passedLiteracyTest() {
		return m_literacyTestPassed;
	}
	
	public void setStudentID(long id) {
		m_studentID = id;
	}
	
	public long getStudentID() {
		return m_studentID;
	}
	
	/**
	 * 
	 * @return true if this {@link Student} is eligible to recieve an OSSD
	 */
	public boolean isOSSDEligible() {
		return passedLiteracyTest() && getHours() >= 40 && getCredits() >= 30;
	}

	/**
	 * More useful, less obtrusive wrapper for {@link NullPointerException}
	 * thrown when non-existent data in {@link Student} class is accessed
	 * 
	 * @author Jacob
	 *
	 */
	public static class DataNotFoundException extends Exception {

		public static final String STUDENT = "Unable to locate student resource";
		public static final String FIRST_NAME = "Unable to locate first name resource";
		public static final String MIDDLE_NAME = "Unable to locate middle name resource";
		public static final String LAST_NAME = "Unable to locate last name resource";
		public static final String PREFERRED_NAME = "Unable to locate preferred name resource";

		private static final long serialVersionUID = 1L;

		public DataNotFoundException() {
			this((String) null);
		}

		public DataNotFoundException(String message) {
			super(message);
		}

		public DataNotFoundException(NullPointerException exception) {
			super(exception);
		}

		public DataNotFoundException(String message, NullPointerException exception) {
			super(message + "\nThrown By: " + exception.getMessage(), exception);
		}
	}

}
