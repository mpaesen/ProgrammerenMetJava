/*
 * Created on Feb 17, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package view;

import model.AdvantageCard;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ResultBean
{
	private Collection list;
	private String office;

	public ResultBean()
	{
		super();
		list = new ArrayList();
	}

	public void add(final AdvantageCard card)
	{
		list.add(card);
	}

	/**
	 * @return
	 */
	public Collection getList()
	{
		return list;
	}

	/**
	 * @param collection
	 */
	public void setList(final Collection collection)
	{
		list = collection;
	}

	/**
	 * @return
	 */
	public String getOffice()
	{
		return office;
	}

	/**
	 * @param string
	 */
	public void setOffice(final String string)
	{
		office = string;
	}

}
