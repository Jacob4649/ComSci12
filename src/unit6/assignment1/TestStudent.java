package unit6.assignment1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilities.ScannerUtils;

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

public class TestStudent {

	static ArrayList<Student> m_students = new ArrayList<Student>();
	static Scanner m_input = new Scanner(System.in);
	static StudentDisplayPrefs m_prefs = new StudentDisplayPrefs();

	static boolean m_end;

	public static void main(String[] args) {
		// INIT

		m_prefs.setOnUpdate(TestStudent::displayStudentList);

		// Start UI

		m_prefs.forceUpdate();

		m_end = false;

		while (!m_end) {

			prompt();

		}

		System.out.println();
		System.out.println("Terminating Program");
	}

	/**
	 * Displays a single {@link Student}
	 * 
	 * @param student
	 *            the {@link Student} to display
	 */
	public static void showStudent(Student student) {

		clearConsole();

		System.out.println("-- Single Student --");

		System.out.println("Student ID: " + student.getStudentID());

		System.out.print("Full Name: ");

		try {
			System.out.println(student.getFullName());
		} catch (Student.DataNotFoundException e) {
			System.out.println("INCOMPLETE DATA");
		}

		System.out.print("Preferred Name: ");

		try {
			System.out.println(student.getPreferredName());
		} catch (Student.DataNotFoundException e) {
			System.out.println("INCOMPLETE DATA");
		}

		System.out.println("Sex: " + (student.isFemale() ? "Female" : "Male"));

		System.out.println("Credits: " + student.getCredits());

		System.out.println("Volunteer Hours: " + student.getHours());

		System.out.println("OSSLT: " + (student.passedLiteracyTest() ? "Passed" : "Failed"));

		System.out.println("OSSD: " + (student.isOSSDEligible() ? "Eligible" : "Not Eligible"));

		System.out.println("--------------------");
	}

	/**
	 * The prompt of actions that can be performed on a single {@link Student}
	 * 
	 * @param student
	 *            the {@link Student} to select
	 */
	public static void studentPrompt(Student student) {

		showStudent(student);

		boolean end = false;

		while (!end) {
			System.out.println();
			System.out.print(
					"\t1 - View Student\r\n\t2 - Add Credits\r\n\t3 - Add Volunteer Hours\r\n\t4 - Update OSSLT Status\r\n\t5 - Exit\r\n\t>>> ");

			int input = 0;

			boolean gotInput = true;
			do {
				gotInput = true;
				try {
					input = ScannerUtils.readIntRange(m_input, 1, 5);
				} catch (InputMismatchException e) {
					gotInput = false;
					System.out.println("Invalid Input");
					m_input.nextLine();
				}
			} while (!gotInput);

			switch (input) {
			case 1:
				showStudent(student);
				break;
			case 2:

				System.out.println();
				System.out.print("\tHow Many Credits? (0 - 100) >>> ");

				int credits = 0;

				boolean gotCredits = true;
				do {
					gotCredits = true;
					try {
						credits = ScannerUtils.readIntRange(m_input, 0, 100);
					} catch (InputMismatchException e) {
						gotCredits = false;
						System.out.println("Invalid Input");
						m_input.nextLine();
					}
				} while (!gotCredits);

				student.addCredits(credits);

				break;
			case 3:

				System.out.println();
				System.out.print("\tHow Many Hours? (0 - 1000) >>> ");

				int hours = 0;

				boolean gotHours = true;
				do {
					gotHours = true;
					try {
						hours = ScannerUtils.readIntRange(m_input, 0, 1000);
					} catch (InputMismatchException e) {
						gotHours = false;
						System.out.println("Invalid Input");
						m_input.nextLine();
					}
				} while (!gotHours);

				student.addHours(hours);

				break;
			case 4:

				System.out.println();
				System.out.print("\tStudent Passed? (y/n) >>> ");

				student.setLiteracyTest(ScannerUtils.yesQuery(m_input));

				break;
			case 5:
				end = true;
				clearConsole();
				break;
			}
		}

	}

	/**
	 * Queries the user for specifications of new {@link Student} to generate
	 * 
	 * @return the generated {@link Student}
	 */
	public static Student generateStudent() {
		Student output = new Student();

		System.out.println();
		System.out.print("\tStudent ID? >>> ");

		output.setStudentID(ScannerUtils.readLong(m_input));

		System.out.println();
		System.out.print("\tFirst Name? >>> ");

		output.setFirstName(ScannerUtils.read(m_input));

		System.out.println();
		System.out.print("\tMiddle Name? >>> ");

		output.setMiddleName(ScannerUtils.read(m_input));

		System.out.println();
		System.out.print("\tLast Name? >>> ");

		output.setLastName(ScannerUtils.read(m_input));

		System.out.println();
		System.out.print("\tPreferred Name? >>> ");

		output.setPreferredName(ScannerUtils.read(m_input));

		System.out.println();
		System.out.print("\tFemale? (y/n) >>> ");

		output.setFemale(ScannerUtils.yesQuery(m_input));

		System.out.println();
		System.out.print("\tHow Many Credits? >>> ");

		output.setCredits(ScannerUtils.readInt(m_input));

		System.out.println();
		System.out.print("\tHow Many Volunteer Hours? >>> ");

		output.setHours(ScannerUtils.readInt(m_input));

		System.out.println();
		System.out.print("\tPassed Literacy Test? (y/n) >>> ");

		output.setLiteracyTest(ScannerUtils.yesQuery(m_input));

		return output;
	}

