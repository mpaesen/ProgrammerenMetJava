package business;

/**
 * Enumeration that represents the basic operators of a calculator
 *
 * @author Mathy
 * @since 2019-09-17
 */
public enum Operator {
    ADD("+"), SUB("-"), MULT("*"), DIV("/"), POW("^");
    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator getOperator(String operator) throws IllegalArgumentException {
        switch (operator) {
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MULT;
            case "/":
                return DIV;
            case "^":
                return POW;
            default:
                throw new IllegalArgumentException("Wrong Operation!");
        }
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operator='" + operator + '\'' +
                '}';
    }

    public char getOperator() {
        return operator.charAt(0);
    }
}
