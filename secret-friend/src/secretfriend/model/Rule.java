package secretfriend.model;

/**
 * @author andre.almeida
 *
 */
public class Rule {
	
	private String person;
	private String friend;
	private Operand operand;
	
	/**
	 * @return the person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(String person) {
		this.person = person;
	}

	/**
	 * @return the friend
	 */
	public String getFriend() {
		return friend;
	}

	/**
	 * @param friend the friend to set
	 */
	public void setFriend(String friend) {
		this.friend = friend;
	}

	/**
	 * @return the operand
	 */
	public Operand getOperand() {
		return operand;
	}
	
	/**
	 * @param operand the operand to set
	 */
	public void setOperand(Operand operand) {
		this.operand = operand;
	}

}