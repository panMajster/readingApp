import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	JTextField tytulKsiazki;
	JTextField pytanie;
	
	JTextArea pytaniaArea;
	
	JLabel displayTytul;
	JLabel displayPytania;
	
	JLabel status;
	
	ArrayList<KsiazkaPytania> ksiazki;
	
	ArrayList<String> pytania;
	String tytul;
	

	
	public Edytor() {
		
		ksiazki = new ArrayList<KsiazkaPytania>();
		
		
		pytania = new ArrayList<String>();
		tytul = new String();
		
		zapiszKsiazke = new JButton ("Zapisz książkę");
		zapiszKsiazke.setBounds(169, 227, 156, 25);
		zapiszKsiazke.addActionListener(new ZapiszKsiazkeListener());
		
		
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
		wyczysc.setBounds(44, 227, 94, 25);
		wyczysc.addActionListener(new WyczyscListener());
		
		
		add(dodajPytanie);
		add(pytanie);
		
		add(displayTytul);
		add(displayPytania);
		
		add(status);
		
		add(pytaniaArea);
		
		add(wyczysc);
		add(zapiszKsiazke);
		
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
			pytania.add(pytanie.getText());
			System.out.println(pytania);
			pytanie.setText("");
			
			String gotowePytania = "";
			
			for (int i = 0 ; i < pytania.size() ; i ++) {
				gotowePytania += i+". "+ pytania.get(i) + "\n ";
			}
			pytaniaArea.setText("Lista pytań: \n");
			pytaniaArea.setText(gotowePytania);
			
		}
	}
	
	
	class WyczyscListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			pytania.removeAll(pytania);
			ksiazki.removeAll(ksiazki);
			tytulKsiazki.setEditable(true);
			pytaniaArea.setText("Wyczyszczono");
		}
	}
	
	class ZapiszKsiazkeListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			KsiazkaPytania ksiazka = new KsiazkaPytania(tytul, pytania);
			
			ksiazki.add(ksiazka);
			
			
			JFileChooser plikDanych = new JFileChooser();
			plikDanych.showSaveDialog(GUI.ramka);
			zapiszPlik(plikDanych.getSelectedFile());
			
			
		}
	}
	
	private void zapiszPlik (File plik) {
		try {
			BufferedWriter pisarz = new BufferedWriter(new FileWriter(plik));
			
			for (KsiazkaPytania ksiazka : ksiazki) {
				pisarz.write(ksiazka.getTytul() + "/\n");
				pisarz.write(ksiazka.getPytania() + "\n");
				
			}
			pisarz.close();
			
		}catch (IOException ex) {
			System.out.println ("Błąd w zapisie");
			ex.printStackTrace();
			
			
		}
	}
}
