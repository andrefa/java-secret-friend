package secretfriend.view;

import java.util.List;

import secretfriend.model.Person;

/**
 * 
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
public class PersonTableModel extends TableModelAdapter<Person> {

	/**
	 * @param people
	 */
	public PersonTableModel(List<Person> people) {
		super(people);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return values.get(rowIndex).getName();
			case 1:
				return values.get(rowIndex).getEmail();
			case 2:
				return values.get(rowIndex).getSuggestions().size();
			default:
				return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				values.get(rowIndex).setName(String.valueOf(aValue));
				break;
			case 1:
				values.get(rowIndex).setEmail(String.valueOf(aValue));
				break;
		}
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "Nome", "Email", "Sugestões" };
	}

	@Override
	protected Class<?>[] getColumnClasses() {
		return new Class[] { String.class, String.class, Integer.class };
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0 || columnIndex == 1;
	}

}