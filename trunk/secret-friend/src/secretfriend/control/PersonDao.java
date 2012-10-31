package secretfriend.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import secretfriend.model.Person;
import secretfriend.model.Suggestion;

/**
 * @author andre.almeida
 * 
 */
public class PersonDao {

	private static final String EMPTY = "<empty>";

	private static final String FILE_NAME = "person.dat";
	
	private static final String ATTR_SEPARATOR = "###";
	private static final String SUGGESTIONS_ATTR_SEPARATOR = "!!!";
	private static final String SUGGESTIONS_SEPARATOR = ":::";

	/**
	 * @param people
	 */
	public void save(List<Person> people) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILE_NAME)));
			
			for (Person person : people) {
				writer.write(entityToLine(person));
				writer.newLine();
			}
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public List<Person> list() {
		List<Person> people = new ArrayList<Person>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_NAME)));
			
			String line;
			while ((line = reader.readLine()) != null) {
				people.add(lineToEntity(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return people;
	}

	/**
	 * @param line
	 * @return
	 */
	private Person lineToEntity(String line) {
		String[] values = line.split(ATTR_SEPARATOR);
		
		List<Suggestion> suggs = Collections.emptyList();
		if (values.length > 2) {
			String suggsStr = values[2];
			
			suggs = new ArrayList<Suggestion>();
			for (String suggStr : suggsStr.split(SUGGESTIONS_SEPARATOR)) {
				String[] split = suggStr.split(SUGGESTIONS_ATTR_SEPARATOR);
				
				suggs.add(new Suggestion(split[0], split[1].equals(EMPTY) ? "" : split[1]));
			}
		}
		return new Person(values[0], values[1], suggs);
	}

	/**
	 * @param entity
	 * @return
	 */
	private String entityToLine(Person entity) {

		StringBuilder suggestionsString = new StringBuilder();
		for (Suggestion s : entity.getSuggestions()) {
			String reference = s.getReference() == null || s.getReference().equals("")  ? EMPTY : s.getReference();
			suggestionsString.append(s.getSuggestion()).append(SUGGESTIONS_ATTR_SEPARATOR).append(reference).append(SUGGESTIONS_SEPARATOR);
		}

		StringBuilder entityString = new StringBuilder();
		entityString.append(entity.getName()).append(ATTR_SEPARATOR).append(entity.getEmail()).append(ATTR_SEPARATOR).append(suggestionsString);

		return entityString.toString();
	}

}