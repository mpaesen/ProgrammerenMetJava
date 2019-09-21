package business;

import java.text.NumberFormat;
import java.util.Random;

/**
 * Represents a basic calculation
 * A calculation is composed of an operator
 * and 2 operands
 * Each calculation is unique by an ID
 *
 * @author Mathy
 * @since 2019-09-17
 */
public class Calculation implements Comparable<Calculation> {
    private static int count;
    private int id;
    private Operator operation;
    private Double op1, op2;
    private Double result;

    public Calculation(Operator operation, Double op1, Double op2) {
        id = ++count;
        this.operation = operation;
        this.op1 = op1;
        this.op2 = op2;
    }

    public static Calculation generateRandomCalculation(Random random) {
        double opt1 = random.nextDouble() * 10;
        double opt2 = random.nextDouble() * 20;
        Operator operation = Operator.values()[random.nextInt(Operator.values().length)];
        Calculation calculation = new Calculation(operation, opt1, opt2);
        return calculation;
    }

    public int getId() {
        return id;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Operator getOperation() {
        return operation;
    }

    public void setOperation(Operator operation) {
        this.operation = operation;
    }

    public Double getOp1() {
        return op1;
    }

    public void setOp1(Double op1) {
        this.op1 = op1;
    }

    public Double getOp2() {
        return op2;
    }

    public void setOp2(Double op2) {
        this.op2 = op2;
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getInstance();
        return String.format("%S%n",
                String.format("Calculation{%s%s%s = %s}",
                        String.format("%9.2f", op1),
                        String.format("%5S", operation.getOperator()),
                        String.format("%9.2f", op2),
                        String.format("%20S", format.format(getResult()))));
    }

    public int compareTo(Calculation o) {
        if (this.getId() < o.getId())
            return -1;
        if (this.getId() > o.getId())
            return +1;
        return 0;
    }
}
