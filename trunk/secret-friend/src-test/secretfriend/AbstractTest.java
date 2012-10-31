package secretfriend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;

import secretfriend.control.PersonDao;
import secretfriend.model.Email;
import secretfriend.model.Person;
import secretfriend.model.Suggestion;

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
		PEOPLE.add(new Person("Aline", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("blusa",""),  new Suggestion("vela","") })));
		PEOPLE.add(new Person("Andre", "andre.almeida@senior.com.br", Arrays.asList(new Suggestion[] { new Suggestion("tenis",""),  new Suggestion("camisa","") })));
		//PEOPLE.add(new Person("Arli", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("meias",""),  new Suggestion("calça","www.google.com.br/calça") })));
		//PEOPLE.add(new Person("Betina", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("meias",""),  new Suggestion("calça","www.google.com.br/calça") })));
		//PEOPLE.add(new Person("Carlos", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("sapato",""),  new Suggestion("bolsa","") })));
		//PEOPLE.add(new Person("Elenir", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("isqueiro",""),  new Suggestion("caneco","") })));
		//PEOPLE.add(new Person("Janaina", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("capa","http://www.capa.com.br/"),  new Suggestion("sacola","") })));
		//PEOPLE.add(new Person("Rafael", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("capa","http://www.capa.com.br/"),  new Suggestion("sacola","") })));
		//PEOPLE.add(new Person("Sidnei", "almeida.andref@gmail.com", Arrays.asList(new Suggestion[] { new Suggestion("capa","http://www.capa.com.br/"),  new Suggestion("sacola","") })));
		
		EMAIL = new Email(PEOPLE.get(0), PEOPLE.get(1));
	}
	
}