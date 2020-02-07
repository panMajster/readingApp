import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelWybierzKsiazke extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JComboBox <String> listaKsiazek;
	static String wyborKsiazki;
	static JLabel wybranaKsiazka;
	
	
	public PanelWybierzKsiazke() {
		listaKsiazek = new JComboBox <String>();
		listaKsiazek.addActionListener(new wybierzKsiazkeListener());
		
		wybranaKsiazka = new JLabel();
	}
	
	class wybierzKsiazkeListener implements ActionListener{
		public void actionPerformed (ActionEvent zd) {
			wyborKsiazki = (String) (listaKsiazek.getItemAt(listaKsiazek.getSelectedIndex()));
			System.out.println(wyborKsiazki);
			
			wybranaKsiazka.setText(wyborKsiazki);
		}
	}

}
