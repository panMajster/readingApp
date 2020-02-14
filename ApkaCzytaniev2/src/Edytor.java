import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Edytor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton dodajKsiazke;
	static JButton dodajPytanie;
	static JButton wyczysc;
	static JButton zapiszKsiazke;
	
	static JButton wczytajKsiazke;
	
	JTextField tytulKsiazki;
	JTextField pytanie;
	
	JTextArea pytaniaArea;
	
	JLabel displayTytul;
	JLabel displayPytania;
	
	JLabel status;
	
	ArrayList<KsiazkaPytania> ksiazki;
	
	static ArrayList<String> pytania;
	String tytul;
	
	static KsiazkaPytania ksiazka;
	
	public Edytor() {
		
		ksiazki = new ArrayList<KsiazkaPytania>();
		
		
		pytania = new ArrayList<String>();
		tytul = new String();
		
		zapiszKsiazke = new JButton ("Zapisz książkę");
		zapiszKsiazke.setBounds(128, 227, 156, 25);
		zapiszKsiazke.addActionListener(new ZapiszKsiazkeListener());
		
		wczytajKsiazke = new JButton ("Wczytaj");
		wczytajKsiazke.setBounds(296, 227, 123, 25);
		wczytajKsiazke.addActionListener(new WczytajListener());
		
		
		
		displayTytul = new JLabel();
		displayTytul.setBounds(403, 47, 0, 0);
		displayPytania = new JLabel();
		displayPytania.setBounds(408, 47, 0, 0);
		
		pytaniaArea = new JTextArea(10,30);
		pytaniaArea.setEditable(false);
		pytaniaArea.setBounds(12, 93, 328, 122);
		
		status = new JLabel();
		status.setBounds(413, 47, 0, 0);
		
		
		tytulKsiazki = new JTextField(20);
		tytulKsiazki.setBounds(161, 8, 224, 19);
		pytanie = new JTextField(20);
		pytanie.setBounds(161, 39, 224, 19);
		dodajKsiazke = new JButton ("Ustaw tytuł");
		dodajKsiazke.setBounds(0, 5, 133, 25);
		
		dodajKsiazke.addActionListener(new dodajKsiazkeListener());
		setLayout(null);
		
		
		add(dodajKsiazke);
		add(tytulKsiazki);
		dodajPytanie = new JButton ("Dodaj pytanie");
		dodajPytanie.setBounds(0, 35, 133, 25);
		dodajPytanie.addActionListener(new dodajPytanieListener());
		
		wyczysc = new JButton ("Wyczyść");
		wyczysc.setBounds(22, 227, 94, 25);
		wyczysc.addActionListener(new WyczyscListener());
		
		
		add(dodajPytanie);
		add(pytanie);
		
		add(displayTytul);
		add(displayPytania);
		
		add(status);
		
		add(pytaniaArea);
		
		add(wyczysc);
		add(zapiszKsiazke);
		add(wczytajKsiazke);
		
		JLabel lblDodanePytania = new JLabel("Dodane pytania");
		lblDodanePytania.setBounds(10, 72, 123, 15);
		add(lblDodanePytania);
		
		
	
		
	}
	
	class dodajKsiazkeListener implements ActionListener{
		public void actionPerformed (ActionEvent zd) {
		
			tytul = tytulKsiazki.getText();
			tytulKsiazki.setText("Tytuł ustawiono na " + tytulKsiazki.getText());
			tytulKsiazki.setEditable(false);
			System.out.println(tytul);
			
		}
	}
	
	class dodajPytanieListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			
			if (tytulKsiazki.getText().isEmpty() == false) {
				if (pytanie.getText().isEmpty() == false) {
					pytania.add(pytanie.getText());	
				}
				
				else {
					System.out.println("Nie można dodać pustego pola");
				}
				
				
					
				
				System.out.println(pytania);
				pytanie.setText("");
				
				String gotowePytania = "";
				
				
				
				for (int i = 0 ; i < pytania.size() ; i ++) {
					gotowePytania += i+". "+ pytania.get(i) + "\n ";
				}
				
				
				pytaniaArea.setText("Lista pytań: \n");
				pytaniaArea.setText(gotowePytania);
			}
			
			else {
				tytulKsiazki.setText("Wprowadz tytul");
			}
		
			
		}
	}
	
	
	class WyczyscListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			pytania.removeAll(pytania);
			ksiazki.removeAll(ksiazki);
			tytulKsiazki.setEditable(true);
			tytulKsiazki.setText("");
			pytaniaArea.setText("Wyczyszczono");
		}
	}
	
	class ZapiszKsiazkeListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			ksiazka = new KsiazkaPytania(tytul, pytania);
							
			
			JFileChooser plikDanych = new JFileChooser();
			
						plikDanych.showSaveDialog(GUI.ramka);
			zapiszPlik(plikDanych.getSelectedFile());
			
			
		}
	}
	
	private void zapiszPlik (File plik) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(plik));
			os.writeObject(ksiazka);
			os.close();	
					
			
		}catch (IOException ex) {
			System.out.println ("Błąd w zapisie");
			ex.printStackTrace();
			
			
		}
	}
	
	class WczytajListener implements  ActionListener {
		public void actionPerformed (ActionEvent click) {
			
									
			JFileChooser plikDanych = new JFileChooser();
			plikDanych.showOpenDialog(GUI.ramka);
			wczytajPlik(plikDanych.getSelectedFile());
			
			tytulKsiazki.setText(ksiazka.getTytul());
			tytulKsiazki.setEditable(false);
			pytaniaArea.setText(ksiazka.getPytania());
			
			tytulKsiazki.setEditable(false);
			
			pytania = ksiazka.zwroclistePytan();
		}
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
