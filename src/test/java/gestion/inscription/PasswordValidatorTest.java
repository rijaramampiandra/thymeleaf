package gestion.inscription;

import org.junit.Assert;
import org.junit.Test;

import com.gestion.pilotage.validator.InputValidator;

/**
 * Test de validation de mot de passe.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public class PasswordValidatorTest {
	@Test
	public void checkInvalidPasswordTest() {
		final String[] password = new String[] { "mY1A@", "mkyong12@", "mkyoNg12*", "mkyonG$$", "MKYONG12$" };
		for (String temp : password) {
			boolean valid = InputValidator.validatePassword(temp);
			System.out.println("Password is not valid : " + temp + " , " + valid);
			Assert.assertEquals("Invalide password", false, valid);
		}
	}

	@Test
	public void checkValidPasswordTest() {
		final String[] password = new String[] { "mkyong1A@", "mkYOn12$", "mkYOn12!" };
		for (String temp : password) {
			boolean valid = InputValidator.validatePassword(temp);
			System.out.println("Password is valid : " + temp + " , " + valid);
			Assert.assertEquals(true, valid);
		}
	}
}
