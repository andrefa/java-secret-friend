package secretfriend.view;

import java.util.List;

import secretfriend.model.Person;

public class PersonTableModel extends TableModelAdapter<Person> {

	private List<Person> people;

	/**
	 * @param people
	 */
	public PersonTableModel(List<Person> people) {
		super(people);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: return people.get(rowIndex).getName();
			case 1:return people.get(rowIndex).getEmail();
			case 2:return people.get(rowIndex).getSuggestions().size();
			default: return null;
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: people.get(rowIndex).setName(String.valueOf(aValue)); break;
			case 1: people.get(rowIndex).setEmail(String.valueOf(aValue)); break;
		}
	}
	
	@Override
	protected String[] getColumnNames() {
		return new String[] {"Nome", "Email", "Sugestões"};
	}
	
	@Override
	protected Class<?>[] getColumnClasses() {
		return new Class[] {String.class, String.class, Integer.class};
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0 || columnIndex == 1;
	}
	
}