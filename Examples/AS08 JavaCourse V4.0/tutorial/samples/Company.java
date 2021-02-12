package samples;


class Company {
   private Employee emp;
   public void hire(Employee e) {
	  emp = e;
   }      
   public void makeMoney() {
	  emp.doWork();
	  emp.getPay();
   }      
}