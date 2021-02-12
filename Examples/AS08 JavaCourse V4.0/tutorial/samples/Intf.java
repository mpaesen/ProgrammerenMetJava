package samples;


public class Intf {
   public static void main(String[] args) {
	  Company c = new Company();
	  Person p = new Person();
	  c.hire(p);
	  c.makeMoney();
	  p.giveHug();
   }      
}