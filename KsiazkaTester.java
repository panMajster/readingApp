import java.util.ArrayList;

;

public class KsiazkaTester {
	public static void main (String[] args) {
		
		KsiazkaPytania jeden = new KsiazkaPytania();
				
		jeden.setTytul("Wiedzmin");
		jeden.dodajPytane("Co tam Panie Arnoldzie");
		jeden.dodajPytane("Co tam Michalinka");
		jeden.dodajPytane("Bejbe bejb");
		
		
		jeden.dodajKolekcja(jeden.getTytul(), jeden.zwroclistePytan());
		
		System.out.println (jeden.zwrockolekcje());
		
		
	}
}
