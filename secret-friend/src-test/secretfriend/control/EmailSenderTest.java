package secretfriend.control;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import secretfriend.AbstractTest;
import secretfriend.model.Email;

/**
 * @author andre.almeida
 *
 */
public class EmailSenderTest extends AbstractTest {
	
	/**
	 * 
	 */
	@Test
	public void testCen001() {
		try {
			EmailSender.instance().sendEmailWithImage(EMAIL);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * 
	 */
	@Ignore
	@Test
	public void testCen002() {
		try {
			EmailSender.instance().sendEmails(Raffle.instance().getFriendCycle(PEOPLE));
			List<Email> friendCycle = Raffle.instance().getFriendCycle(PEOPLE);
			
			for (Email email : friendCycle) {
				System.out.println("=======================================================");
				System.out.println(email.getSubject());
				System.out.println(email.getFormattedEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}