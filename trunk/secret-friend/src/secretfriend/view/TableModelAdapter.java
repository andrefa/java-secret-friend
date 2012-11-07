package secretfriend.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class TableModelAdapter<T> extends AbstractTableModel {

	protected List<T> values;

	/**
	 * @param people
	 */
	public TableModelAdapter(List<T> values) {
		this.values = values;
	}

	public void addLine(T value) {
		values.add(value);
		fireTableDataChanged();
	}

	public void removeLine(int selectedRow) {
		values.remove(selectedRow);
		fireTableDataChanged();
	}

	public void reset(List<T> values) {
		this.values = values;
		fireTableDataChanged();
	}

	public List<T> getValues() {
		return values;
	}

	@Override
	public int getRowCount() {
		return values.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return getColumnNames()[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getColumnClasses()[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return getColumnNames().length;
	}
	
	protected abstract String[] getColumnNames();
	
	protected abstract Class<?>[] getColumnClasses();

	@Override
	public abstract boolean isCellEditable(int rowIndex, int columnIndex);

	@Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);

	@Override
	public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);

}