package behavioral.strategy.customer;

import java.util.ArrayList;
import java.util.List;


class Customer
{
    private List<Double> drinks;

    // Get/Set Strategy
    private IBillingStrategy strategy;

    public Customer(IBillingStrategy strategy)
    {
        this.drinks = new ArrayList<Double>();
        this.strategy = strategy;
    }

    public void add(double price, int quantity)
    {
        drinks.add(strategy.getActPrice(price * quantity));
    }

    // Payment of bill
    public void PrintBill()
    {
        double sum = 0;
        for (Double i : drinks) {
            sum += i;
        }
        System.out.println("Total due: " + sum);
        drinks.clear();
    }

    public IBillingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IBillingStrategy strategy) {
        this.strategy = strategy;
    }
}