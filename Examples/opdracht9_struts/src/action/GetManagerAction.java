package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import db.FileIO;
import model.Employee;

import java.util.Map;

/**
 * This action will retrieve a specific employee from the database.
 * This action can access the request parameters by requesting the parameter map of the application context.
 * request parametes are always stored as a map of type Map<String key, Object> where object is an array of values.
 * @author Stijn Heylen
 *
 */
public class GetManagerAction extends ActionSupport
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
	        
	    if(empl==null||empl.getName()==null || empl.getName().equals("") || empl.getRole() != 1)
	    	return NONE;
	    this.setNummer("");
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
