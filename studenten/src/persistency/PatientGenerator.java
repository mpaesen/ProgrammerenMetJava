package persistency;

import model.Patient;
import model.Vaccin;
import model.exceptions.DoesNotExistsException;
import utils.Globals;
import utils.RandomDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Generator of ficticious patients
 *
 * We maken gebruik van vaste lijsten om ficitieve patienten te genereren. Voor willekeurige patienten wordt eventueel
 * een historiek van vaccinaties reeds voorzien.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-20
 */
public class PatientGenerator {

    private static Patient patient;
    private static ArrayList<Patient> patients;

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

    private static String[] voornamen = {
            "Nanouk","Loïs","Nova","Liv","Mila","Féline","Romée","Elin","Charlotte","Zara","Nina","Zoë","Naomi","Larissa","Olivia","Stephanie","Noé","Sophie","Lauren","Isa","Chelsey","Fleur","Sarah","Bo","Jaylinn",
            "Anouk","Melissa","Romy","Nora","Julia","Jinte","Kim","Jasmijn","Fiene","Roos","Emma","Tessa","Aimée","Noa","Vajèn","Jade","Philou","Yara","Rosalie","Vera","Tara","Lieke","Joy","Liz","Lynn","Julie","Novi",
            "Valerie","Merle","Mare","Veerle","Sienna","Jenna","Lisa","Eva","Vivian","Fenna","Luna","Liva","Lena","Saar","Phileine","Tess","Ziva","Lisanne","Pippa","Fay","Nola","Senna","Amber","Vesper","Nathalie",
            "Isabel","Mandy","Madee","Norah","Lola","Noor","Claudia","Kelly","Yentl","Cheyenne","Sanne","Madelief","Fayenne","Vanessa","Juna","Ella","Anna","Eline","Cato","Claire","Vienna","Bente","Lotte","Valentina",
            "Milou","Gabriëlle","Lara","Josephine","Jinthe","Jula","Indy","Suze","Livia","Linde","Nicole","Dewi","Jessica","Mae","Fem","Fee","Fenne","Maud","Evi","Ruben","Julian","Matthew","Finn","Mees","Thomas",
            "Boaz","Morris","Pepijn","Dex","Siem","Tobias","Levi","Xavi","Senn","Floris","Jens","Mats","Noah","Tim","Liam","Roan","Maarten","Abel","Hugo","Fedde","Stijn","Valentijn","Jurre","Jasper","Kevin","Otis",
            "Nolan","Bram","Wessel","Rick","Moos","Lenn","Jesse","Olivier","Benjamin","Seth","Duuk","Quinn","Gijs","Tijn","Aaron","Ties","Aiden","Lars","Jelle","Milan","Jayden","Novan","Thijmen","Cas","Kai","Sam",
            "Kick","Max","Lucas","Robin","Wolf","Damian","Noud","Sil","Mason","Daan","Fender","Elias","Ezra","Lennox","Vince","Laurens","Lev","James","Jax","Jan","Vigo","Luca","Bas","Jonah","Thijs","Tygo","Hidde",
            "Julius","Joah","Keano","Arthur","Jace","Jip","Sep","Mika","Jack","Joep","David","Nathan","Ivan","Brent","Micha","Lasse","Sepp","Stan","Melle","Teun","Felix","Oliver","Silvijn","Sven","Oscar","Dylan","Storm",
            "Ryan","Odin","Faas","Boris","Axel","Julan","Sem","Owen","Merijn","Ravi","Loek","Nick","Samuel","Wesley","Rafael","Mick","Guus","Teije","Casper","Jonas","Fabian","Milo","Daniël","Matteo","Joas","Fos",
            "Merlijn","Bodhi","Dean","Ilay","Jesper","Lux","Luuk","Pim","Dante","Jules","Raf","Jonathan","Florian","Jelte","Timo","Tom","Lorenzo","Patrick","Leander","Marijn","Niek","Sef","Alexander","Noan","Justin",
            "Quinten","Sverre","Sten","Olaf","Lewis","Kyan","Ferre","Victor","Joris","Maurits","Evan","Riv","Noël","Dani","Koen","Rune","Ole","Joyce","Fayenn","Isis","Mara","Puck","Jalissa","Robin","Melanie","Chanel",
            "Ashley","Lieve","Laura","Merel","Chloé","Bibi","Jennifer","Pip","Benthe","Juul","Ise","Camilla","Jill","Faye","Leyla","Lune","Lou","Sterre","Hannah","Chantal","Amy","Rosanne","Kyra","June","Daisy","Carmen",
            "Mariëlle","Keet","Sam","Rachel","Jolie","Kaylee","Lise","Chiara","Marit","Gwen","Yenthe","Kiki","Maeve","Emily","Zoi","Noëlle","Floor","Elise","Silke","Lavinia","Fien","Ava","Lily","Rochelle","Anissa"
    };

