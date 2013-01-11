package secretfriend.control;

import java.util.List;

import org.junit.Test;

import secretfriend.AbstractTest;
import secretfriend.model.Email;

/**
 * 
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class RaffleTest extends AbstractTest {

	/**
	 * 
	 */
	@Test
	public void testCen0001() {
		lbWhile: while (true) {
			System.out.println("=========================================");
			List<Email> friendCycle = Raffle.instance().getFriendCycle(new PersonDao().list());
			for (Email mail : friendCycle) {
				System.out.println(mail.getTo() + ":" + mail.getFriend());
				if (mail.getTo().getName().contains("Maria") && mail.getFriend().getName().contains("Janaína")) {
					break lbWhile;
				}
				if (mail.getTo().getName().contains("Sidnei") && mail.getFriend().getName().contains("Janaína")) {
					break lbWhile;
				}
			}
			System.out.println();
		}
		throw new IllegalArgumentException("deu zica brother");
	}

}