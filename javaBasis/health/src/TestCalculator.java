import javax.swing.*;

public class TestCalculator {
    public static void main(String[]args){
        do {
            double lengte = getLength("Geef de lengte in m:");
            double gewicht = getGewicht("Geef het gewicht in kg:");
            BMICalculator bmi = new BMICalculator(lengte, gewicht);
            bmi.setBmi(bmi.calculateBMI());
            JOptionPane.showMessageDialog(null, "BMI "
                    + String.format("%s", bmi.toString()));
        }while(getUserAnswer() == 'J');
    }

    public static char getUserAnswer(){
        String answer = JOptionPane.showInputDialog("Wenst u nog een berekening? (j/n) :");
        return Character.toUpperCase(answer.charAt(0));
    }
    public static double getLength(String message){
        String lengte = JOptionPane.showInputDialog(message);
        return Double.parseDouble(lengte);
    }

    public static double getGewicht(String message){
        String gewicht = JOptionPane.showInputDialog(message);
        return Double.parseDouble(gewicht);
    }
}
