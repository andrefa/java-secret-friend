package secretfriend.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	protected JButton btAddLine;
	protected JButton btRemoveLine;
	protected JButton btCancel;
	protected JButton btSave;

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
	private void configure() {
		setLayout(new MigLayout("debug","grow"));
		
		btAddLine = new JButton("Adicionar");
		btAddLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addLine();
			}
		});
		
		btRemoveLine = new JButton("Remover");
		btRemoveLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeLine();
			}
		});
		
		btCancel = new JButton("Cancelar");
		btCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		btSave = new JButton("Salvar");
		btSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
	}

	/**
	 * 
	 */
	protected abstract void initComponents();
	
	/**
	 * 
	 */
	protected abstract void addLine();
	
	/**
	 * 
	 */
	protected abstract void removeLine();
	
	/**
	 * 
	 */
	protected abstract void reset();
	
	/**
	 * 
	 */
	protected abstract void save();
	
	/**
	 * @return
	 */
	public PersonDao dao() {
		return dao;
	}
	
}