	/**
	 * Prompts user for a command and handles response
	 */
	public static void prompt() {
		System.out.println();
		System.out.print(
				"\t1 - View Students\r\n\t2 - Select/View/Edit Student By Index\r\n\t3 - Add Student\r\n\t4 - Display Settings\r\n\t5 - Quit\r\n\t>>> ");

		int input = 0;

		boolean end = true;
		do {
			end = true;
			try {
				input = ScannerUtils.readIntRange(m_input, 1, 5);
			} catch (InputMismatchException e) {
				end = false;
				System.out.println("Invalid Input");
				m_input.nextLine();
			}
		} while (!end);

		switch (input) {
		case 1:
			m_prefs.forceUpdate();
			break;
		case 2:

			if (!(m_students.size() > 0)) {
				System.out.println();
				System.out.println("\tAdd Some Students To The System First");
				break;
			} else {
				System.out.println();
				System.out.print("\tStudent Index? >>> ");
			}

			int student = 0;

			boolean foundStudent = true;
			do {
				foundStudent = true;
				try {
					student = ScannerUtils.readIntRange(m_input, 0, m_students.size() - 1);
				} catch (InputMismatchException e) {
					foundStudent = false;
					System.out.println("Invalid Input");
					m_input.nextLine();
				}
			} while (!foundStudent);

			studentPrompt(m_students.get(student));

			break;
		case 3:
			m_students.add(generateStudent());
			break;
		case 4:

			System.out.println();
			System.out.print("\t1 - Set Name Display Mode\r\n\t2 - Toggle Display ID (Currently: "
					+ (m_prefs.getDisplayID() ? "ON" : "OFF") + ")\r\n\t3 - Toggle Display OSSD (Currently: "
					+ (m_prefs.getDisplayOSSD() ? "ON" : "OFF") + ")\r\n\t4 - Exit\r\n\t>>> ");

			int displaySetting = 0;

			boolean exitDisplay = true;
			do {
				exitDisplay = true;
				try {
					displaySetting = ScannerUtils.readIntRange(m_input, 1, 4);
				} catch (InputMismatchException e) {
					exitDisplay = false;
					System.out.println("Invalid Input");
					m_input.nextLine();
				}
			} while (!exitDisplay);

			switch (displaySetting) {
			case 1:

				System.out.println();
				System.out.print(
						"\t1 - John Smith\r\n\t2 - Smith, Josh\r\n\t3 - J. Smith\r\n\t4 - Smith, J.\r\n\t5 - John S.\r\n\t>>> ");

				int nameMode = 0;

				boolean exitName = true;
				do {
					exitName = true;
					try {
						nameMode = ScannerUtils.readIntRange(m_input, 1, 5);
					} catch (InputMismatchException e) {
						exitName = false;
						System.out.println("Invalid Input");
						m_input.nextLine();
					}
				} while (!exitName);
				
				switch (nameMode) {
				case 1:
					m_prefs.setNameDisplayMode(StudentDisplayPrefs.NameDisplayMode.FIRST_LAST);
					break;
				case 2:
					m_prefs.setNameDisplayMode(StudentDisplayPrefs.NameDisplayMode.LAST_FIRST);
					break;
				case 3:
					m_prefs.setNameDisplayMode(StudentDisplayPrefs.NameDisplayMode.F_LAST);
					break;
				case 4:
					m_prefs.setNameDisplayMode(StudentDisplayPrefs.NameDisplayMode.LAST_F);
					break;
				case 5:
					m_prefs.setNameDisplayMode(StudentDisplayPrefs.NameDisplayMode.FIRST_L);
					break;
				}
				
				break;
			case 2:
				m_prefs.setDisplayID(!m_prefs.getDisplayID());
				break;
			case 3:
				m_prefs.setDisplayOSSD(!m_prefs.getDisplayOSSD());
				break;
			case 4:
				break;
			}

			break;
		case 5:
			m_end = true;
			break;
		}
	}

	/**
	 * Displays all information about the students
	 */
	public static void displayStudentList() {
		clearConsole();
		System.out.println("----- Students -----");
		System.out.println("Index:, " + (m_prefs.getDisplayID() ? "ID:, " : "")
				+ "Name:, Credits:, Hours:, OSSLT:" + (m_prefs.getDisplayOSSD() ? ", OSSD Eligible:" : ""));

		for (int i = 0; i < m_students.size(); i++) {
			System.out.println(i + ", " + (m_prefs.getDisplayID() ? m_students.get(i).getStudentID() + ", " : "")
					+ m_prefs.getName(m_students.get(i)) + ", " + m_students.get(i).getCredits() + ", "
					+ m_students.get(i).getHours() + ", " + m_prefs.getOSSLTPassed(m_students.get(i))
					+ (m_prefs.getDisplayOSSD() ? ", " + m_prefs.getOSSDEligible(m_students.get(i)) : ""));
		}

		System.out.println("--------------------");
	}

