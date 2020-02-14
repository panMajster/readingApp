// TODO - otworzyć plik i wrzucić go do quizu ?

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.List;
import java.awt.Choice;

public class PanelWybierzKsiazke extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	KsiazkaPytania ksiazka;
	
	JButton wybierzPlik;
	JButton nowaKsiazka;
	JButton wybierzFolder;
	
	JTextArea sciezkaFolder;
	
	JButton quiz;
	
	List list;
	JLabel lblListaKsiek;
	JLabel wybranaKsiazka;
	
	File[] listOfFiles;
	static File wybrany;
	
	private JLabel tytulWybranej;
	
	public PanelWybierzKsiazke() {
		setLayout(null);
		
		list = new List();
		list.setBounds(48, 39, 139, 109);
		add(list);
		
		sciezkaFolder = new JTextArea("Wybierz folder");
		
		
		wybierzFolder = new JButton ("Wybierz folder");
		wybierzFolder.setSize(30, 109);
		wybierzFolder.setLocation(12, 39);
		wybierzFolder.addActionListener(new WybierzFolderListener());
		
		add(wybierzFolder);
		
		
		
		
		
		quiz = new JButton ("Zrób quiz");
		quiz.setEnabled(false);
		quiz.setBounds(8, 250, 139, 46);
		
		quiz.addActionListener(new QuizListener());
		add(quiz);
		
		
		nowaKsiazka = new JButton ("Nowa książka");
		nowaKsiazka.setBounds(206, 147, 139, 38);
		
		nowaKsiazka.addActionListener(new NowaListener());
		
		add(nowaKsiazka);
		
		wybierzPlik = new JButton("Wybierz Plik");
		wybierzPlik.addActionListener(new WybierzListener());
		
		wybierzPlik.setBounds(12, 200, 131, 38);
		
		add(wybierzPlik);
		
		lblListaKsiek = new JLabel("Lista książek");
		lblListaKsiek.setBounds(48, 12, 99, 15);
		add(lblListaKsiek);
		
		wybranaKsiazka = new JLabel("Wybrana książka to");
		wybranaKsiazka.setBounds(206, 39, 220, 15);
		add(wybranaKsiazka);
		
		tytulWybranej = new JLabel(" - ");
		tytulWybranej.setBounds(206, 67, 220, 15);
		add(tytulWybranej);
		
	}
	
	class WybierzListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			
			
			
			
			String x = list.getSelectedItem();
			int z = list.getSelectedIndex();
			wybranaKsiazka.setText("Wybrana ksiazka to: " );
			tytulWybranej.setText(x);
			PanelQuiz.tytul.setText(x);
			
			System.out.println(z);
			
			try {
				
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(listOfFiles[z].getAbsolutePath()));
				ksiazka = (KsiazkaPytania) is.readObject();
				is.close();
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			
			PanelQuiz.pytania.setText(ksiazka.getPytania());
			
			quiz.setEnabled(true);
			
	}
		
		
	
}	
	
	class NowaListener implements ActionListener{
		public void actionPerformed (ActionEvent click) {
			GUI.panelZakladki.setSelectedIndex(2);
		}
	}
	
	class QuizListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			GUI.panelZakladki.setSelectedIndex(1);
		}
	}
	
	class WybierzFolderListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			JFileChooser jfc = new JFileChooser();
			
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.showOpenDialog(GUI.ramka);
			wybrany = jfc.getSelectedFile();
			
			String sciezka = wybrany.getAbsolutePath();
			
			sciezkaFolder.setText(sciezka);
			
			
			File folder = new File (wybrany.getAbsolutePath());
			listOfFiles = folder.listFiles();
			
				
			ArrayList<String> listaPlikow = new ArrayList<String>();
			
			for (int i = 0; i < listOfFiles.length; i++) {
				  if (listOfFiles[i].isFile()) {
				    System.out.println("Plik " + listOfFiles[i].getName());
				    listaPlikow.add(listOfFiles[i].getName());
				  } else if (listOfFiles[i].isDirectory()) {
				    System.out.println("Katalog " + listOfFiles[i].getName());
				  }
				}
			
			
			for (int i = 0; i < listOfFiles.length; i ++) {
				list.add(listOfFiles[i].getName());
			}
			
		
			
		}
	}
}

