
/**
 * Write a description of class BasisFunctiesFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasisFunctiesFactory
{

    public static BasisFuncties createBasisFuncties(int type){
        BasisFuncties functies = null;
        switch(type){
            case 1: {functies = new Static(); break;}
            case 2: {functies = new Mobile(); break;}
        }
        return functies;
    }
}
