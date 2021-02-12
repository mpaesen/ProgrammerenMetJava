package samples;


class MatchSavings extends Account
{
   private double ivRate;
   public MatchSavings(double anAmount,
	  double anInterestRate)
   {
	  super(anAmount);
	  ivRate = anInterestRate;
   }      
   public void deposit(double anAmount)
   {
	  super.deposit(anAmount * 2);
   }      
   public void interest()
   {
	  super.deposit(balance()*ivRate);
   }      
   public static void main(String[] args)
   {
	  MatchSavings mySavings = null;
	  mySavings = new MatchSavings(3000.00,0.10);
	  mySavings.deposit(400.00);
	  mySavings.withdraw(200.00);
	  // calculate interest
	  // and add it to the balance
	  mySavings.interest();
   }      
}