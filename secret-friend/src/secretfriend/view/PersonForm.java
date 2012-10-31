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
		tbPeople = new JTable();
		
		lbName = new JLabel("Nome:");
		tfName = new JTextField();
		
		lbEmail = new JLabel("Email:");
		tfEmail = new JTextField();
	}
	
	
	/**
	 * 
	 */
	private void reset() {
		
	}

}