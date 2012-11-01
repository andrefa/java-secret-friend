package secretfriend.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import secretfriend.control.PersonDao;

/**
 * 
 * @author andre.almeida
 */
public class PersonForm extends AbstractView {

	private JScrollPane spPeople;
	private JTable tbPeople;
	private PersonTableModel personTableModel;

	/**
	 * @param dao
	 */
	public PersonForm(PersonDao dao) {
		super(dao);
	}

	/**
	 * 
	 */
	@Override
	protected void initComponents() {
		spPeople = new JScrollPane();
		personTableModel = new PersonTableModel(dao().list());
		tbPeople = new JTable(personTableModel);
		tbPeople.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		spPeople.setViewportView(tbPeople);
		add(spPeople, "span, wrap, align center");

		add(btAddLine, "align right");
		add(btRemoveLine, "align center");
		add(btCancel, "align center");
		add(btSave);
	}

	@Override
	protected void addLine() {
		personTableModel.addLine();
	}

	@Override
	protected void removeLine() {
		personTableModel.removeLine(tbPeople.getSelectedRow());
	}

	@Override
	protected void reset() {
		personTableModel.reset(dao().list());
	}

	@Override
	protected void save() {
		dao().save(personTableModel.getPeople());
	}

}