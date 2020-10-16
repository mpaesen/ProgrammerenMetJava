package model.factory;

import model.motoren.Motor;

public class Motoren {
    public static Motor createRandomMotor() {
        String type;
        // initialise instance variables
        switch ((int) (Math.random() * 5.0)) {
            case 0:
                type = "diesel";
                break;
            case 1:
                type = "benzine";
                break;
            case 2:
                type = "electrisch";
                break;
            case 3:
                type = "hybride";
                break;
            default:
                type = "H20";
                break;
        }
        return new Motor(type);
    }

    public static Motor createRandomMotor(int motor) {
        String type;
        // initialise instance variables
        switch (motor) {
            case 0:
                type = "diesel";
                break;
            case 1:
                type = "benzine";
                break;
            case 2:
                type = "electrisch";
                break;
            case 3:
                type = "hybride";
                break;
            default:
                type = "H20";
                break;
        }
        return new Motor(type);
    }
}
