import javax.swing.*;

/**
 * @Author mathy
 * @since versie 1
 * @subject Calculation
 *
 */
public class BMICalculator extends Object{
    //Berekening van BMI
    private double lengte;
    private double gewicht;
    private double bmi;

    public BMICalculator(double lengte, double gewicht) {
        this.lengte = lengte;
        this.gewicht = gewicht;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return "BMICalculator{" +
                "lengte=" + lengte +
                ","+"\n\t"+" gewicht=" + gewicht +
                ","+"\n\t"+" bmi=" + String.format("%.2f",bmi) +
                '}';
    }

    public double calculateBMI(){
        return gewicht/Math.pow(getLengte(),2.0);
    }


}
