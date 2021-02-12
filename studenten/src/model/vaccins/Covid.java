package model.vaccins;

import model.Patient;
import model.Vaccin;
import model.exceptions.AlreadyVaccinatedException;
import persistency.VaccinLogger;
import utils.Globals;

import java.util.List;
import java.util.stream.Collectors;

public class Covid extends Vaccin {

    @Override
    protected void registreren(Patient patient) throws AlreadyVaccinatedException {
        List<Vaccin> covids = patient.getVaccins().stream().filter(p->p.getClass() == Covid.class).collect(Collectors.toList());

        // je mag maar 1x gevaccineerd worden met dit Covid-vaccin
        if (!covids.isEmpty()){
            throw new AlreadyVaccinatedException();
        }
        else {
            VaccinLogger.log().warn(Globals.prefixVaccinatie + "Covid oproepingsbrief ingevuld, afgetekend en gescand in het systeem. Patiënt is geregistreerd voor inenting.");
        }
    }

    @Override
    protected void informeren() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Uitgelegd wat het verschil is van dit vaccin met dat van Pfizer omdat je nu maar 1x ingeënt moet worden.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Tijdens de informatie is het nodig om af te checken of de patiënt de toelichting begrepen heeft zodat de patiënt zich niet nogmaals aandient.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Een vertaler/tolk is enkel beschikbaar wanneer de patiënt bereid is de kosten te dragen.");
    }

    @Override
    protected void voorbereiden() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "De patiënt geeft registratieformulier en identiteitskaart af aan de administratieve verpleger(s).");
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "De verpleger onttrekt de exacte dosis uit de ampul. Dit gebeurt pas vlak voor het toedienen.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Let op angstsymptomen bij de patiënt en stel de patiënt gerust.");
    }

    @Override
    protected void toedienen() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "De spoedverpleger of dokter ontsmet de bovenarm waar de inspuiting zal plaatsvinden.");
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "De spoedverpleger of dokter dient het vaccin toe.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Na het injecteren van de naald wordt er eerst een klein beetje bloed opgetrokken om vast te stellen dat de naald goed zit.");
    }
    @Override
    protected void nazorgen() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "++ De patiënt werd overgebracht naar een wachtruimte en wordt hier 15 minunten te observatie in het oog gehouden.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "++ Vraag hoe de patiënt zich voelt om cnnectie te maken en houd voornamelijk duiligheid in het oog.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "++ Uitzonderlijk kan een patiënt in zwijm vallen. Er zijn branchards voorzien.");
    }
}
