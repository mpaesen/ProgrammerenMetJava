package model.service;

import model.Payment;
import model.Sale;
import model.TaxLineItem;

import java.util.ArrayList;

/**
 * @author Erwin Aernouts
 */

public class SpecialAccountingAdapter implements IAccountingAdapter {

	@Override
	public void postReceivable(Payment payment) 
	{
		double cash = payment.getAmount();
		//send info in correct form to accountsystem
		System.out.println("\nPayment info in correct form send to Special-accountsystem: \n" + cash);
	}

	@Override
	public void postSale(Sale sale) 
	{
		ArrayList<TaxLineItem> taxItems = sale.getTaxLineItems();
		//send info in correct form to accountsystem
	}

}
