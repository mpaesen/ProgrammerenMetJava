package model.factory;

import model.TypeWoning;
import model.Woning;
import model.kamers.Kamer;
import model.kamers.TypeKamer;
import model.woningen.*;

import java.util.Random;

public class WoningFactory {
    // functie die automatisch een correct object zal aanmaken afhankelijk van de waarde van x
    // x wordt random bepaald en kan hier een waarde van 0 = loft of 1 = woning hebben
    public static final Random random = new Random();
    private final static byte MAX_KAMERS_HUIS = 8;
    private final static byte MAX_KAMERS_VILLA = 12;
    private final static byte MAX_KAMERS_LOFT = 3;
    private final static byte MAX_KAMERS_APPARTEMENT = 5;
    private final static byte MAX_KAMERS_STUDIO = 2;
    private static Woning woning;

    public static Woning creatieWoning(TypeWoning x) {
        switch (x) {
            case LOFT:
                woning = new Loft((byte) random.nextInt(MAX_KAMERS_LOFT));
                ((Loft) woning).setBalkon(random.nextBoolean());
                break;
            case VILLA:
                woning = new Villa((byte) random.nextInt(MAX_KAMERS_VILLA));
                ((Villa) woning).setTuin(random.nextBoolean());
                break;
            case APPARTEMENT:
                woning = new Appartement((byte) random.nextInt(MAX_KAMERS_APPARTEMENT));
                ((Loft) woning).setBalkon(random.nextBoolean());
                break;
            case STUDIO:
                woning = new Studio((byte) random.nextInt(MAX_KAMERS_STUDIO));
                break;
            case HUIS:
                woning = new Huis((byte) random.nextInt(MAX_KAMERS_HUIS));
                ((Huis) woning).setTuin(random.nextBoolean());
                break;
            default:
                return null;
        }
        //maak random kamers per woning
        Kamer kamer;
        for (byte i = 0; i < woning.getAantalKamers(); i++) {
            kamer = KamerFactory.getKamer(TypeKamer.values()[random.nextInt(TypeKamer.values().length)]);
            woning.setKamer(i, kamer);
        }
        return woning;
    }
}


