package secretfriend.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import secretfriend.model.Email;
import secretfriend.model.Person;

/**
 * @author andre.almeida
 *
 */
public class Raffle {

	/** Instância única */
	private static Raffle instance;
	
	/**
	 * @return
	 */
	public static Raffle instance() {
		if (instance == null) {
			instance = new Raffle();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	private Raffle() {
	}
	
	/**
	 * @param people
	 * @return
	 */
	public List<Email> getFriendCycle(List<Person> people) {
		List<Email> emails = new ArrayList<Email>();
		
		shuffleList(people, 100 * 1000);

		for (int i=0;i<people.size()-1;i++) {
			emails.add(new Email(people.get(i), people.get(i+1)));
		}
		
		emails.add(new Email(people.get(people.size()-1), people.get(0)));
		
		return emails;
	}

	/**
	 * @param people
	 * @param times
	 */
	private void shuffleList(List<Person> people, int times) {
		for (int i=0 ; i < times ; i++) {
			Collections.shuffle(people);
		}
	}
	
}