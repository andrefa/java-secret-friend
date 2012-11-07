package secretfriend.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre.almeida
 */
public class Person {
	
	private String name;
	private String email;
	private List<Suggestion> suggestions;

	/**
	 * 
	 */
	public Person() {
		this(null, null, new ArrayList<Suggestion>());
	}
	
	/**
	 * @param name
	 * @param email
	 * @param suggestions
	 */
	public Person (String name, String email, List<Suggestion> suggestions) {
		this.name = name;
		this.email = email;
		this.suggestions = suggestions == null ? new ArrayList<Suggestion>() : suggestions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name == null ? "" : name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name == null ? "" : name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email == null ? "" : email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email == null ? "" : email;
	}
	
	/**
	 * @return the suggestions
	 */
	public List<Suggestion> getSuggestions() {
		return suggestions == null ? new ArrayList<Suggestion>() : suggestions;
	}

	/**
	 * @param suggestions the suggestions to set
	 */
	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions == null ? new ArrayList<Suggestion>() : suggestions;
	}
	
	@Override
	public String toString() {
		/*StringBuilder suggs = new StringBuilder();
		for (Suggestion sugg : suggestions) {
			suggs.append(sugg).append(",");
		}
		return name + " - " + email + " - " + suggs.toString();*/
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Person) {
			if (obj == this)
				return true;
			
			Person other = (Person) obj;
			
			return this.name.equals(other.name) && this.email.equals(other.email); 
		}
		return false;
	}

}