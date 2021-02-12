package model.service;

import model.Payment;
import model.Sale;

/**
 * @author Erwin Aernouts
 */

public interface IAccountingAdapter 
{
public void postReceivable(Payment payment);//CreditPayment
public void postSale(Sale sale);
}
