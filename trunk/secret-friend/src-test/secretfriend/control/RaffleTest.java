package secretfriend.control;

import java.util.List;

import org.junit.Test;

import secretfriend.AbstractTest;
import secretfriend.model.Email;

/**
 * @author andre.almeida
 *
 */
public class RaffleTest extends AbstractTest {

	/**
	 * 
	 */
	@Test
	public void testCen0001() {
		int times = 1000;
		while(times-- > 0) { 
			System.out.println("=========================================");
			List<Email> friendCycle = Raffle.instance().getFriendCycle(new PersonDao().list());
			for (Email mail : friendCycle) {
				System.out.println(mail.getTo() + ":" + mail.getFriend());
			}
			System.out.println();
		}
	}
	
}