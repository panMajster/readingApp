import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KsiazkaPytania implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tytul;
	ArrayList<String> pytania;
	
	static Map<String, ArrayList<String>> mapa;
	
		
	public KsiazkaPytania() {
		pytania = new ArrayList<String>();
		
		mapa = new HashMap<String, ArrayList<String>> ();
	}
	
	public KsiazkaPytania(String t, ArrayList<String> p) {
		tytul = t;
		pytania = p;
	}
	
	public void setTytul (String t) {
		tytul = t;
	}
	
	public void dodajPytane (String p) {
		pytania.add(p);
	}
	
	public void usunPytanie (int i) {
		pytania.remove(i);
	}
	
	public String getTytul() {
		return tytul;
		
	}
	
	public ArrayList<String> zwroclistePytan() {
		return pytania;
	}
	
	public String getPytania() {
		String listaPytan = "";
		
		for (int i = 0 ; i < pytania.size() ; i ++) {
			listaPytan += i+". "+ pytania.get(i) + "\n ";
		}
		return listaPytan;
	}
	
	public void dodajKolekcja (String t, ArrayList<String> p) {
		mapa.put(t,p);
	}
	
	public Map<String, ArrayList<String>> zwrockolekcje(){
		return mapa;
	}
}