	/**
	 * Clears the console by writing exactly 201 newline characters (201 because
	 * final string is printed through System.out.println)
	 */
	public static void clearConsole() {
		StringBuilder clearStringBuilder = new StringBuilder();
		for (int i = 0; i < 200; i++) {
			clearStringBuilder.append("\r\n");
		}
		System.out.println(clearStringBuilder.toString());
	}

	/**
	 * Class representing user set preferences on how to display {@link Student}
	 * information
	 * 
	 * @author Jacob
	 *
	 */
	static class StudentDisplayPrefs {

		private boolean m_displayID = false;
		private boolean m_displayOSSD = false;

		private NameDisplayMode m_nameType = NameDisplayMode.FIRST_LAST;

		private Runnable m_onUpdate;

		/**
		 * Sets the format names are to be displayed in
		 * 
		 * @param mode
		 *            The format to display names in
		 */
		public void setNameDisplayMode(NameDisplayMode mode) {
			m_nameType = mode;
			forceUpdate();
		}

		/**
		 * Indicates whether to display student ids
		 * 
		 * @param display
		 *            true if ids are to be displayed, false otherwise
		 */
		public void setDisplayID(boolean display) {
			m_displayID = display;
			forceUpdate();
		}

		/**
		 * 
		 * @return true if student ids are to be displayed
		 */
		public boolean getDisplayID() {
			return m_displayID;
		}

		/**
		 * Indicates whether to display OSSD eligibility
		 * 
		 * @param display
		 *            true if eligibility is to be displayed, false otherwise
		 */
		public void setDisplayOSSD(boolean display) {
			m_displayOSSD = display;
			forceUpdate();
		}

		/**
		 * 
		 * @return true if OSSD eligibility is to be displayed
		 */
		public boolean getDisplayOSSD() {
			return m_displayOSSD;
		}

		/**
		 * Gets the name of the specified student in the format specified by
		 * these {@link StudentDisplayPrefs}
		 * 
		 * @param student
		 *            The student who's name should be fetched
		 * @return the name of the student in the desired format
		 */
		public String getName(Student student) {
			try {
				switch (m_nameType) {
				default:
				case FIRST_LAST:
					return student.getFirstLast();
				case LAST_FIRST:
					return student.getLastFirst();
				case F_LAST:
					return student.getFirstInitialLast();
				case LAST_F:
					return student.getLastFirstInitial();
				case FIRST_L:
					return student.getFirstLastInitial();
				}
			} catch (Student.DataNotFoundException e) {
				return "INCOMPLETE DATA";
			} catch (IndexOutOfBoundsException e) {
				return "INVALID DATA";
			}
		}

		/**
		 * Gets a string indicating whether the {@link Student} is eligible for
		 * an OSSD
		 * 
		 * @param student
		 *            the {@link Student} to indicate for
		 * @return "Yes" if eligible, "No" if not
		 */
		public String getOSSDEligible(Student student) {
			return (student.isOSSDEligible() ? "Yes" : "No");
		}

		/**
		 * Gets a string indicating whether the {@link Student} has passed the
		 * OSSLT
		 * 
		 * @param student
		 *            the {@link Student} to indicate for
		 * @return "Pass" if they passed, "Fail" otherwise
		 */
		public String getOSSLTPassed(Student student) {
			return student.passedLiteracyTest() ? "Pass" : "Fail";
		}

		/**
		 * 
		 * @param onUpdate
		 *            This runnable is executed every time these prefs are
		 *            updated
		 */
		public void setOnUpdate(Runnable onUpdate) {
			m_onUpdate = onUpdate;
		}

		/**
		 * Forces the update runnable to run, handles null runnables
		 */
		public void forceUpdate() {
			if (m_onUpdate != null) {
				m_onUpdate.run();
			}
		}

		/**
		 * Represents the desired name format
		 * 
		 * @author Jacob
		 *
		 */
		static enum NameDisplayMode {
			/**
			 * First Name Last Name
			 * <p>
			 * (i.e. Jacob Klimczak)
			 */
			FIRST_LAST,
			/**
			 * Last Name, First Name
			 * <p>
			 * (i.e. Klimczak, Jacob)
			 */
			LAST_FIRST,
			/**
			 * First Initial. Last Name
			 * <p>
			 * (i.e. J. Klimczak)
			 */
			F_LAST,
			/**
			 * Last Name, First Initial
			 * <p>
			 * (i.e. Klimcak, J)
			 */
			LAST_F,
			/**
			 * First Name Last Initial.
			 * <p>
			 * (i.e. Jacob K.)
			 */
			FIRST_L
		}

	}

}
