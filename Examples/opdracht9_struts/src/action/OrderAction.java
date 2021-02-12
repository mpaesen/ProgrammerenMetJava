package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import controller.Register;
import db.FileIO;

import java.util.Map;

public class OrderAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int test;
	private String aantal = "1";
	private String productID;

	public String execute() throws Exception
	{
		FileIO dao = new FileIO();
		Register testRegister = new Register();
		

		
		Map<String,Object> parameters = ActionContext.getContext().getParameters();
	    String[] productID = (String[])parameters.get("productID");
	    String[] aantal = (String[])parameters.get("aantal");
	    
	    if(aantal == null ||productID == null)
	    	return ERROR;
	    
	    try
	    {
	    	for (int i = 0; i < productID.length; i++) {
				if (aantal[i] !="0") {
					testRegister.scanProdukt(Integer.parseInt(productID[i]), Double.parseDouble(aantal[i]));
				}
			}
	    	
	    }
	    catch(Exception e)
	    {
	    	return ERROR;
	    }

	    test ++;
	    return SUCCESS;
    }
	
	
	public int getTest(){
		return test;
	}
	
	public void setAantal(String aantal){
		this.aantal = aantal;
	}

	public String getAantal() {
		return aantal;
	}
	
	public void setProductID(String productID){
		this.productID = productID;
	}

	public String getProductID() {
		return productID;
	}

}
