package com.gestion.pilotage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gestion.pilotage.controlleur.AddOrEditUserController;

public class SendMailSslUtils {

	private static final Logger logger = LoggerFactory.getLogger(AddOrEditUserController.class);

	/**
	 * Envoi de mail au client qui vient de s'inscrire.
	 * 
	 */
	public static void sendEmail(final String toEmail) {

		Properties props = new Properties();
		InputStream input = null;

		input = SendMailSslUtils.class.getClassLoader().getResourceAsStream("config.properties");

		// load a properties file
		try {
			props.load(input);
		} catch (IOException e1) {
			logger.error("Erreur lecture fichier properties");
			e1.printStackTrace();
		}
		final String username = props.getProperty("mail.smtp.username");
		final String password = props.getProperty("mail.smtp.password");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");

			Transport.send(message);

			logger.info("Done");

		} catch (MessagingException e) {
			logger.error("Erreur envoi de mail");
			e.printStackTrace();
		}
	}
}
