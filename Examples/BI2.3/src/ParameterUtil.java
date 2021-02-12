import org.eclipse.birt.report.engine.api.*;
import org.eclipse.birt.report.engine.api.impl.ParameterDefn;
import org.eclipse.birt.report.engine.api.script.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


public class ParameterUtil {
	public static Collection<IParameterSelectionChoice> getParameterValues(String parameterName, IReportContext reportContext) {
		IGetParameterDefinitionTask task = null;
		HashMap curParams = new HashMap();
		IReportRunnable runnable = reportContext.getReportRunnable();
		try {
		task = runnable.getReportEngine().createGetParameterDefinitionTask(runnable);
		// get the names of all the parameters
		Collection paramRefs = task.getParameterDefns(false);

		// for each parameter name, get the parameter value
		// add the name and value to a hashmap
		for (Iterator iterator = paramRefs.iterator(); iterator.hasNext();) {

		    ParameterDefn pDefn = (ParameterDefn) iterator.next();
		    String name = pDefn.getName();
		    Object curP = reportContext.getParameterValue(name);

		    curParams.put(name, curP);
		}
		
		// set the parameter values for this task from the hashmap.
		task.setParameterValues(curParams);

		// get the parameter that is tied to this table.
		IParameterDefnBase scalar = task.getParameterDefn(parameterName);
		if (scalar instanceof IScalarParameterDefn) {

		    // bind the parameters to the query text
		    task.evaluateQuery(scalar.getName());

		    // get the values for this parameter from its DataSet
		    Collection<IParameterSelectionChoice> paramChoices = (Collection<IParameterSelectionChoice>) task
		            .getSelectionList(scalar.getName());

		    return paramChoices;

		}
		} catch (Exception e) {
		System.out.println("Failure to get parameters");
		} finally {
		task.close();
		}
		return null;
		}
	
}
