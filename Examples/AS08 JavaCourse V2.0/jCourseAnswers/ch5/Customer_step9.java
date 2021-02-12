import java.math.BigDecimal;
/**
 * A customer class
 */
public class Customer
{
    private String name;
    private BigDecimal discount;

    /**
     * Constructor
     * @param name name of customer. Eg "Bob Roberts"
     * @param discount amount customer is discounted on prices. Eg 0.2F
     */
    public Customer(String name, float discount)
    {
        this.name = name;
        this.discount = new BigDecimal((float)discount);
    }

    /**
     * Return customer's name
     * @return name of this customer
     */
    public String getName()
    {
        return name;
    }

    /**
     * Given an dollar value price, returns this customer's
     * price after applying his discount
     * @param price - Dollar amount to apply discount to
     * @return discounted price
     */
    public BigDecimal applyDiscount(float price)
    {
        BigDecimal priceObject = new BigDecimal((double)price);
        BigDecimal tempPrice = priceObject.multiply(discount);
        BigDecimal hisRate = priceObject.subtract(tempPrice);
        hisRate = hisRate.setScale(2, BigDecimal.ROUND_HALF_UP);
        return hisRate;
    }

    /**
     * Command line control
     */
    public static void main(String args[])
    {
        Customer cust1;
        if (args.length != 2)
          {
           cust1 = new Customer("Bob Roberts",0.15F);
          }
        else
          {
             String name = args[0]; // first parameter is name
             String rateAsString = args[1]; // second is rate
             float  rateAsFloat = 0;
             // convert rateAsString to a float value...
             try
             {
                Float floatObject = Float.valueOf(rateAsString);
                rateAsFloat = floatObject.floatValue();
             }
             catch (NumberFormatException exc)
             {
                System.out.println("Second parameter not a floating point number");
                return;
             }
             cust1 = new Customer(name, rateAsFloat);
          } // end else
        System.out.println("Customer name : " + cust1.getName());
        System.out.println("Customer price: " + cust1.applyDiscount(100.00F)); // CHANGE ZZZZ
    }
} // end of class Customer