package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		Kort[] samlingArr = samling.getAllekort();
		
		Arrays.sort(samlingArr);
		
		samling.fjernAlle();
		
		for(Kort k : samlingArr) {
			samling.leggTil(k);
		}
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		Kort[] samlingArr = samling.getAllekort();		
		
		samling.fjernAlle();
		
		Random n = new Random();
		
		int limit = samlingArr.length;
		
		int i = 0;
		while(i<limit) {
			int j= n.nextInt(limit);
			Kort k = samlingArr[j]; 
			if(!samling.har(k)) {
				samling.leggTil(samlingArr[j]);
				i++;
			}			
			
		}
	}
	
}
