package model;

public interface Verkoopbaar {

    // verschillende eenheidsprijzen toe te passen afhankelijk van wat immomakelaar verkoopt (type woning, grond, ...)

    double getEenheidPrijs();

    // creatie functie voor berekening van de prijs
    // iedere klasse moet deze implementeren
    // in deze oefening enkel woningen dus implementatie door Woningen en gaat verder via de subklassen
    // immo kantoor kan bv. ook grond, commerciële panden, ... verkopen, eveneens prijsberekening nodig -- nut interfaces!

    double berekenPrijs();
}
