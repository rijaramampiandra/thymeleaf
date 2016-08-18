package gestion.inscription;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gestion.pilotage.utils.EncryptionPasswordUtils;

public class SHAHashingExample {
	@Test
	public void generatePassword() throws Exception {
		assertEquals("On doit avoir un mot de pass crypter",
				"8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92",
				EncryptionPasswordUtils.cryptedPassword("123456"));
	}
}
