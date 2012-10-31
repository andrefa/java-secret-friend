package secretfriend.model;

/**
 * @author andre.almeida
 *
 */
public class Suggestion {
	
	private String suggestion;
	private String reference;
	
	/**
	 * 
	 */
	public Suggestion() {
		this(null, null);
	}

	/**
	 * @param suggestion
	 * @param reference
	 */
	public Suggestion(String suggestion, String reference) {
		this.suggestion = suggestion;
		this.reference = reference;
	}

	/**
	 * @return the suggestion
	 */
	public String getSuggestion() {
		return suggestion;
	}
	
	/**
	 * @param suggestion the suggestion to set
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	@Override
	public String toString() {
		return suggestion + " - " + reference;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Suggestion) {
			if (obj == this)
				return true;
			
			Suggestion other = (Suggestion) obj;
			
			return this.suggestion.equals(other.suggestion) && this.reference.equals(other.reference); 
		}
		return false;
	}

}