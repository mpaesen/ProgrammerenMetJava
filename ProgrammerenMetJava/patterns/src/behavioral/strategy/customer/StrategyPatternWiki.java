package behavioral.strategy.customer;

public class StrategyPatternWiki {
    public static void main(String[] args) {
        // Prepare strategies
        IBillingStrategy normalStrategy = new NormalStrategy();
        IBillingStrategy happyHourStrategy = new HappyHourStrategy();

        Customer firstCustomer = new Customer(normalStrategy);

        // Normal billing
        firstCustomer.add(1.0, 1);

        // Start Happy Hour
        firstCustomer.setStrategy(happyHourStrategy);
        firstCustomer.add(1.0, 2);
        System.out.println("The first Customer pays");
        firstCustomer.PrintBill();

        // New Customer
        Customer secondCustomer = new Customer(happyHourStrategy);
        secondCustomer.add(0.8, 1);

        // End Happy Hour
        secondCustomer.setStrategy(normalStrategy);
        secondCustomer.add(1.3, 2);
        secondCustomer.add(2.5, 1);
        System.out.println("\nThe second Customer pays");
        secondCustomer.PrintBill();
    }
}
