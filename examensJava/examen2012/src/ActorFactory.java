
/**
 * Write a description of class ActorFactory here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class ActorFactory
{
  
    public static Actor createActor(int type, Locatie locatie){
        Actor actor = null;
        switch(type){
            case 1: {actor = new Verkeerstoren(locatie); 
                actor.setFuncties(BasisFunctiesFactory.createBasisFuncties(1));
                break;
            }
            case 2: {actor = new Schip(locatie);
                actor.setFuncties(BasisFunctiesFactory.createBasisFuncties(2));
                break;
            }    
            case 3: {actor = new Hulpdienst(locatie); 
                actor.setFuncties(BasisFunctiesFactory.createBasisFuncties(1));
                break;}
        }
        return actor;
    }
}
