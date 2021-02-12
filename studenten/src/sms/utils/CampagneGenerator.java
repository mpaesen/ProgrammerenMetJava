package sms.utils;

import model.Patient;
import model.Vaccin;
import model.exceptions.DoesNotExistsException;
import persistency.VaccinGenerator;
import persistency.VaccinLogger;
import sms.model.Campagne;
import sms.model.Person;
import utils.Globals;
import utils.RandomDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Aanmaken van een willekeurige campagne waar personen zich voor kunnen registreren.
 * De campagne is het subject en de personen die zich registeren zijn de observers.
 *
 */
public class CampagneGenerator {
    private static Campagne campagne;
    private static ArrayList<Campagne> campagnes;

    //region vaste lijsten
    private static String[] straten = {
            "Albertstraat","Amerikalei","Amsterdamstraat","Ankerrui","Anneessensstraat","Anselmostraat","Antoon Van Dyckstraat","Antwerpsebaan","Antwerpsesteenweg","Pacificatiestraat","Paleisstraat","Palingbrug",
            "Paradeplein","Pastoor Coplaan","Paul Housmansstraat","Pelgrimsstraat","Belegstraat","Belgi","Belgielei","Beliweg","Berchemlei","Berendrechtstraat","Bergstraat","Beschavingstraat","Beukenlaan","Biartstraat",
            "Biekorfstraat","Binnenpad","Bisschoppenhoflaan","Blancefloerlaan","Blauwbroekstraat","Blauwe Weg","Blauwhoefstraat","Blauwmoezelstraat","Bogaardestraat","Reigerstraat","Reyndersstraat","Ridder Walter Havrelaan",
            "Riemstraat","Rigastraat","Rijfstraat","Rijnkaai","Ringlaan","Robert Molsstraat","Roderveldlaan","Rolwagenstraat","Rostockweg","Scheldelaan","Scheldestraat","Schenkeldijk","Schermersstraat","Schiedamseweg",
            "Schijfstraat","Schijfwerpersstraat","Schijnpoortweg","Schildersstraat","Schipperstraat","Schoenmarkt","Schomhoeveweg","Schorpioenstraat","Schouwkensstraat","Charlottalei","Clementinastraat","Cobdenstraat",
            "Cockerillkaai","Coebergerstraat","Columbiastraat","Congresstraat","Consciencestraat","Constitutiestraat","Conterscherp","Coppenolstraat","Corneel Smitslei","Cuperusstraat","Cuylitsstraat","Cyriel Buyssestraat",
            "Steenhouwersvest","Steenovenstraat","Stefaniestraat","Stierstraat","Stijfselrui","Stoopstraat","Straatsburgdok-noordkaai","Stroomstraat","Sudermanstraat","Suikerrui","Suikervoetpad","Edward Pecherstraat",
            "Eendrachtstraat","Eglantierlaan","Eiermarkt","Ellermansstraat","Elzasweg","Emdenweg","Emelinusstraat","Emiel Banningstraat","Engelselei","Entrepotkaai","Van Arteveldestraat","Van Beethovenstraat","Van Breestraat",
            "Van Cuyckstraat","Van Den Nestlei","Van Der Sweepstraat","Van Dornestraat","Van Eycklei","Van Geertstraat","Van Gistelstraat","Van Heurckstraat","Van Kerckhovenstraat","Van Leriusstraat","Van Maerlantstraat",
            "Van Meterenkaai","Van Noortstraat","Van Putlei","Van Rijswijcklaan","Van Schoonbekeplein","Van Schoonbekestraat","Van Schoonhovenstraat","Van Wesenbekestraat","Vanpeltstraat","Hanegraefstraat","Hangar",
            "Haofastraat","Hardenvoort","Haringrodestraat","Harmoniestraat","Haven","Haven Noorderlaan","Haverstraat","Hendrik Conscienceplein","Henri Van Heurckstraat","Herentalsebaan","Hessenbrug","Hessenplein",
            "Essenstraatje","Hockeystraat","Hoekstraat","Hof Ter Bekestraat","Hof Van Tichelen"
    };

