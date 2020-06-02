package utilities;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Collection of useful encryption and hashing methods
 * 
 * @author Jacob
 *
 */
public class EncryptionUtils {
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
