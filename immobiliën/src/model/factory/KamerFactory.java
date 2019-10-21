package model.factory;

import model.kamers.Kamer;
import model.kamers.TypeKamer;

import java.util.Random;

public class KamerFactory {
    public static final Random random = new Random();
    private final static byte MAX_OPPERVLAKTE_BERGING = 6;
    private final static byte MAX_OPPERVLAKTE_SLAAP_KAMER = 12;
    private final static byte MAX_OPPERVLAKTE_BAD_KAMER = 10;
    private final static byte MAX_OPPERVLAKTE_WC = 3;
    private final static byte MAX_OPPERVLAKTE_GARAGE = 16;
    private final static byte MAX_OPPERVLAKTE_WOON_KAMER = 16;
    private final static byte MAX_OPPERVLAKTE_KEUKEN = 8;
    private static Kamer kamer;

    public static Kamer getKamer(TypeKamer kamerType) {
        kamer = new Kamer(kamerType);
        switch (kamerType) {
            case BERGING:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_BERGING));
                break;
            case SLAAP_KAMER:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_SLAAP_KAMER));
                break;
            case BAD_KAMER:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_BAD_KAMER));
                break;
            case WC:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_WC));
                break;
            case GARAGE:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_GARAGE));
                break;
            case KEUKEN:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_KEUKEN));
                break;
            case WOON_KAMER:
                kamer.setOppervlakte(1 + random.nextInt(MAX_OPPERVLAKTE_WOON_KAMER));
                break;
        }
        return kamer;
    }
}
