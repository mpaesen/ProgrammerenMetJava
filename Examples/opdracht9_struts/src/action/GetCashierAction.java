package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import db.FileIO;
import model.Employee;

import java.util.Map;

/**
 * This action will retrieve a specific employee from the database.
 */
public class GetCashierAction extends ActionSupport
{
private static final long serialVersionUID = 1L;
	
    private Employee empl;
    private String nummer;
    
	public String execute() throws Exception
	{
		FileIO dao = new FileIO();
		
		Map<String,Object> parameters = ActionContext.getContext().getParameters();
	    String[] names = (String[])parameters.get("nummer");
	    if(names == null || names[0]==null)
	    	return ERROR;
	    
	    try
	    {
	    	empl = dao.getEmployee(Integer.parseInt(names[0]));
	    }
	    catch(Exception e)
	    {
	    	return ERROR;
	    }
	        
	    if(empl==null||empl.getName()==null || empl.getName().equals(""))
	    	return NONE;
	       	this.nummer = "";
	    return SUCCESS;
    }

	//mandatory getter and setter
    public Employee getEmployee() {
        return empl;
    }

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getNummer() {
		return nummer;
	}
	
	
}
