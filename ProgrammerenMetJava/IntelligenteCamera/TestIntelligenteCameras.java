package IntelligenteCamera;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestIntelligenteCameras {
    public static LinkedList<IVoertuig> voertuigen;
    public static LinkedList<Camera> cameras;
    public static LinkedList<Patrouille> patrouilles;
    public static LinkedList<IVoertuig> gedetecteerd;
    public static LinkedList<IVoertuig> geseind;
    public static Dispatch dispatch;


    public static void main(String[] args) {
        // basic data initialisatie
        voertuigen = Randomizer.getVoertuigen();
        cameras = Randomizer.getCameras();
        patrouilles = Randomizer.getPatrouilles();
        gedetecteerd = new LinkedList<IVoertuig>();
        geseind = new LinkedList<IVoertuig>();
        dispatch = (Dispatch) ActorFactory.createActor(ActorFactory.DISPATCH,Randomizer.getLocatie());

        configureerData();
        printBasicData();
        simuleerAchtervolging();
    }

    /**
     * 	 achtervolging simuleren
     */
    private static void simuleerAchtervolging() {
        System.out.println("\n\nDe achtervolging wordt ingezet: ");
        registreerPatrouilles(patrouilles);
        detecteerVoertuigen(cameras, voertuigen);
        System.out.printf("\n\nDe volgende Voertuigen werden achtervolgd: %s",	dispatch.getGesignaleerd());
    }

    /**
     * 	configureren van basic data
     */
    private static void configureerData() {
        dispatch.setCameras(cameras);
        for (int i = 0; i < 60; i++) {
            geseind.add(Randomizer.seinGestolenVoertuig(voertuigen));
            geseind.add(Randomizer.seinNietVerzekerdVoertuig(voertuigen));
        }
        dispatch.setGeseind(geseind);
    }

    /**
     * 	Afprinten gegevens
     */
    private static void printBasicData() {
        System.out.printf("De volgende Dispatch werd gegenereerd: %s", dispatch);
        System.out.printf("\n\nDe volgende Voertuigen werden gegenereerd: %s",	voertuigen);
        System.out.printf("\n\nDe volgende Patrouilles werden gegenereerd: %s", patrouilles);
        System.out.printf("\n\nDe volgende Cameras werden gegenereerd: %s", dispatch.getCameras());
        System.out.printf("\n\nDe volgende Voertuigen werden geseind: %s", dispatch.getGeseind());
    }

    /**
     * Welke voertuigen werden door een camera opgemerkt
     * @param cameras
     * @param voertuigen
     */
    private static void detecteerVoertuigen(LinkedList<Camera> cameras,
                                            LinkedList<IVoertuig> voertuigen) {
        ListIterator<IVoertuig> listVoertuigen = voertuigen.listIterator();
        ListIterator<Camera> listCameras = cameras.listIterator();
        IVoertuig voertuig;
        Camera camera;
        while (listCameras.hasNext()) {
            camera = listCameras.next();
            while (listVoertuigen.hasNext()) {
                voertuig = listVoertuigen.next();
                if (camera.getLocatie().equals(voertuig.getLocatie())) {
                    gedetecteerd.add(voertuig);
                    dispatch.signaleer(voertuig);
                }
            }
        }
        System.out.printf("\n\nDe volgende Voertuigen werden door cameras gedetecteerd: %s", gedetecteerd);
    }

    /**
     * Enkel beschikbare patrouilles kunnen worden ingezet voor een achtervolging
     * @param patrouilles
     */
    private static void registreerPatrouilles(
            LinkedList<Patrouille> patrouilles) {

        CopyOnWriteArrayList<Patrouille> copyList = new CopyOnWriteArrayList<Patrouille>(
                patrouilles);
// CopyOnWriteArrayList wordt gebruikt ter vervanging van LinkedList
//om de onderliggende elementen te kunnen wijzigen.
        ListIterator<Patrouille> list = copyList.listIterator();
        Patrouille patrouille;
        int i = 0;
        while (list.hasNext()) {
            patrouille = list.next();
            if (i++ % 3 == 0) {
                dispatch.registerObserver(patrouille); //registreert elke 3de patrouille
            }
        }
    }
}
