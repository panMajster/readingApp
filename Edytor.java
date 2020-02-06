import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Edytor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton dodajKsiazke;
	static JButton dodajPytanie;
	
	JTextField tytulKsiazki;
	JTextField pytanie;
	
	public Edytor() {
		dodajKsiazke = new JButton ("Dodaj książkę");
		dodajPytanie = new JButton ("Dodaj pytanie");
		tytulKsiazki = new JTextField(20);
		pytanie = new JTextField(20);
		
		
		add(dodajKsiazke);
		add(dodajPytanie);
		add(tytulKsiazki);
		add(pytanie);
		
		
		
	}
	
	
}
