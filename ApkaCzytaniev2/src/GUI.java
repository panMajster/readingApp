/* 
 * TODO - Panel dla wyboru książęk
 * TODO - paneldla stopera
 * TODO - Panel dla pytań dla wybranej książki
 * 			Ma wyświetlić losowe 3 pytania
 * TODO - panel z wyświetlonymi pytaniami twardymi
 * TODO - panel z możliwością dodawania pytań miękkich


*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

	

public class GUI {
	static JFrame ramka;
	
	
	static JTabbedPane panelZakladki;
	
	static JPanel panelWybor;
	static JComboBox<?> listaKsiazek;
	
	static JPanel panelStoper;
	static JButton start;
	static JButton stop;
	static JButton reset;
	static JLabel display;
	
	static JPanel panelQuiz;
	static JLabel tytul;
	static JTextArea pytania;
	
	
	
	
	static JPanel panelPytania;
	
	static JPanel edytorPytan;
	static JTextField wpiszPytanie;
	static JButton dodajPytanie;
	
	static String wyborKsiazki;
	
	static String[] tytuly;
	
	
	
	
	
	public static void main (String[] args) {
		GUI jeden = new GUI();
		jeden.zrobPanel();
		
		
			
	}// main
	
	public void zrobPanel(){
		tytuly = new String[20];
		
		
		ramka = new JFrame();
		ramka.setSize(400,400);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setVisible(true);
		
		
		panelZakladki = new JTabbedPane();
		
		///////////// panel stoper
		
		PanelStoper stoper = new PanelStoper();
		
				
		///////////////////////// PANEL QUIZ
		PanelQuiz quiz = new PanelQuiz();
		
		
		
		///////////////////////////// PANEL WYBÓR
		PanelWybierzKsiazke panelWybor = new PanelWybierzKsiazke();
		
		
		//////////// EDYTOR PYTAŃ
		Edytor edytorPytan = new Edytor();
		
		
		
		panelZakladki.addTab("Wybierz Ksiązke", panelWybor);
		panelZakladki.addTab("Quiz", quiz);
		panelZakladki.addTab("Edytor", edytorPytan);
		panelZakladki.addTab("Stoper", stoper);
	
		
		
		ramka.getContentPane().add(panelZakladki);
		
		
	}// zrob panel
	
		
	
}//klasa
