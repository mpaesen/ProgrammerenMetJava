
package view;

import business.Calculation;
import business.Calculator;
import business.Operator;
import io.IOCalculator;

import java.io.IOException;
import java.util.HashSet;

import static java.lang.Character.toUpperCase;

/**
 * Test class for the basic calculator
 * @author Mathy Paesen
 * @version 1.1 refactoring
 * @category Programmeren met java
 * @since 2019-09-17
 */
public class CalculatorTest {

    /**
     * @param args
     */
    public static void main(final String[] args) throws IllegalArgumentException, IOException {
        HashSet<Calculation> calculations = new HashSet<>();

        char source = getInputSource();
        switch (source) {
            case 'U':
                userDialog(calculations);
                break;
            case 'F':
                calculations = IOCalculator.getCalculationsFromFile("calculations.txt");
                break;
            case 'S':
                calculations = IOCalculator.getCalculationsFromScanner("calculations.txt");
                break;
            default:
                calculations = IOCalculator.getRandomCalculations();
        }


        try {
            IOCalculator.writeResultsToFile("results.txt", calculations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void userDialog(HashSet<Calculation> calculations) {
        final String FIRST = "Give first Value: ";
        final String SECOND = "Give second Value: ";
        final String OPERATION = "Give the operation (+, -, *, /, ^): ";
        final String RESULT = "The result of: \n";

        Calculation calculation;

        double result;
        double first, second;
        Operator operator;

        String message = new String(RESULT);
        do {
            String input = dialog(FIRST);

            // conversion of input into "first" value
            first = Double.parseDouble(input);
            input = dialog(SECOND);
            // conversion of input into "second" value
            second = Double.parseDouble(input);
            input = dialog(OPERATION);
            // substring of input into "operator"
            operator = Operator.getOperator(input);
            //instantiation of business class
            final Calculator calculator = new Calculator();
            result = calculator.result(first, second, operator);
            calculation = new Calculation(operator, first, second);
            calculation.setResult(result);
            calculations.add(calculation);
            // prepare message
            message = getResult(message, first, second, operator);
            message = String.format("%s %5.2f", message, result);
            // show message
            JOptionPane.showMessageDialog(null, message);
            message = "";

        } while (anOtherCalculation());

    }


    private static String dialog(String text) {
        return JOptionPane.showInputDialog(text);
    }

    private static char getInputSource() {
        String anOther = dialog("Do you want input from a File, Scanner, User dialog or Random? (F/S/U/R): ");
        return toUpperCase(anOther.charAt(0));
    }

    private static boolean anOtherCalculation() {
        String anOther = dialog("An other Calculation? (Y/N): ");
        return toUpperCase(anOther.charAt(0)) == 'Y';
    }

    private static String getResult(String message, final double first,
                                    final double second, final Operator operator) {
        // present the result
        message = message + first;
        switch (operator) {
            case ADD: {
                message = String.format("%s added to %s", message, second);
                break;
            }
            case SUB: {
                message = message + " subtracted by " + second;
                break;
            }
            case MULT: {
                message = message + " multiplied by " + second;
                break;
            }
            case DIV: {
                message = message + " divided by " + second;
                break;
            }
            case POW: {
                message = message + " power to " + second;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return message + " equals: ";
    }
}
