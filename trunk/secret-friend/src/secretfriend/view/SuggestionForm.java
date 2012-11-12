package secretfriend.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import secretfriend.control.PersonDao;
import secretfriend.model.Person;
import secretfriend.model.Suggestion;

/**
 * 
 * @author andre.almeida
 */
public class SuggestionForm extends AbstractView {
	
	private JComboBox cbPeople;
	private JScrollPane spSuggestions;
	private JTable tbSuggestions;
	private SuggestionTableModel suggestionsTableModel;
	
	private Person selected;
	
	private List<Person> people;
	
	/**
	 * @param dao
	 */
	public SuggestionForm(PersonDao dao) {
		super(dao);
	}

	/**
	 * 
	 */
	@Override
	protected void initComponents() {
		
		cbPeople = new JComboBox();
		populateCombo();
		cbPeople.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbPeople.getSelectedItem() != null) {
					selected = (Person) cbPeople.getSelectedItem();
					suggestionsTableModel.reset(selected.getSuggestions());
				}
			}
		});
		add(cbPeople, "span, wrap, align center");
		
		spSuggestions = new JScrollPane();
		suggestionsTableModel = new SuggestionTableModel(new ArrayList<Suggestion>());
		tbSuggestions = new JTable(suggestionsTableModel);
		tbSuggestions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		spSuggestions.setViewportView(tbSuggestions);
		add(spSuggestions, "span, wrap, align center, growx");

		add(btAddLine, "align right");
		add(btRemoveLine, "align center");
		add(btCancel, "align center");
		add(btSave);
	}

	private void populateCombo() {
		cbPeople.removeAllItems();
		people = dao().list();
		for (Person p : people) {
			cbPeople.addItem(p);
		}
		cbPeople.setSelectedItem(null);
	}

	@Override
	protected void addLine() {
		if (selected != null) {
			suggestionsTableModel.addLine(new Suggestion());
		} else {
			JOptionPane.showMessageDialog(this, "Seleciona uma pessoa na lista.","Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected void removeLine() {
		if (tbSuggestions.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(this, "Seleciona uma linha.","Erro!",JOptionPane.ERROR_MESSAGE);
			return;
		}
		suggestionsTableModel.removeLine(tbSuggestions.getSelectedRow());
	}

	@Override
	protected void reset() {
		selected = null;
		populateCombo();
		suggestionsTableModel.reset(new ArrayList<Suggestion>());
	}

	@Override
	protected void save() {
		if (selected != null) {
			selected.setSuggestions(suggestionsTableModel.getValues());
			dao().save(people);
			people = dao().list();
			suggestionsTableModel.fireTableDataChanged();
		} 
	}

}