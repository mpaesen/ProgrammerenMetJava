package IntelligenteCamera;
import java.util.LinkedList;
import java.util.Random;

public class Randomizer {
    // properties en methods om via een random object ‘test’ data te genereren.
    // instance variables -
    private static final Random random = new Random();
    private static final int MAX_CAMERAS = 150;
    private static final int MAX_PATROUILLES = 15;
    private static final int MAX_VOERTUIGEN = 500;

    private static LinkedList<Locatie> locaties = getLocaties();

    public static NummerPlaat getNummerPlaat() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer nummerPlaat = new StringBuffer();
        nummerPlaat.append("1-");
        for (int i = 0; i < 3; i++) {
            nummerPlaat.append(letters.charAt(random.nextInt(26)));
        }
        nummerPlaat.append("-");
        for (int i = 0; i < 3; i++) {
            nummerPlaat.append(random.nextInt(10));
        }
        return new NummerPlaat(nummerPlaat.toString());
    }

    public static String getMerk() {
        String[] merken = {"Ford", "VW", "Hyundai", "Opel", "Chevrolet",
                "Citroën", "Renault", "Seat", "Skoda", "Toyota", "Lada",
                "Mitsubishi", "Nissan", "Dacia", "Jaguar", "Mercedes", "BMW",
                "Porche", "Range Rover"};
        return merken[random.nextInt(merken.length)];
    }

    public static Locatie getLocatie() {
        String[] straten = { "Tiensestraat", "Brusselsestraat", "Naamsestraat",
                "Diestestraat", "Tiensevest", "Brusselsevest", "Naamsevest",
                "Diestevest", "Brouwersstraat", "Vesaliusstraat",
                "Dekenstraat", "Capucijnenvoer", "Schapenstraat",
                "Herenstraat", "Vanwayenberglaan", "Pieter de somer plein" };
        StringBuffer locatie = new StringBuffer();
        locatie.append(straten[random.nextInt(straten.length)]);
        locatie.append(" ");
        locatie.append(1 + random.nextInt(10));
        return new Locatie(locatie.toString());
    }

    public static LinkedList<Camera> getCameras() {
        LinkedList<Camera> cameras = new LinkedList<Camera>();
        for (int i = 0; i < 20 + random.nextInt(MAX_CAMERAS); i++) {
            cameras.add((Camera) ActorFactory.createActor(ActorFactory.CAMERA, getALocatie()));
        }
        return cameras;
    }

    public static LinkedList<IVoertuig> getVoertuigen() {
        LinkedList<IVoertuig> voertuigen = new LinkedList<IVoertuig>();
        for (int i = 0; i < 150 + random.nextInt(MAX_VOERTUIGEN); i++) {
            voertuigen.add((Voertuig) ActorFactory.createActor(	ActorFactory.VOERTUIG, getALocatie()));
        }
        return voertuigen;
    }

    public static LinkedList<Patrouille> getPatrouilles() {
        LinkedList<Patrouille> patrouilles = new LinkedList<Patrouille>();
        for (int i = 0; i < 5 + random.nextInt(MAX_PATROUILLES); i++) {
            patrouilles.add((Patrouille) ActorFactory.createActor(ActorFactory.PATROUILLE, Randomizer.getLocatie()));
        }
        return patrouilles;
    }

    private static LinkedList<Locatie> getLocaties() {
        if (locaties == null) {
            locaties = new LinkedList<Locatie>();
            for (int i = 0; i < MAX_CAMERAS; i++) {
                locaties.add(getLocatie());
            }
        }
        return locaties;
    }

    public static Locatie getALocatie(){
        return getLocaties().get(random.nextInt(locaties.size()));
    }

    public static IVoertuig seinGestolenVoertuig(LinkedList<IVoertuig> voertuigen){
        int index = random.nextInt(voertuigen.size());
        IVoertuig voertuig = new Gestolen(voertuigen.get(index));
        voertuig.setGeseind(true);
        voertuigen.set(index, voertuig);
        return voertuigen.get(index);
    }

    public static IVoertuig seinNietVerzekerdVoertuig(LinkedList<IVoertuig> voertuigen){
        int index = random.nextInt(voertuigen.size());
        IVoertuig voertuig = new NietVerzekerd(voertuigen.get(index));
        voertuig.setGeseind(true);
        voertuigen.set(index, voertuig);
        return voertuigen.get(index);
    }
}
