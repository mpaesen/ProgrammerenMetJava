package behavioral.strategy.customer;

// Normal billing strategy (unchanged price)
class NormalStrategy implements IBillingStrategy {

    public double getActPrice(double rawPrice) {
        return rawPrice;
    }
}