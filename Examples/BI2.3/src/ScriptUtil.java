import org.eclipse.birt.report.engine.api.script.element.IDesignElement;
import org.eclipse.birt.report.model.api.DesignElementHandle;

import java.lang.reflect.Field;

public class ScriptUtil {

	/**
	* Generic method to access DesignElementHandle from a scriptable object
	*
	* @param scriptObject
	* @return
	* @throws NoSuchFieldException
	* @throws IllegalAccessException
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	*/
	public static DesignElementHandle getDesignElementFromScript(IDesignElement scriptObj)
			throws IllegalAccessException, SecurityException, NoSuchFieldException {

		Class scriptParentClass = findDesignElementParent(scriptObj.getClass());
		Field fieldFromScript = scriptParentClass.getDeclaredField("designElementImpl");
		if (fieldFromScript == null) {
			return null;
		}

		// Access the DesignElement field from the Script object  
		fieldFromScript.setAccessible(true);
		Object designElement = fieldFromScript.get(scriptObj);

		// The DesignElement object has a field named "handle"   
		// which is the DesignElementHandle for that DesignElement  
		// Use reflection again to get this field 
		Class simpleApiParentClass = findDesignElementParent(designElement.getClass());
		Field fieldFromSimpleApi = simpleApiParentClass.getDeclaredField("handle");
		if (fieldFromSimpleApi == null) {
			return null;
		}

		// Now access the DesignElementHandle from the DesignElement  
		fieldFromSimpleApi.setAccessible(true);
		return (DesignElementHandle) fieldFromSimpleApi.get(designElement);
	}

	private static final String DESIGN_ELEMENT_NAME = ".DesignElement";

	public static Class findDesignElementParent(Class childClass) throws NoSuchFieldException {
		System.out.println(childClass.toString());
		do {
			childClass = childClass.getSuperclass();
			if (childClass == null)
				throw new NoSuchFieldException("Did not find DesignElement");
			System.out.println(childClass.toString());
		} while (!childClass.toString().endsWith(DESIGN_ELEMENT_NAME));
		return childClass;
	}

}
