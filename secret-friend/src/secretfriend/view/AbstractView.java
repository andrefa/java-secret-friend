package secretfriend.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import secretfriend.control.PersonDao;

import net.miginfocom.swing.MigLayout;


/**
 *
 * @author andre.almeida
 */
public abstract class AbstractView extends JPanel {

	private final PersonDao dao;
	
	private JButton btCancel;
	private JButton btSave;

	/**
	 * 
	 */
	public AbstractView(PersonDao dao) {
		this.dao = dao;
		configure();
		initComponents();
	}

	/**
	 * 
	 */
	protected void configure() {
		setLayout(new MigLayout("debug", "[30px, right]4px[grow]", ""));
		btCancel = new JButton("Cancelar");
		btSave = new JButton("Salvar");
	}

	/**
	 * 
	 */
	protected abstract void initComponents();
	
	/**
	 * @return
	 */
	public PersonDao dao() {
		return dao;
	}
	
	
	
}