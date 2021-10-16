package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {

		antall = 0;
		samling = new Kort[MAKS_KORT];
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		return antall;
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		return antall > 0 ? false : true;
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		samling[antall++] = kort;
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		for (Kortfarge farge : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++){
				this.samling[antall++] = new Kort(farge, i);
			}
		}
		
		KortUtils.stokk(this);
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		samling = new Kort[MAKS_KORT];
		antall = 0;
		
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		if (antall > 0) {
			Kort sisteKort = new Kort(samling[antall-1].getFarge(), samling[antall-1].getVerdi());

			return sisteKort;
		} else {
			return null;
		}		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		if(antall > 0) {
			Kort kopiAvSiste = new Kort(samling[antall-1].getFarge(), samling[antall-1].getVerdi());
			samling[--antall] = null;
			return kopiAvSiste;
		}else {
			return null;
		}
	}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		int i = 0;

		while(i<antall) {
			if(kort != null && samling[i].lik(kort)) {
					return true;
			}
			i++;
		}
		return false;
		
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {

		if (kort == null){
			return false;
		}

		for (int i = 0; i < antall; i++) {
			if (samling[i].lik(kort)) {
				for (int j = i; j < antall-1; j++) {
					samling[j] = samling[j+1];
				}

				samling[antall] = null;
				antall--;
				return true;
			}
		}

		return false;
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		Kort[] nySamling = new Kort[antall];

		for(int i = 0; i < antall; i++) {
			nySamling[i] = samling[i];
		}

		return nySamling;
	}	
}
