package model.pricing;

public abstract class DiscountComponent {
	
	public void add (DiscountComponent discountcomponent){
		throw new UnsupportedOperationException();
	}
	
	public void remove (DiscountComponent discountcomponent){
		throw new UnsupportedOperationException();
	}

	public DiscountComponent getChild (int i){
		throw new UnsupportedOperationException();
	}
	
	public String getName(){
		throw new UnsupportedOperationException();

	}
	public String getDescription(){
		throw new UnsupportedOperationException();

	}
	
	
}
