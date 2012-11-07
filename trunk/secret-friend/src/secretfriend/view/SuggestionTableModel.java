package secretfriend.view;

import java.util.List;

import secretfriend.model.Suggestion;

public class SuggestionTableModel extends TableModelAdapter<Suggestion> {

	public SuggestionTableModel(List<Suggestion> values) {
		super(values);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"Sugest�o","Refer�ncia"};
	}

	@Override
	protected Class<?>[] getColumnClasses() {
		return new Class<?>[] {String.class, String.class};
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: return values.get(rowIndex).getReference();
			case 1:return values.get(rowIndex).getSuggestion();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: values.get(rowIndex).setSuggestion(String.valueOf(aValue)); break;
			case 1: values.get(rowIndex).setReference(String.valueOf(aValue)); break;
		}
	}

}