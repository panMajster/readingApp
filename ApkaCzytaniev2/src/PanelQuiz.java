import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	
	static KsiazkaPytania ksiazka;
	
	
	public PanelQuiz() {
		tytul = new JLabel ("Tytul");
		tytul.setBounds(110, 10, 130, 15);
		pytania = new JTextArea();
		pytania.setEditable(false);
		pytania.setBounds(83, 37, 223, 202);
		setLayout(null);
		
		
		
		add(tytul);
		add(pytania);
		
	}
	
	private void wczytajPlik(File plik) {
		try {
			
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(plik));
			ksiazka = (KsiazkaPytania) is.readObject();
			is.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
