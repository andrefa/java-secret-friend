package secretfriend.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import secretfriend.AbstractTest;
import secretfriend.model.Person;

/**
 * 
 * @author andre.almeida
 */
public class PersonDaoTest extends AbstractTest {

	/**
	 * 
	 */
	@Test
	public void testCen001() {
		//DAO.save(PEOPLE);
		
		List<Person> list = DAO.list();
		
		assertNotNull(list);
		assertEquals(list.size(), PEOPLE.size());
		
		for (int i =0;i < list.size();i++) {
			assertEquals(list.get(i), PEOPLE.get(i));
		}
	}

}