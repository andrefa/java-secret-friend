package secretfriend.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author andre.almeida
 *
 */
public class Email {

	private static final String EMAIL_FILE_NAME = "email.html";

	private static final String PROPERTY_TO_NAME = "<to-name>";
	private static final String PROPERTY_TO_EMAIL = "<to-email>";

	private static final String PROPERTY_FRIEND_NAME = "<from-name>";
	private static final String PROPERTY_FRIEND_EMAIL = "<from-email>";

	private static final String PROPERTY_SUGGESTIONS_TABLE = "<suggs-table-lines>";

	private static final String PROPERTY_MIN_VALUE = "<min-value>";
	private static final String PROPERTY_MAX_VALUE = "<max-value>";
	private static final String PROPERTY_DATE = "<date>";
	
	private static final String SUBJECT = "Olá! <to-name>! - Sorteio do amigo secreto";
	
	private static final String TD_CSS = " style='margin-left:auto; margin-right:auto;border: 1px solid #363636;border-collapse:collapse;padding:5px;'";
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.00");
	
	private final Person friend;
	private final Person to;

	/**
	 * @param friend
	 * @param to
	 */
	public Email(Person friend, Person to) {
		this.friend = friend;
		this.to = to;
	}
	
	
	/**
	 * @return
	 */
	public String getSubject() {
		String text = Property.getSubject();
		return replaceAll(text != null ? text : SUBJECT);
	}
	
	/**
	 * @return
	 */
	public String getFormattedEmail() {
		return replaceAll(getModel());
	}
	
	/**
	 * @param text
	 * @return
	 */
	private String replaceAll(String text) {
		String replaced = text;
		
		replaced = replaced.replaceAll(PROPERTY_FRIEND_NAME,  friend.getName());
		replaced = replaced.replaceAll(PROPERTY_FRIEND_EMAIL, friend.getEmail());
		
		replaced = replaced.replaceAll(PROPERTY_TO_NAME,  to.getName());
		replaced = replaced.replaceAll(PROPERTY_TO_EMAIL, to.getEmail());

		replaced = replaced.replaceAll(PROPERTY_SUGGESTIONS_TABLE, getSuggestionsTableLines(friend.getSuggestions()));

		replaced = replaced.replaceAll(PROPERTY_MIN_VALUE, DECIMAL_FORMAT.format(Property.getMinValue()));
		replaced = replaced.replaceAll(PROPERTY_MAX_VALUE, DECIMAL_FORMAT.format(Property.getMaxValue()));
		replaced = replaced.replaceAll(PROPERTY_DATE, DATE_FORMAT.format(Property.getDate()));
		
		return replaced;
	}
	
	/**
	 * @param suggestions
	 * @return
	 */
	private String getSuggestionsTableLines(List<Suggestion> suggestions) {
		StringBuilder sb = new StringBuilder();
		
		String reference;
		for (Suggestion sugg : suggestions) {
			reference = sugg.getReference().equals("") ? "     " : sugg.getReference();
			sb.append("   <tr>										");
			sb.append("      <td"+TD_CSS+">"+sugg.getSuggestion()+"</td>		");
			sb.append("      <td"+TD_CSS+"><a href='"+reference+"'>"+reference+"</a></td>					");
			sb.append("   </tr>										");
		}
		
		return sb.toString();
	}
	
	/**
	 * @return
	 */
	private String getModel() {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(EMAIL_FILE_NAME));
			StringBuilder sb = new StringBuilder();
			
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the friend
	 */
	public Person getFriend() {
		return friend;
	}

	/**
	 * @return the to
	 */
	public Person getTo() {
		return to;
	}

}