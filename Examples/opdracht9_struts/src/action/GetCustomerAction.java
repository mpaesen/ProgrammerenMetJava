package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import db.FileIO;
import db.Store;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.Map;

/**
 * This action will retrieve a specific employee from the database.
 */
public class GetCustomerAction extends ActionSupport
{
private static final long serialVersionUID = 1L;
	
    private Customer customer;
    private String nummer;
	private String employee;
    private ArrayList<Product> producten = new ArrayList<Product>();
   
	public String execute() throws Exception
	{
		FileIO dao = new FileIO();
		
		
		Map<String,Object> parameters = ActionContext.getContext().getParameters();
	    String[] nummer = (String[])parameters.get("nummer");
	    if(nummer == null || nummer[0]==null)
	    	return ERROR;
	    
	    String[] empl = (String[])parameters.get("employee");
	    this.employee = empl[0];
	    
	    try
	    {
	    	customer = dao.getCustomer(Integer.parseInt(nummer[0]));
	    }
	    catch(Exception e)
	    {
	    	return ERROR;
	    }
	        
	    if(customer==null||customer.getName()==null || customer.getName().equals(""))
	    	return NONE;
	       	
	    return SUCCESS;
    }

	//mandatory getter and setter
    public Customer getCustomer() {
        return this.customer;
    }

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getNummer() {
		return nummer;
	}
	
	public void setEmployee (String employee){
		this.employee = employee;
	}
	
	public String getEmployee(){
		return this.employee;
	}

	public ArrayList<Product> getProducten(){
		
		FileIO.serializeShopStart1();
		//FileIO.serializeShopStart();
		
		for (Product p : Store.getProductCatalog().getProductCatalog().values()) {
			
			producten.add(p);
			
		}
		return producten;
		
		}
}
