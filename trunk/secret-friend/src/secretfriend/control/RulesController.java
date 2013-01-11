package secretfriend.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import secretfriend.model.Operand;
import secretfriend.model.Rule;

/**
 * 
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class RulesController {

	private static final String FILE_NAME = "rules.dat";

	/**
	 * @return rules
	 */
	public static List<Rule> listRules() {
		List<Rule> rules = new ArrayList<Rule>();
		try {
			File file = new File(FILE_NAME);
			file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				rules.add(lineToEntity(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rules;
	}

	private static Rule lineToEntity(String line) {
		Rule rule = new Rule();
		String[] values = line.split(",");
		rule.setPerson(values[0]);
		rule.setOperand(Operand.getOperandFromSymbol(values[1]));
		rule.setFriend(values[2]);
		return rule;
	}

}
