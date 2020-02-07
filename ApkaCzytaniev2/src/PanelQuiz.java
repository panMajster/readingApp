import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PanelQuiz extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel tytul;
	static JTextArea pytania;
	
	
	public PanelQuiz() {
		tytul = new JLabel ("Tytul");
		pytania = new JTextArea();
		
		add(tytul);
		add(pytania);
		
		
	}
}
