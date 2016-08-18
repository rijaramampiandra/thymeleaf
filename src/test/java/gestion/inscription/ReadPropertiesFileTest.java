package gestion.inscription;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class ReadPropertiesFileTest {
	@Test
	public void readProertiesFile() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = ReadPropertiesFileTest.class.getClassLoader().getResourceAsStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("mail.smtp.username"));
			System.out.println(prop.getProperty("mail.smtp.password"));
			System.out.println(prop.getProperty("mail.smtp.auth"));
			System.out.println(prop.getProperty("mail.smtp.starttls.enable"));
			System.out.println(prop.getProperty("mail.smtp.host"));
			System.out.println(prop.getProperty("mail.smtp.port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
