package secretfriend.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import secretfriend.control.PersonDao;

/**
 *
 * @author andre.almeida
 */
public class PersonForm extends AbstractView {
	
	private JScrollPane spPeople;
	private JTable tbPeople;
	
	private JLabel lbName;
	private JTextField tfName;

	private JLabel lbEmail;
	private JTextField tfEmail;
	
	private JButton btCancel;
	private JButton btSave;
	
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
		tbPeople = new JTable(new PersonTableModel(dao().list()));
		
		spPeople.setViewportView(tbPeople);
		add(spPeople, "span 2, wrap");
		
		lbName = new JLabel("Nome:");
		add(lbName);
		tfName = new JTextField();
		add(tfName, "wrap");
		
		lbEmail = new JLabel("Email:");
		add(lbEmail);
		tfEmail = new JTextField();
		add(tfEmail, "wrap");
		
		add(btCancel);
		add(btSave);
	}

	@Override
	protected void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void save() {
		// TODO Auto-generated method stub
		
	}

}