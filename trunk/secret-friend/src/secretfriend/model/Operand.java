package secretfriend.model;

/**
 * 
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public enum Operand {

	/**
	 *
	 */
	MATCH("=") {
		@Override
		public boolean compare(String value1, String value2) {
			return value1.contains(value2);
		}
	},

	/**
	 * 
	 */
	PROIBITED("<>") {
		@Override
		public boolean compare(String value1, String value2) {
			return !value1.contains(value2);
		}
	};

	private String symbol;

	private Operand(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @param symbol
	 * @return operand
	 */
	public static Operand getOperandFromSymbol(String symbol) {
		for (Operand op : values()) {
			if (op.symbol.equals(symbol)) {
				return op;
			}
		}
		return null;
	}

	/**
	 * @param to
	 * @param from
	 * @return result
	 */
	public abstract boolean compare(String to, String from);
}