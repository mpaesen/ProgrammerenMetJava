package structural.facade;
public class FinishedGoodsStore implements Store {

 	 public IGoods getGoods() {
 		 FinishedGoods finishedGoods = new FinishedGoods();
return finishedGoods;
}
}// End of class
