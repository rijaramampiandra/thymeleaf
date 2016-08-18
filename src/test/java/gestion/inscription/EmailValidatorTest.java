package gestion.inscription;

import org.junit.Assert;
import org.junit.Test;

import com.gestion.pilotage.validator.InputValidator;

public class EmailValidatorTest {
	@Test
	public void checkInvalidEmailTest() {
		final String[] invalidEmail = new String[] { "mkyong ", "mkyong@.com.my", "mkyong123@gmail.a",
				"mkyong123@.com", "mkyong123@.com.com", ".mkyong@mkyong.com", "mkyong()*@gmail.com", "mkyong@%*.com",
				"mkyong..2002@gmail.com", "mkyong.@gmail.com", "mkyong@mkyong@gmail.com", "mkyong@gmail.com.1a" };
		for (String temp : invalidEmail) {
			boolean valid = InputValidator.validateEmail(temp);
			System.out.println("Password is not valid : " + temp + " , " + valid);
			Assert.assertEquals("Invalide password", false, valid);
		}
	}

	@Test
	public void checkValidEmailTest() {
		final String[] validEmail = new String[] { "mkyong@yahoo.com", "mkyong-100@yahoo.com", "mkyong.100@yahoo.com" };
		for (String temp : validEmail) {
			boolean valid = InputValidator.validateEmail(temp);
			System.out.println("Password is valid : " + temp + " , " + valid);
			Assert.assertEquals(true, valid);
		}
	}

}
