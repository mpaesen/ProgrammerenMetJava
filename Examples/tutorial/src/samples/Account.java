package samples;


public class Account
{
   private double ivBalance;
   public Account()
   {
	  this(0.0);
   }      
   public Account( double anAmount )
   {
	  ivBalance = anAmount;
   }      
   public double balance()
   {
	  return ivBalance;
   }      
   public void deposit(double anAmount)
   {
	  ivBalance += anAmount;
   }      
   public static void main(String[] args)
   {
	  Account a, b, c;
	  long amount;
	  a = new Account(100.00);
	  b = new Account();
	  c = new Account(3000.00);
	  b.deposit(300.00);
	  c.withdraw(400.00);
	  amount = (long)a.balance();
   }      
   public void withdraw(double anAmount)
   {
	  ivBalance -= anAmount;
   }      
}