package test;

import business.Calculation;
import business.Calculator;
import business.Operator;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    Calculator calculator;
    Double result;
    private Calculation calc;

    @org.junit.Before
    public void setUp() throws Exception {

        calculator = new Calculator();
    }

    @org.junit.Test
    public void result() {
        //ADD
        calc = new Calculation(Operator.ADD, 2.0, 8.0);
        result = calculator.result(calc.getOp1(), calc.getOp2(), calc.getOperation());
        assertTrue(result == 10.0);
        //POW
        calc.setOperation(Operator.POW);
        result = calculator.result(calc.getOp1(), calc.getOp2(), calc.getOperation());
        assertTrue(result == 256.0);
        //DIV
        calc.setOperation(Operator.DIV);
        result = calculator.result(calc.getOp1(), calc.getOp2(), calc.getOperation());
        assertTrue(result == 0.25);
        //SUB
        calc.setOperation(Operator.SUB);
        result = calculator.result(calc.getOp1(), calc.getOp2(), calc.getOperation());
        assertTrue(result == -6.0);
        //MULT
        calc.setOperation(Operator.MULT);
        result = calculator.result(calc.getOp1(), calc.getOp2(), calc.getOperation());
        assertTrue(result == 16.0);
    }

    @org.junit.Test
    public void divideByZeroTest() {
        //DIV
        calc = new Calculation(Operator.ADD, 2.0, 0.0);
        calc.setOperation(Operator.DIV);
        result = calculator.result(calc.getOp1(), calc.getOp2(), calc.getOperation());
        assertTrue("Divide by Zero", !(result == 0.0));
    }
}