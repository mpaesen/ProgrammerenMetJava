package com.vaccination.prod;

import com.vaccination.prod.enums.*;
import com.vaccination.prod.factory.*;
import com.vaccination.prod.template.*;
import org.apache.log4j.*;
import java.sql.Timestamp;
import java.util.*;

/**
 *
 * <p><b>Main entry of this Console- project</b></p>
 *
 * <p>This Class wil generate random vaccinations</p>
 * <p>each vaccination contains</p>
 * <ul>
 *    <li> Patient</li>
 *    <li> Vaccine</li>
 *  </ul>
 *  <p>A vaccine contains a flow of 5 steps</p>
 *  <p>Test-data for this project is available in arrays and enumerations</p>
 *
 *  <u>Creation of Objects</u>
    <ul>
 *    <li>Vaccine object ->  Factory Pattern</li>
 *    <li>Step-objects -> template Pattern</li>
 * </ul>
 *  <u>Log4j</u>
 * <ul>
 *  <li>location property file: root-folder project</li>
 *  <li>output : root-folder project</li>
 * </ul>
 *
 *  <u>Junit</u>
 *  <p>
 *  folder /src/test contains the JUnit test classes
 *  </p>
 *
 *
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);

    private static final String[] PATIENTS = {"Iris Straets", "Liesje Verboven", "Ann Vermeulen", "Veerle Thijs",
            "Elly Naets", "choë Harms", "Peter Vervliet", "Guy Kenis", "Sandra Pollet", "Luc Woutes", "Bart Schaeken",
            "Mark Cornu", "Christophe Van Loock", "Hilde Follens", "Tinne Van Mechelen", "Justine Diels", "Lieselore Hertz",
            "Eva Bettens", "Johan Schepens", "Lionel Stuur", "Staf De Giraf", "Frans Ambulance", "Els Lapere", "Caroline Hansen"};

    private static final String[] RSZNUMMERS={"42012205181","78012205181","79012205181","82012205181","84012205181","85012205181",
            "86012205181","87012205181","96012205181","97012205181","97012205320","77012205181","88012205181","92012205987","95012205181",
            "58012205181","62012205181","70102205181","92012205181","90012205181","52091005181","80012205181","52012205181","50012205181"};

    LinkedList<Vaccination> vaccinationList = new LinkedList<Vaccination>();
    private final int AANNTAL_PATIENTEN = 10;


    public static void main(String[] args)
    {

       // BasicConfigurator.configure();  Log to console, gebruikt geen configfile
        // log4J
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.info("___Test_Log4J______Loglevel=Debug_________________________");
        logger.info("config : /log4j.properties");
        logger.info("output: /examenTemplPattern.log");
        logger.info("Test Log4J  Loglevel=Debug");
        logger.debug("debug logging - logs voor debuggen");
        logger.info("info logging - informatief");
        logger.warn("warn logging - waarschuwing, niet fataal");
        logger.error("error logging - error, mogelijk niet fataal");
        logger.fatal("fatal logging - error waarbij de applicatie stopt");
        logger.info("__________________________________________________________\n\n\n\n");



         // generate Vaccinlist with vaccins
        Test testProgrammaObj = new Test();
        testProgrammaObj.generateTestData();
        // print overview to logfile & console
        testProgrammaObj.createOverview();
    }



    /**
     * calculate number of years between birth (social security code)
     * and currentdate
     * @param rszNummer String
     * @return numberOfYears int
     */
    private int getAge(String rszNummer)
    {
        int year=1900;
        int month=00;
        int day=00;
        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, age;
        year =(Integer.parseInt(rszNummer.substring(0,2)))+ 1900;
        month=Integer.parseInt(rszNummer.substring(2,4));
        day=Integer.parseInt(rszNummer.substring(4,6));
        y = cal.get(Calendar.YEAR);// current year ,
        m = cal.get(Calendar.MONTH);// current month
        d = cal.get(Calendar.DAY_OF_MONTH);// current day
        cal.set(year, month, day);// checkdate
        age = (int) (y - cal.get(Calendar.YEAR));
        if ((m < cal.get(Calendar.MONTH)) || ((m == cal.get(Calendar.MONTH)) && (d < cal.get(Calendar.DAY_OF_MONTH)))) {
            --age;
        }
        return age;
    }


    /**
     * <p><b>Generate testData</b></p>
     * <u>Object and content:</u>
     * <ul>
     * <li><b>Action:</b> contains the name and description of the step (Vaccine process has 5 steps)</li>
     * <li><b>Vaccine:</b> VaccineName, List of Action-Objects (5)</li>
     * <li><b>Patient:</b> Name and social security number</li>
     * <li><b>Vaccination:</b> Vaccine-Object, Patient-Object</li>
     * <li><b>VaccineList:</b> List of Vaccination-Objects</li>
     * </ul>
     *
     * @return void
     */
    private void generateTestData() {
        if(vaccinationList==null)
        {
            vaccinationList = new LinkedList<Vaccination>();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        printLine(" ________________ Vaccinaties - patiënten ________________________" + timestamp + "___________",true);
        String patientName="";
        String rSZnr="";
        int rndNr=0;
        Vaccine tmpVaccine=null;
        Patient tmpPatient=null;
        Action tmpAction=null;
        Vaccination tmpVaccination = null;
        List<String> patientChoiseList = new ArrayList<String>();
        for (int n = 0; n < PATIENTS.length; n++) {
            patientChoiseList.add(PATIENTS[n]);
        }

        List<String> rSZChoiseList = new ArrayList<String>();
        for (int n = 0; n < RSZNUMMERS.length; n++) {
            rSZChoiseList.add(RSZNUMMERS[n]);
        }
        for (int i = 0; i < AANNTAL_PATIENTEN; i++) {
            rndNr=getRandomInt(0,3);
            //genereer vacineObj via factory
            // genereer stappen en voeg stappen toe aan action-obj
            // action-obj toevoegen aan vacineobj
            tmpVaccine = VaccineFactory.getVaccine(VaccineEnum.values()[rndNr].name());
            rndNr=getRandomInt(0,3);
           tmpAction=new Step1Action(StepName.values()[0].getDescription(),ActionStep1.values()[rndNr].getDescription());
            tmpVaccine.setAction(tmpAction);
            rndNr=getRandomInt(0,3);
            tmpAction=new Step2Action(StepName.values()[1].getDescription(),ActionStep2.values()[rndNr].getDescription());
            tmpVaccine.setAction(tmpAction);
            rndNr=getRandomInt(0,3);
            tmpAction=new Step3Action(StepName.values()[2].getDescription(),ActionStep3.values()[rndNr].getDescription());
            tmpVaccine.setAction(tmpAction);
            rndNr=getRandomInt(0,3);
            tmpAction=new Step4Action(StepName.values()[3].getDescription(),ActionStep4.values()[rndNr].getDescription());
            tmpVaccine.setAction(tmpAction);
            rndNr=getRandomInt(0,3);
            tmpAction=new Step5Action(StepName.values()[4].getDescription(),ActionStep5.values()[rndNr].getDescription());
            tmpVaccine.setAction(tmpAction);

            // genereer RSZnr & patientnaam
            patientName =pickRandomItemFromList(patientChoiseList);
            rSZnr=pickRandomItemFromList(rSZChoiseList);
            rSZChoiseList.remove(rSZnr);
            patientChoiseList.remove(patientName);
            tmpPatient = new Patient(patientName,rSZnr);
            tmpVaccination=new Vaccination(tmpVaccine,tmpPatient);

            // Lijst van alle gegenereerde vaccinatie-objecten
            this.vaccinationList.add(tmpVaccination);
        }
    }



    private void printLine(String content,boolean writeToLog)
    {
        if(writeToLog)
        {
            //naar logfile + console  (zie fileappender & consoleappender in log4j.properties)
            logger.info(content);
        }
        else
        {
            //enkel naar console
            System.out.println(content);
        }
    }


    private void createOverview()
    {
        // vaccinationList
        Action myAction=null;
        int i=0;
        String rszNr="";
        String content="";
        for(Vaccination vaccination:vaccinationList)
        {
            content="Vaccinatie " + ++i + " : " + vaccination.getMyVaccine().getVaccineName();
            printLine(content,true);
            content="Patiënt: " + vaccination.getPatient().getName();
            printLine(content,true);
            rszNr=vaccination.getPatient().getSocialSecurityNumber();
            content=("Leeftijd: " + getAge(rszNr));
            printLine(content,true);
            content=("Riziv: " + rszNr);
            printLine(content,true);
            content=("Procedure :");
            printLine(content,true);
            myAction = ((Step1Action)vaccination.getMyVaccine().getActions(0));
            content=("   " + ((Step1Action)vaccination.getMyVaccine().getActions(0)).getName() + ":   " + ((Step1Action)vaccination.getMyVaccine().getActions(0)).getDescription());
            printLine(content,true);
            content=("   " + ((Step2Action)vaccination.getMyVaccine().getActions(1)).getName() + ":   " + ((Step2Action)vaccination.getMyVaccine().getActions(1)).getDescription());
            printLine(content,true);
            content=("   " + ((Step3Action)vaccination.getMyVaccine().getActions(2)).getName() + ":   " + ((Step3Action)vaccination.getMyVaccine().getActions(2)).getDescription());
            printLine(content,true);
            content=("   " + ((Step4Action)vaccination.getMyVaccine().getActions(3)).getName() + ":   " + ((Step4Action)vaccination.getMyVaccine().getActions(3)).getDescription());
            printLine(content,true);
            content=("   " + ((Step5Action)vaccination.getMyVaccine().getActions(4)).getName() + ":   " + ((Step5Action)vaccination.getMyVaccine().getActions(4)).getDescription());
            printLine(content,true);
            content=("____________________________________________________________________________________________________");
            printLine(content,true);
        }
    }

    private static String pickRandomItemFromList(List<String> tmpList) {
        Random rand = new Random();
        return tmpList.get((rand.nextInt(tmpList.size())));
    }

    private int getRandomInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
