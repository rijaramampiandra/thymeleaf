package gestion.inscription;

import org.junit.Test;

import com.gestion.pilotage.utils.SendMailSslUtils;

public class SendEmailTest {
	@Test
	public void sendEmailTest() {
		SendMailSslUtils.sendEmail("rija@gmail.com");
	}
}