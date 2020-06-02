package unit7.assignment1;

import java.awt.EventQueue;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

//@formatter:off

/*
* Jacob Klimczak
* Text Fields Assignment, Pin Question
* May 29, 2020
* ICS4U0
* 
* This program represents my own program code.
* I have not received any help in designing, writing, or debugging this program.
*/

//@formatter:on

/**
 * User attempts to unlock a digital lock within 4 attempts. Passwords are
 * hashed and compared using the SHA-1 algorithm.
 * Pin is 7980.
 * 
 * @author Jacob
 *
 */
public class PinEntry {

	// Hashes and salts 4 digit pin with SHA-1 and cryptographically secure
	// random salt, stores in base-64 string
	private static final String PIN_HASH = Encryption.base64Hash(Encryption.getRandomSalt(), "7980");
	private static final int ATTEMPTS_LIMIT = 4;

	private int m_attempts = 0;

	private JFrame m_frame;
	private JTextField m_pinField;
	private JLabel m_inputLabel;
	private JButton m_unlockButton;
	private JLabel m_indicatorLabel;
	private Component m_strut;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinEntry window = new PinEntry();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PinEntry() {
		// Setup JFrame
		m_frame = new JFrame();
		m_frame.setBounds(100, 100, 450, 300);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.getContentPane().setLayout(new BoxLayout(m_frame.getContentPane(), BoxLayout.Y_AXIS));

		// Setup Input Label
		m_inputLabel = new JLabel("Input Your Pin Below");
		m_inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		m_frame.getContentPane().add(m_inputLabel);

		// Setup Pin Field
		m_pinField = new JTextField();
		m_pinField.setHorizontalAlignment(SwingConstants.CENTER);
		m_frame.getContentPane().add(m_pinField);
		m_pinField.setColumns(10);

		// Setup Unlock Button
		m_unlockButton = new JButton("Unlock");
		m_unlockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_frame.getContentPane().add(m_unlockButton);

		m_unlockButton.addActionListener((performedAction) -> {
			// Compare Pins
			if (Encryption.compareToHash(m_pinField.getText(), PIN_HASH)) {
				// Unlock
				m_indicatorLabel.setText("Success");
			} else {
				// Remain Locked
				m_indicatorLabel.setText("Please Try Again");
				
				// Increment Attempts
				m_attempts++;
			}
			
			// Check Number Of Attempts
			if (!isWithinAttempts()) {
				m_indicatorLabel.setText("Maximum Attempts Exceeded");
				m_pinField.setEditable(false);
				m_unlockButton.setEnabled(false);
			}
		});

		// Setup Strut
		m_strut = Box.createVerticalStrut(20);
		m_frame.getContentPane().add(m_strut);

		// Setup Indicator Label
		m_indicatorLabel = new JLabel("Click `Unlock` When You Have Entered Your Pin");
		m_indicatorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		m_indicatorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_frame.getContentPane().add(m_indicatorLabel);

		// Show Frame
		m_frame.setVisible(true);
	}

	/**
	 * 
	 * @return true if user has exceeded maximum password attempts
	 */
	private boolean isWithinAttempts() {
		return m_attempts < ATTEMPTS_LIMIT;
	}

	private static class Encryption {
		private static final int PASSWORD_SALT_LENGTH = 16;
		private static final int PASSWORD_HASH_LENGTH = 16;
		private static final int PASSWORD_HASH_BIT_LENGTH = PASSWORD_HASH_LENGTH * 8;

		private static final int HASH_REPITITIONS = 16;

		/**
		 * Gets a random, cryptographically secure salt
		 * 
		 * @return A byte array containing the salt
		 */
		public static byte[] getRandomSalt() {
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[PASSWORD_SALT_LENGTH];
			random.nextBytes(salt);
			return salt;
		}

		/**
		 * Hashes the specified password with the specified salt using the SHA-1
		 * algorithm
		 * 
		 * @param salt
		 *            the salt to use when hashing
		 * @param password
		 *            the password to hash
		 * @return an array containing the salt in the first few bytes and the
		 *         hash following this
		 */
		public static byte[] hash(byte[] salt, String password) {
			byte[] hash = new byte[PASSWORD_HASH_LENGTH + salt.length];
			try {
				SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
				PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, HASH_REPITITIONS,
						PASSWORD_HASH_BIT_LENGTH);
				Key key = factory.generateSecret(keySpec);
				byte[] keyBytes = key.getEncoded();
				for (int i = 0; i < salt.length; i++) {
					hash[i] = salt[i];
				}
				for (int i = 0; i < keyBytes.length; i++) {
					hash[salt.length + i] = keyBytes[i];
				}
			} catch (Exception e) {

			}
			return hash;
		}

		/**
		 * Hashes and salts the specified password and compares to specified
		 * hash
		 * 
		 * @param password
		 *            the password to compare
		 * @param hashString
		 *            a base-64 {@link String} containing the hash and salt
		 * @return true if equal
		 */
		public static boolean compareToHash(String password, String hashString) {
			// Decodes hash into byte array
			byte[] hashAndSalt = Base64.getDecoder().decode(hashString);
			// Extracts salt from old hash
			byte[] salt = Arrays.copyOfRange(hashAndSalt, 0, PASSWORD_SALT_LENGTH);
			// Hashes new password
			byte[] newHashAndSalt = hash(salt, password);
			// Checks if hashes are equal
			return Arrays.equals(hashAndSalt, newHashAndSalt);
		}

		/**
		 * Hashes the specified password with the specified salt using the SHA-1
		 * algorithm
		 * 
		 * @param salt
		 *            the salt to use when hashing
		 * @param password
		 *            the password to hash
		 * @return the hashed and salted password encoded in a base-64
		 *         {@link String}
		 */
		public static String base64Hash(byte[] salt, String password) {
			return Base64.getEncoder().encodeToString(hash(salt, password));
		}
	}
}
