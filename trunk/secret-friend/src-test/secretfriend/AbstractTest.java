package secretfriend;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;

import secretfriend.control.PersonDao;
import secretfriend.model.Email;
import secretfriend.model.Person;

/**
 * 
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class AbstractTest {

	/** Lista de pessoas */
	public static List<Person> PEOPLE = new ArrayList<Person>();
	/** DAO de pessoas */
	public static PersonDao DAO = new PersonDao();

	/** Destinatário */
	public static final String TO_STR = "almeida.andref@gmail.com";
	/** Assunto da mensagem */
	public static final String SUBJECT = "Amigo Secreto - Teste de desenvolvedor";
	/** O corpo do email */
	public static final String MESSAGE = "<html><h1>Título 1</h1><br><br><p>Teste de quebra de linhas e outras tags!</p></html>";

	/** O corpo do email */
	public static Email EMAIL;

	/**
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
	}

}