package secretfriend.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import secretfriend.control.PersonDao;

import net.miginfocom.swing.MigLayout;


/**
 *
 * @author andre.almeida
 */
public class MainWindow extends JFrame {

	private static final int WIDTH = 540;
	private static final int HEIGHT = 480;
	
	private static final String TITLE = "Organizador de Amigos secretos!";
	
	private JPanel contentPane;

	private PersonDao dao;

	/**
	 * 
	 */
	public MainWindow() {
		config();
		initComponents();
	}

	/**
	 * 
	 */
	private void config() {
		setTitle(TITLE);
		setSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new MigLayout("debug"));
		setResizable(false);
		setLocationRelativeTo(null);
		dao = new PersonDao();
	}

	/**
	 * 
	 */
	private void initComponents() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuOptions = new JMenu("Opções");
		
		JMenuItem itemPersonForm = new JMenuItem("Pessoas");
		itemPersonForm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewView(new PersonForm(dao));
			}
		});
		menuOptions.add(itemPersonForm);
		
		JMenuItem itemSuggesForm = new JMenuItem("Sugestões");
		itemSuggesForm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewView(new SuggestionForm(dao));
			}
		});
		menuOptions.add(itemSuggesForm);
		
		menuBar.add(menuOptions);
	}
	
	/**
	 * @param view
	 */
	public void setNewView(AbstractView view){
		contentPane.setLayout(new MigLayout("debug","[grow]","[grow]"));
        contentPane.removeAll();
        contentPane.add(view,"growx");
        contentPane.revalidate();
        contentPane.repaint();
    }
	
}