package behavioral.strategy.customer;


// Strategy for Happy hour (50% discount)
class HappyHourStrategy implements IBillingStrategy {

    public double getActPrice(double rawPrice) {
        return rawPrice * 0.5;
    }
}