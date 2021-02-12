package model.service;

import controller.Register;

/**
 * @author Erwin Aernouts
 */

public class ServicesFactory 
{
	private static ServicesFactory servicesFactory;
	private IAccountingAdapter accountingAdapter;
	private IBusinessRules businessRules;
	
	private ServicesFactory()
	{
		String classNameAccount = "model.service." + Register.getStore().getServiceProperties().getProperty("a1");
		String classNameBusiness = "model.service." + Register.getStore().getServiceProperties().getProperty("b1");
		try 
		{
			//set AccountingAdapter
			this.accountingAdapter = (IAccountingAdapter)Class.forName(classNameAccount).newInstance();
			//set Businessrules
			this.businessRules = (IBusinessRules)Class.forName(classNameBusiness).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ServicesFactory getServicesFactory()
	{
		if (servicesFactory == null)
			servicesFactory = new ServicesFactory();
		return servicesFactory;
	}
	
	public IAccountingAdapter getAccountingAdapter() 
	{
		return accountingAdapter;
	}	
	
	public IBusinessRules getBusinessRules()
	{
		return businessRules;
	}
}