    private static String[] gemeenten = {
            "Aarschot","Amougies","Anthée","Anvaing","Arc-Ainières","Argenteau","Arlon","Bande","Beaufays","Beauwelz","Beert","Bellevaux-Ligneuville","Berbroek","Berlaar","Beuzet","Biercée","Biez","Bodegnée",
            "Bomal","Bornem","Bottelare","Bouillon","Bovesse","Braibant","Braine-Le-Château","Brasménil","Brecht","Bredene","Brûly-De-Pesche","Bruyelle","Chairière","Champion","Ciply","Clermont","Corporate Village",
            "Corroy-Le-Château","Croix-Lez-Rouveroy","Dhuy","Diksmuide","Dormaal","Dworp","Ellemelle","Ellignies-Sainte-Anne","Embourg","Engelmanshoven","Ensival","Ere","Ethe","Felenne","Floriffoux","Forville",
            "Foy-Notre-Dame","Genly","Glons","Goeferdinge","Grandmetz","Grandvoir","Haasrode","Haltinne","Hasselt","Heikruis","Hendrieken","Herdersem","Hertain","Hondelange","Ingelmunster",
            "International press center","Izel","Koekelare","Kuringen","Langemark","Lathuy","Lede","Lembeek","Leut","Lombise","Loppem","Maaseik","Melen","Mespelare","Meulebeke","Moeskroen","Mohiville",
            "Monceau-Sur-Sambre","Mont-Saint-Aubert","Montzen","Moorslede","Natoye","Nederhasselt","Neerglabbeek","Neufvilles","Nokere","Nouvelles","Noville","Onkerzele","Oostduinkerke","Oostkerke",
            "Ophoven","Oplinter","Orroir","Oudenaarde","Oupeye","Parlement de la communauté française","Pousset","Presles","Racour","Remicourt","Rocourt","Romedenne","Rossignol","Schriek","Sint-Eloois-Winkel",
            "Sint-Genesius-Rode","Sint-Huibrechts-Hern","Sint-Kornelis-Horebeke","Sint-Margriete","Sint-Maria-Lierde","Sint-Michiels","Strijpen","Strombeek-Bever","Tilleur","Tournai","Trois-Ponts","Upigny","Vaulx",
            "Veerle","Virelles","Vogenée","Vorst","Waarloos","Waha","Walhain-Saint-Paul","Wansin","Watervliet","Wellin","Wezembeek-Oppem","Wihogne","Wingene","Woesten","Wulpen","Zepperen","Zingem","Zwevezele"
    };

    private static String[] postcodes = {
            "3200","7750","5520","7910","7910","4601","6700","6951","4052","6594","1673","4960","3540","2590","5030","6533","1390","4537","1367","2880","9820","6830","5081","5590","1440","7604","2960",
            "8450","5660","7641","5550","5020","7024","4890","1935","5032","7120","5310","8600","3440","1653","4590","7972","4053","3800","4800","7500","6760","5570","5150","5380","5504","7040","4690",
            "9500","7900","6840","3053","5340","3500","1670","3840","9310","7522","6780","8770","1041","6810","8680","3511","8920","1370","9340","1502","3630","7870","8210","3680","4633","9200","8760",
            "7700","5361","6031","7542","4850","8890","5360","9400","3670","7063","9771","7022","4347","9500","8670","8340","3640","3300","7750","9700","4680","1012","4350","6250","4287","4350","4000",
            "5600","6730","2223","8880","1640","3730","9667","9981","9570","8200","9620","1853","4420","7500","4980","5310","7536","2431","6461","5650","1190","2550","6900","1457","4280","9988","6920",
            "1970","4452","8750","8640","8670","3800","9750","8750"
    };

