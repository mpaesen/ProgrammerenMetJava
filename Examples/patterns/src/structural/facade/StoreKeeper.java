package structural.facade;

public class StoreKeeper {

	/**
	 * The raw materials are asked for and are returned
	 * @return raw materials
	 */
	public RawMaterialGoods getRawMaterialGoods() {
		RawMaterialStore store = new RawMaterialStore();
		RawMaterialGoods rawMaterialGoods = (RawMaterialGoods) store.getGoods();
		return rawMaterialGoods;
	}

	/**
	 * The packaging materials are asked for and are returned
	 * @return packaging materials
	 */
	public PackingMaterialGoods getPackingMaterialGoods() {
		PackingMaterialStore store = new PackingMaterialStore();
		PackingMaterialGoods packingMaterialGoods = (PackingMaterialGoods) store
				.getGoods();
		return packingMaterialGoods;
	}

	/**
	 * The finished goods are asked for and are returned
	 * @return finished goods
	 */
	public FinishedGoods getFinishedGoods() {
		FinishedGoodsStore store = new FinishedGoodsStore();
		FinishedGoods finishedGoods = (FinishedGoods) store.getGoods();
		return finishedGoods;
	}

}// End of class