    private static String[] familienamen = {
            "Peeters","Janssens","Maes","Jacobs","Mertens","Willems","Claes","Goossens","Wouters","De Smet","Vermeulen","Pauwels","Dubois","Hermans","Aerts","Michiels","Lambert","Martens","De Vos","Smets",
            "Claeys","Desmet","Dupont","De Clercq","Van Damme","Hendrickx","Janssen","Stevens","Devos","De Backer","Martin","Lemmens","Segers","Van de Velde","Coppens","Diallo","Simon","Leroy","Dumont",
            "Van den Broeck","Wauters","François","De Cock","Verhoeven","Leclercq","Cools","Laurent","De Smedt","Declercq","Denis","Smet","Thys","Thomas","Renard","Verstraete","Timmermans","Baert","De Meyer",
            "Lejeune","De Wilde","Vandenberghe","De Ridder","Lenaerts","De Pauw","Verheyen","Lauwers","Gérard","Lambrechts","Petit","Geerts","Lemaire","Mathieu","Bogaert","Cornelis","Verbeke","Bauwens","Christiaens",
            "Moens","Charlier","Bosmans","Vermeiren","Verlinden","Wuyts","Verschueren","Michel","Bertrand","Jansen","Van Dyck","Deprez","Fontaine","Noël","Bogaerts","Carlier","Vermeersch","Verstraeten","Simons",
            "Adam","Beckers","Verhaeghe","Claessens","Heylen","Evrard","Goethals","Pieters","Bernard","De Groote","Lefebvre","Van den Bossche","Lievens","Marchal","Thijs","Legrand","Ceulemans","Vandamme",
            "Callens","Mahieu","Van Hecke","Robert","Verhaegen","Collard","Dierckx","Van Acker","Matthys","De Coster","Roels","Moreau","Nijs","Verhelst","Delvaux","Gielen","De Coninck","Raes","Van Hoof","Vercammen",
            "Nys","Verbruggen","Thiry","Cuypers","Luyten","Vandevelde","Yilmaz","Bah","Vervoort","Singh","Vanneste","Somers","Vercruysse","Verdonck","Parmentier","Daems","De Winter","De Witte","Andries","André",
            "Vercauteren","Van Hove","Mortier","Swinnen","Jacques","De Bruyne","De Bruyn","De Bock","Huysmans","Smeets","Vandewalle","Verhulst","Henry","De Wolf","Herman","Claus","Declerck","Leemans","Bastin",
            "De Decker","Baeyens","Verbeeck","Léonard","Rousseau","Vanhove","Dewulf","Gillet","Louis","Guillaume","Vos","Deckers","Van Daele","De Waele","Servais","De Boeck","David","Geens","De Clerck","Smits",
            "Vanhoutte","Meert","Descamps","Hubert","Dierickx","Jans","De Keyser","Van Goethem","Verheyden","Huybrechts","Coenen","Van den Bergh","Moons","Goffin","Lebrun","Toussaint","Engelen","Collin",
            "Vandeputte","Van den Eynde","Meeus","Antoine","Goris","Sterckx","De Wit","Maertens","Vandenbussche","Peters","Schepers","Vandendriessche","Engels","Reynders","Houben","Vandenbroucke","Lecomte",
            "Dhondt","Bekaert","Temmerman","Vaes","Grégoire","Eeckhout","Luyckx","Cornet","Schmitz","Vermeire","Remy","Mariën","Dujardin","Huyghe","Michaux","Maréchal","Joris","Boonen","Libert","Poncelet",
            "Van Camp","Nuyts","Vandaele","Lambrecht","Cuvelier","Barry","De Schepper","Dewaele","Heymans","De Moor","Debruyne","Van den Brande","Decock","Bracke","Lacroix","Lefèvre","Decoster","Bollen",
            "Massart","Van den Berghe","Van Looy","Callewaert","De Paepe","De Greef","Boone","Blomme","Gilson","Baeten","Ooms","Moerman","Helsen","Meunier","Piette","Desmedt","Everaert","De Jonghe","Van Belle",
            "Driesen","Torfs","Schepens","Vincent","Bonte","Van Driessche","De Laet","Jacob","Van Herck","Vranken","Van Roy","De Roeck","Leys","Govaerts","Delhaye","Vanderstraeten","Vrancken","Piron","Bodart",
            "Tanghe","Merckx","De Block","Van de Voorde","Bourgeois","Georges","De Bie","Verbist","Roland","Vandekerckhove","Jonckheere","Van Assche","Hardy","D'Hondt","Borremans","Baetens","Nguyen","Verelst",
            "De Maeyer","Tack","Boulanger","Carpentier","Gilles","Poppe","Theys","Masson","Naessens","Van de Walle","Van Loo","Leysen","Pierre","Hoste","Van Laere","Renders","Dufour","Collignon","Philips","Pattyn",
            "Daniels","Wellens","D'hondt","Kaya","Geeraerts","Dobbelaere","Staelens","Vansteenkiste","De Vuyst","Delfosse","De Baets","Vandecasteele","Yildirim","Etienne","Moors","Van Rompaey","Pollet","Viaene",
            "Vanderheyden","Cox","De Sutter","Van den Bosch","Lefevre","Buelens","Colson","Van Dessel","Vanderlinden","Brasseur","Lippens","Mestdagh","Callebaut","Roelandt","Marchand","Denys","Laenen","De Neve",
            "Ahmed","Smolders","Lecocq","Depoorter","Verboven","Jacquet","Melis","Dethier","Ali","Olivier","Urbain","De Graeve","Casier","Michielsen","Roose","Samyn","Stroobants","Dewitte","Heyvaert","Willaert",
            "Berger","Mercier","Allard","Nicolas","Van Gorp","Delcourt","Cambier","Rutten","Colin","Pirard","Deconinck","Pirotte","Demuynck","Dillen","Laureys","Buysse","Demir","Seghers","De Cuyper","Bertels",
            "Bruggeman","Op de Beeck","Hellemans","Loos","Stas","Van Dijck","Goovaerts","Lammens","Timmerman","Horemans","Dekeyser","Vereecken","Van Looveren","Steyaert","Adams","Rosseel","Bruyninckx",
            "De Wachter","De Ryck","Feys","Roosen","Van Laer","Delmotte","Bodson","De Meester","Dejonghe","De Rycke","Mees","Depuydt","Deleu","Franck","Boon","Huys","Gillis","Dumoulin","Buyse","Barbier",
            "Heremans","Van Impe","Knockaert","Brouwers","De Bondt","Gillard","Arnould","Gevaert","Gobert","Proost","Colpaert","Jacquemin","Bruneel","Degryse","Rogiers","Van Gestel","Van Campenhout","Demoulin",
            "Schoofs","Durieux","Sabbe","Reynaert","Moreels","Van Lierde","Joos","Pirson","Sanders","Put","Fierens","Liekens","Faes","Braem","De Bruycker","Vermeir","Celis","Vereecke","De Schutter","De Mey",
            "Hanssens","Holvoet","Lucas","Sels","Thirion","Vissers"
    };
    //endregion