    private static String[] locatieNamen = {
            "Altena Castle (Kasteel van Altena)","Arendsnest Castle (Kasteel Arendsnest)","Battenbroek Castle (Kasteel Battenbroek)","De Hof ter Beke","Befferhof Castle (Kasteel Befferhof)",
            "Berentrode Castle (Kasteel Berentrode)","De Berlaarhof","De Beukenhof Castle","De Bist Castle (Ekeren) (Kasteel de Bist)","De Bist Castle (Kessel) (Kasteel de Bist)","De Bocht Castel",
            "Boeckenberg Castle (Kasteel Boeckenberg)","Hof ter Borght","Borrekens Castle (Kasteel Borrekens)","Hof ten Bos","Bossenstein Castle (Kasteel Bossenstein)","Bouwel Castle (Kasteel van Bouwel)",
            "Kasteel van de hertogen van Brabant","Bouckenborgh Castle (Kasteel Bouckenborgh)","De Cijnshof van Boutersem","De Hof van Bouwel","Brasschaat Castle (Kasteel van Brasschaat)",
            "Broydenborg Castle (Kasteel Broydenborg)","Buerstede Castle (Kasteel de Buerstede)","Hof van Busleyden","Cantecroy Castle (Kasteel Cantecroy)","Cappenberg Castle (Kasteel Cappenberg)",
            "Cleydael Castle (Waterslot Cleydael)","Couwelaer Castle (Kasteel de Couwelaer)","Doggenhout Castle (Kasteel Doggenhout)","Baron Dufour Castle (Kasteel Baron Dufour)",
            "Dulft Castle (Kasteelmotte De Dulft)","Hof ter Elst","Ter Elst Castle (Kasteel ter Elst)","Ertbrugge Castle (Kasteel Ertbrugge)","or Hof van Franck","Fruithof Castle (Kasteel Fruithof)",
            "Hof van Savoye","De Gestelhof","Ginhoven Castle (Kasteel Ginhoven)","Gravenhof Castle (Kasteel Gravenhof)","Het Gravenkasteel","'s Gravenwezel Castle (Kasteel 's Gravenwezel)",
            "Groenendaal Castle (Kasteel Groenendaal)","De Groeningenhof","De Hallehof","Hemelhof Castle (Kasteel Hemelhof)","Hof van Hemiksem","Herlaar Castle (Kasteel Herlaar)","De Heuvelhof",
            "Hof-en-Berg Castle (Kasteel Hof-en-Berg)","Hof ter Vijvers Castle (Kasteel Hof ter Vijvers)","Hollaken Castle (Kasteel van Hollaken)","Hoogstraten Castle (Kasteel van Hoogstraten)",
            "Hovorst Castle (Kasteel Hovorst)","Hulgenrode Castle (Kasteel Hulgenrode)","Hof d'Intere","Irishof Castle (Kasteel Irishof)","Hof van Kalesberg","Kijkuit Castle (Kasteel Kijkuit)",
            "Klaverblad Castle (Kasteel Klaverblad)","Koolhem Castle (Kasteel Koolhem)","Hof ter Laken","Hof van Lasson","Hof van Liere","Hof ter Linden","Castle De Lindenhof","Hof van Massenhoven",
            "Meerlaar Castle (Kasteel Meerlaar)","Meerlenhof Castle (Kasteel Meerlenhof)","Hof te Melis","Mikhof Castle (Kasteel Mikhof)","Nieuw Laarhof Castle (Kasteel Nieuw Laarhof)",
            "Bornem Castle","(Kasteel de Marnix de Sainte-Aldegonde)","Maxburg Castle (Kasteel Maxburg)","De Meeus d'Argenteuil Castle","(Kasteel de Meeus d'Argenteuil)","Het Merodekasteel",
            "Kasteel van gravin Jeanne de Merode","or Nieuw Kasteel","De Monnikkenhof","Mussenborg Castle (Kasteel Mussenborg)","Nielerbroek Castle (Kasteel Nielerbroek)","De Pelgrimhof",
            "Planckendael Castle","(Kasteel Domein Planckendael)","Pulhof Castle (Kasteel Pulhof)","Gemeentehuis Putte","Rameyen Castle","Rattennest Castle (Kasteel Rattennest)","De Ravenhof",
            "Hof van Reet","Renesse Castle (Kasteel van Renesse)","Rethy Castle (Kasteel van Rethy)","De Hof van Riemen","Hof van Ringen","Hof van Roosendaal","Ruisbroek Castle (Kasteel van Ruisbroek)",
            "Runcvoort Castle (Kasteel Runcvoort)","Kasteel van Schilde","De Schoonselhof","Schoten Castle (Kasteel van Schoten)","Schravenhage Castle (Kasteel Schravenhage)",
            "Selsaette Castle (Kasteel Selsaete)","De Solhof","Sorghvliedt Castle (Kasteel Sorghvliedt)","De Spokenhof","Het Steen","De Sterckshof","Steytelinck Castle (Kasteel Steytelinck)",
            "Terdonck Castle (Kasteel Terdonck)","Tielen Castle","Turnhout Castle (Kasteel van Turnhout)","Hingene Castle (Hertogelijk kasteel van Ursel)","Ter Varent Castle (Kasteel ter Varent)",
            "De Hof van Veltwijck","Vorselaar Castle (Kasteel van Vorselaar)","Vorst-Meerlaer Castle (Kasteel van Vorst-Meerlaer)","Veerle Castle (Kasteel van Veerle)","Vredenborch Castle (Kasteel Vredenborch)",
            "Vredestein Castle (Kasteel Vredestein)","De Vrieselhof","Westmalle Castle (Kasteel van Westmalle)","Weyninckhove Castle (Kasteel Weyninckhove)","Zellaer Castle (Kasteel van Zellaer)",
            "Het Zoerselhof","Zwarte Arend Castle (Kasteel Zwarte Arend)","Brussels-Capital Region","Name","Belvédère Castle","Château du Belvédère / Kasteel Belvédère","Palace of Coudenberg (Koudenberg)",
            "Egmont Palace","Palais d'Egmont / Egmontpaleis","Château of Val-Duchesse","Hertoginnedal Castle","Karreveld Castle","Château de Karreveld / Kasteelhoeve van Karreveld",
            "Château Malou (Maloukasteel)","Rivieren Castle","Château de Rivieren / Kasteel ter Rivieren","Royal Palace of Brussels","Palais Royal / Koninklijk Paleis","Koninklijk Kasteel van Laken",
            "East Flanders","Name","Achtendries Castle (Kasteel Achtendries)","Acker Castle (Kasteel van Acker)","Altena Castle (Kasteel van Altena)","Kasteel van Astene","Aveschoot Castle (Kasteel van Aveschoot)",
            "Castle of the Barony of Boelare","(Kasteel Baronie van Boelare)","Baudries Castle","Beerlegem Castle (Kasteel van Beerlegem)","Beervelde Castle (Kasteel van Beervelde)","Berlare Castle",
            "Ten Bieze Castle","Blauw Huys Castle","de Blondel de Beauregard Castle","Ten Boekel Castle (Kasteel Ten Boekel)","Borgwal Castle","Borluut Castle (Kasteel Borluut)","Bosdam Castle",
            "Braem Castle","Breivelde Castle (Kasteel Domein Breivelde)","Goed ten Broeke","Claeys-Bouüaert Castle (Kasteel Claeys-Bouüaert)","Coninxdonk Castle (Kasteel Coninxdonk)",
            "Cortewalle Castle (Kasteel Cortewalle)","Crabbenburg Castle (Kasteel Crabbenburg)","De Campagne Castle","Diepenbroeck Castle (Kasteel Diepenbroeck)","Doornzele Castle (Kasteel Doornzele)",
            "Het Dreefkasteel","Gerard de Duivelsteen","Egmont Castle (Egmontkasteel)","Elslo Castle (Kasteel te Elslo)","De Emerietenhof","Gaverkracht Castle (Kasteel Gaverkracht)","de Gerlache Castle",
            "Het Gravensteen","Graventoren Castle (Burchtruïne Graventoren)","Kasteel Groeneveld","Hansbeke Castle (Kasteel van Hansbeke)","Herzele Castle (Kasteelruïne van Herzele)",
            "Heylwegen Castle (Kasteel Heylwegen)","Hof ter Kruizen","Kruishoutem Castle (Kasteel van Kruishoutem)","Laarne Castle (Kasteel van Laarne)","Landegem Castle (Kasteel van Landegem)",
            "Laresteen Castle (Kasteel Laresteen)","Leeuwergem Castle","(Kasteel van Leeuwergem)","Ter Leyen Castle (Kasteel Ter Leyen)","Kasteel Hof van Lier","Lippens Castle (Kasteel Lippens)",
            "Lozer Castle (Kasteel Lozer)","Mariahoeve Castle (Kasteel Mariahoeve)","Maaltebrugge Castle (Maaltebruggekasteel)","Mesen Castle","Moorsel Castle (Kasteel van Moorsel)","Nazareth Castle"
    };
    //endregion

    public static Campagne createRandomCampagne() {
        int locatieNaam = new Random().nextInt(locatieNamen.length);
        int straat = new Random().nextInt(straten.length);
        int postcode = new Random().nextInt(postcodes.length);

        campagne = new Campagne(locatieNamen[locatieNaam], straten[straat], postcodes[postcode], gemeenten[postcode], FutureDate.randomFutureDate());
        VaccinLogger.log().debug("Willekeurige campange aangemaakt te " + campagne);
        return campagne;
    }

    public static ArrayList<Campagne> createRandomListOfCampagnes(ArrayList<Person> persons) {

        int aantal = new Random().nextInt(10) + 5;
        campagnes = new ArrayList<>();

        VaccinLogger.log().debug("Starten met het aanmaken van een willekeurige set van campagnes. " + aantal + " in dit geval.");
        for (int i = 0; i < aantal; i++) {
            createRandomCampagne();
            campagnes.add(campagne);
            // nog willekeurige inschrijvingen verzorgen voor deze nieuwe campagne
            ObserverGenerator.createRandomObservers(campagne, persons);
        }
        VaccinLogger.log().debug("Stop, willekeurige set van campagnes werd aangemaakt.");

        return campagnes;
    }

}
