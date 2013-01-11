package secretfriend.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import secretfriend.control.PersonDao;

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
	 * @param dao
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
		setLayout(new MigLayout("", "grow", "grow"));

		btAddLine = new JButton("Adicionar");
		btAddLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addLine();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});

		btRemoveLine = new JButton("Remover");
		btRemoveLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					removeLine();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});

		btCancel = new JButton("Cancelar");
		btCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					reset();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});

		btSave = new JButton("Salvar");
		btSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					save();
					JOptionPane.showMessageDialog(AbstractView.this, "Alterações salvas com sucesso.", "Salvo!", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});
	}

	/**
	 * @param ex
	 */
	private void handleException(Exception ex) {
		JOptionPane.showMessageDialog(this, "O seguinte erro ocorreu durante a execução: " + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
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
	 * @return dao
	 */
	public PersonDao dao() {
		return dao;
	}

}