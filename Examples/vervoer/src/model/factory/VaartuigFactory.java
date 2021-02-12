package model.factory;

import model.vaartuigen.Boot;
import model.vaartuigen.MotorBoot;
import model.vaartuigen.Vaartuig;
import utilities.Category;

import java.math.BigDecimal;

/**
 * Write a description of class Factory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VaartuigFactory
{
    /**
     * An example of a factorymethod
     * 
     * @param  y   int
     * @return     Vaartuig 
     */
    public static Vaartuig createVaartuig(int y)
    {
        // put your code here
    	BigDecimal waarde = new BigDecimal("0");
    	Category category = Category.ONBEPAALD;
        switch(y){
            case 0: return new Boot(category, waarde);
            case 1: return new MotorBoot(category, waarde);
            default:return null;
        }
    }
    }