    // we maken een willekeurige patient aan en voegen eventueel reeds bestaande vaccins toe (als simulatie van een vaccinatie historiek)
    public static Patient createRandomPatient() {

        int voornaam = new Random().nextInt(voornamen.length);
        int familienaam = new Random().nextInt(familienamen.length);
        int registernummer = new Random().nextInt( 99999);
        int vaccinhistoriek = new Random().nextInt(2);

        LocalDate geboortdatum = RandomDate.randomLocalDate();
        String rijksregisternummer = geboortdatum.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")) + " " + String.format("%05d", registernummer).substring(0,3) + "." + String.format("%05d", registernummer).substring(3) ;
        String naam = voornamen[voornaam] + " " + familienamen[familienaam];

        patient = new Patient(rijksregisternummer, naam, geboortdatum);
        VaccinLogger.log().debug("Willekeurig aangemaakte " + patient.toString());

        try {
            for (int i = 0; i < vaccinhistoriek; i++) {
                patient.getVaccins().add(VaccinGenerator.createRandomVaccin(patient));
            }
        }
        catch (DoesNotExistsException e) {
            VaccinLogger.log().error("Er werd een ongekende vaccin opgevraagd om te genereren! Dit vaccin kan niet aangemaakt worden!");
        }

        return patient;

    }

    public static ArrayList<Patient> createRandomListOfPatients() {

        int aantal = new Random().nextInt(25) + 25;
        patients = new ArrayList<>();

        VaccinLogger.log().debug("Starten met het aanmaken van een willekeurige set van patiënten. " + aantal + " in dit geval.");
        for (int i = 0; i < aantal; i++) {
            patients.add(createRandomPatient());
        }
        VaccinLogger.log().debug("Stop, willekeurige set van patiënten werd aangemaakt.");

        VaccinLogger.log().warn("");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("Huidige lijst met gekende patiënten en hun medisch dossier aan vaccins");
        VaccinLogger.log().warn("  er zijn momenteel " + aantal + " gekende patiënten");
        VaccinLogger.log().warn("  daarvan hebben er " + patients.stream().filter(p->p.getVaccins().stream().count()>0).count() + " reeds 1 of meerdere vaccins");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");
        for (Patient patient: patients) {
            VaccinLogger.log().warn(patient);
            for (Vaccin vaccin: patient.getVaccins()) {
                VaccinLogger.log().warn(String.format("%11s %-30s", "", vaccin.toString()));
            }
        }
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");

        return patients;
    }

}
