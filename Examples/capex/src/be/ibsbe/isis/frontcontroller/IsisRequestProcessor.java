package be.ibsbe.isis.frontcontroller;

import org.apache.log4j.Logger;

import java.io.IOException;

public class IsisRequestProcessor extends RequestProcessor
{
	static Logger logger;
	PreProcessingFilter firstPreProcessingFilter;
	static Class class$0;

	static
	{
		Class class_;
		class_ = class$0;
		if (class_ == null)
		{
			try
			{
				class_ = IsisRequestProcessor.class$0 = Class.forName("be.ibsbe.isis.frontcontroller.IsisRequestProcessor");
			}
			catch (final ClassNotFoundException v1)
			{
				throw new NoClassDefFoundError(v1.getMessage());
			}
		}
		logger = Logger.getLogger(class_);
	}

	public IsisRequestProcessor()
	{
		logger.debug("in IsisRequestProcessor");
		this.firstPreProcessingFilter = new SessionValidFilter(null);
	}

	protected ActionForward processActionPerform(final HttpServletRequest request, final HttpServletResponse response, final Action action, final ActionForm form, final ActionMapping mapping) throws IOException, ServletException
	{
		final ActionForward actionForward = this.firstPreProcessingFilter.process(request, response, action, form, mapping);
		if (actionForward == null)
		{
			return super.processActionPerform(request, response, action, form, mapping);
		}
		return actionForward;
	}
}
