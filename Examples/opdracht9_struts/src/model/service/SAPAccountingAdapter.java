package model.service;

import model.Payment;
import model.Sale;
import model.SalesLineItem;

import java.util.ArrayList;

/**
 * @author Erwin Aernouts
 */

public class SAPAccountingAdapter implements IAccountingAdapter 
{

	@Override
	public void postReceivable(Payment payment) 
	{
		double cash = payment.getAmount();
		//send info in correct form to accountsystem
		System.out.println("\nPayment info in correct form send to SAP-accountsystem: \n" + cash);
	}

	@Override
	public void postSale(Sale sale) {
		ArrayList<SalesLineItem> taxItems = sale.getSalesLineItems();
		//send info in correct form to accountsystem
	}

}
