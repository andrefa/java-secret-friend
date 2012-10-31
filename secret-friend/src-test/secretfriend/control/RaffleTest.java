package secretfriend.control;

import org.junit.Test;

import secretfriend.AbstractTest;

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
		int times = 10;
		while(times-- > 0) { 
			Raffle.instance().getFriendCycle(PEOPLE);
			System.out.println();
		}
	}
	
}