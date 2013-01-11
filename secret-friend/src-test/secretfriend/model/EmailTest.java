package secretfriend.model;

import org.junit.Test;

import secretfriend.AbstractTest;

/**
 * 
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class EmailTest extends AbstractTest {

	/**
	 * 
	 */
	@Test
	public void testCen001() {
		Email email = new Email(PEOPLE.get(0), PEOPLE.get(1));
		System.out.println(email.getSubject());
		System.out.println(email.getFormattedEmail());
	}

}