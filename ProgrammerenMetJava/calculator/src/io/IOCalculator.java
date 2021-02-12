package io;

import business.Calculation;
import business.Calculator;
import business.Operator;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Implements IO methods use by the basic calculator
 *
 * @author Mathy
 * @since 2019-09-18
 */
public final class IOCalculator {
    private static String[] words;
    private static final HashSet<Calculation> calculations = new HashSet<Calculation>();
    private static String operation;
    private static Double op1, op2;
    private static String input;


    /**
     * @param operations
     * @return HashSet
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public static HashSet<Calculation> getCalculationsFromScanner(String operations) throws IllegalArgumentException, IOException {
        try (Scanner scanner = new Scanner(new FileReader(operations))) {
            Calculator calculator;
            String input;
            while (scanner.hasNext()) {
                input = scanner.nextLine();
                words = input.split(" ");
                for (int i = 0; i < words.length; i++) {
                    switch (i) {
                        case 0:
                            operation = words[i];
                            break;
                        case 1:
                            op1 = Double.parseDouble(words[i]);
                            break;
                        case 2:
                            op2 = Double.parseDouble(words[i]);
                            break;
                        default:
                            throw new IllegalArgumentException("Wrong Operator, or Operands");
                    }
                }
                Operator operator = Operator.getOperator(operation);
                Calculation calculation = new Calculation(operator, op1, op2);
                calculator = new Calculator();
                calculation.setResult(calculator.result(op1, op2, Operator.getOperator(operation)));
                calculations.add(calculation);
            }
        }
        return calculations;
    }


    /**
     * @param operations
     * @return HashSet
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public static HashSet<Calculation> getCalculationsFromFile(String operations) throws IllegalArgumentException, IOException {
        //reads text file with predefined operations
        try (BufferedReader reader = new BufferedReader(new FileReader(operations))) {
            Calculator calculator;
            input = reader.readLine();
            while (input != null) {
                words = input.split(" ");
                for (int i = 0; i < words.length; i++) {
                    switch (i) {
                        case 0:
                            operation = words[i];
                            break;
                        case 1:
                            op1 = Double.parseDouble(words[i]);
                            break;
                        case 2:
                            op2 = Double.parseDouble(words[i]);
                            break;
                        default:
                            throw new IllegalArgumentException("Wrong Operator, or Operands");
                    }
                }
                Operator operator = Operator.getOperator(operation);
                Calculation calculation = new Calculation(operator, op1, op2);
                calculator = new Calculator();
                calculation.setResult(calculator.result(op1, op2, Operator.getOperator(operation)));
                calculations.add(calculation);
                input = reader.readLine();
            }
        }
        return calculations;
    }

    /**
     * @return HashSet
     */
    public static HashSet<Calculation> getRandomCalculations() {

        Random random = new Random();
        //minium 10 calculation
        final int MAX = 10 + random.nextInt(30);
        Calculator calculator;
        for (int i = 0; i < MAX; i++) {
            Calculation calculation = Calculation.generateRandomCalculation(random);
            calculator = new Calculator();
            calculation.setResult(calculator.result(calculation.getOp1(), calculation.getOp2(), calculation.getOperation()));
            calculations.add(calculation);
        }
        return calculations;
    }


    /**
     * @param results
     * @param calculations
     * @throws IOException
     */
    public static void writeResultsToFile(String results, HashSet<Calculation> calculations) throws IOException {
        //writes text file with results of operations

        BufferedWriter writer = new BufferedWriter(new FileWriter(results));
        for (Calculation calc : calculations) {
            writer.write(calc.toString());
        }
        writer.close();
    }
}
