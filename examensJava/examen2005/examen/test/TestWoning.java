package test;

import java.util.Arrays;
import java.util.Collection;

import model.Kamer;
import model.Loft;
import model.Villa;
import model.Woning;
import model.EengezinsWoning;
import exceptions.MaximumAantalKamers;

public class TestWoning {

	/**
	 * Genereert een aantal willekeurige woningen
	 * @return Woning[]
	 */
	public static Woning[] randomWoningen() {
		Woning[] woningen = { new Villa(), new Loft(), new Loft(), new Villa(),
				new Villa(), new EengezinsWoning(), new EengezinsWoning(),
				new EengezinsWoning() };

		return woningen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Collection<Woning> woningen = Arrays.asList(randomWoningen());
		boolean correctAantalKamers = true;
		for (Woning woning : woningen) {
			do {
				try {
					if (woning instanceof Villa) {
						woning.setAantalKamers("Villa", 4 + Woning.random.nextInt(5), Villa.MAX);// minimum 4 kamers
						((Villa) woning)
								.setTuin(Woning.random.nextInt(1) == 0 ? true
										: false);
					} else if (woning instanceof Loft) {
						((Loft) woning)
								.setBalkon(Woning.random.nextInt(1) == 0 ? true
										: false);
						woning.setAantalKamers("Loft", 1, Loft.MAX);// maximum 1
																	// kamer
					} else {
						woning.setAantalKamers(1 + Woning.random.nextInt(4));// minimum 1 kamer
					}
				} catch (MaximumAantalKamers exc) {
					correctAantalKamers = false;
					//System.out.printf("Foutief aanatal kamers voor een woning van het type"+woning.getClass().getName());
				}
			} while (!correctAantalKamers);
			woning.setKamers(new Kamer[woning.getAantalKamers()]);
		}

		int huur = 0;
		System.out.println("De volgende woningen werden verhuurd:\n");
		for (Woning woning : woningen) {
			huur += woning.berekenKostPrijs();
			System.out.println("\t" + woning + " Alle kamers samen zijn "
					+ woning.voorstellingWoning() + "m².");
			System.out.println(woning.kamers());
		}

		System.out
				.println("\nDe totale verdiende huur voor alle beschikbare woningen is: "
						+ huur);
	}

}
