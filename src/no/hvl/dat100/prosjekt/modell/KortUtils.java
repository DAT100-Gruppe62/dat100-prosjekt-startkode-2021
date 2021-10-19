package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

public class KortUtils {

	/**
	 * Sorterer en samling. RekkefÃ¸lgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {

		Stream<Kort> kortStream = Arrays.stream(samling.getAllekort());
		samling.fjernAlle();
		kortStream.sorted().forEach(x -> samling.leggTil(x));

	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {
//		Ta ei samling og gå igjennom flytt alle objecta til tilfelige plassa 
		Kort[] tempSamling = samling.getSamling();
		Random r = new Random();
		for(int i = 0; i < samling.getAntalKort(); i++) {
			int a = r.nextInt(samling.getAntalKort());
			int b = r.nextInt(samling.getAntalKort());
			Kort kort_a = tempSamling[a];
			tempSamling[a] = tempSamling[b];
			tempSamling[b] = kort_a;
		}
	}

}
