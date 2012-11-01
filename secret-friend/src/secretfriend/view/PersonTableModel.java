package secretfriend.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import secretfriend.model.Person;

public class PersonTableModel extends AbstractTableModel {

	private List<Person> people;

	/**
	 * @param people
	 */
	public PersonTableModel(List<Person> people) {
		this.people = people;
	}

	@Override
	public int getRowCount() {
		return people.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
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
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Nome";
			case 1:return "Email";
			case 2:return "Sugestões";
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return String.class;
			case 1:return String.class;
			case 2:return Integer.class;
			default: return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0 || columnIndex == 1;
	}
	
	public void addLine() {
		people.add(new Person());
		fireTableDataChanged();
	}

	public void removeLine(int selectedRow) {
		people.remove(selectedRow);
		fireTableDataChanged();
	}
	
	public void reset(List<Person> people) {
		this.people = people;
		fireTableDataChanged();
	}
	
	public List<Person> getPeople() {
		return people;
	}
	
}