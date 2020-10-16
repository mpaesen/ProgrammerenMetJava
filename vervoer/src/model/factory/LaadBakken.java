package model.factory;

import model.laadbakken.LaadBak;

public class LaadBakken {

    public static LaadBak createLaadBak() {
        // initialise instance variables
        LaadBak laadbak;
        switch ((int) (Math.random() * 3.0)) {
            case 0:
                laadbak = new LaadBak("open container");
                break;
            case 1:
                laadbak = new LaadBak("tank");
                break;
            case 2:
                laadbak = new LaadBak("gesloten container");
                break;
            default:
                laadbak = new LaadBak("geen laadbak");
                break;
        }
        return laadbak;
    }
}
