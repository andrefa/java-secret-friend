package secretfriend.view;

import javax.swing.JDialog;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author andre.almeida
 */
public class WaitingDialog extends JDialog {

	/**
	 * 
	 */
	public WaitingDialog() {
		initComponents();
		configure();
	}

	/**
	 * 
	 */
	private void configure() {
		setLayout(new MigLayout("", "[grow, center]", "[grow, center]"));
		setSize(240, 120);
		setResizable(false);
		setLocationRelativeTo(getOwner());
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Enviando emails!");
	}

	private void initComponents() {
		add(new JLabel("Enviando emails, aguarde..."));
	}

}