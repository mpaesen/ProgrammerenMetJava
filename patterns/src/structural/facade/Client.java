package structural.facade;

public class Client {

	/**
	 * to get raw materials
	 */
	public static void main(String[] args) {
		StoreKeeper keeper = new StoreKeeper();
		RawMaterialGoods rawMaterialGoods = keeper.getRawMaterialGoods();
	}
}// End of class