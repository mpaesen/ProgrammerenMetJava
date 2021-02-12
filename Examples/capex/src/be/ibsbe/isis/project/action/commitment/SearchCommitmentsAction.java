package be.ibsbe.isis.project.action.commitment;

import be.ibsbe.isis.project.database.CommitmentDB;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class SearchCommitmentsAction extends Action
{
	static Logger logger;
	static Class class$0;

	static
	{
		Class class_;
		class_ = class$0;
		if (class_ == null)
		{
			try
			{
				class_ = SearchCommitmentsAction.class$0 = Class.forName("be.ibsbe.isis.project.action.commitment.SearchCommitmentsAction");
			}
			catch (final ClassNotFoundException v1)
			{
				throw new NoClassDefFoundError(v1.getMessage());
			}
		}
		logger = Logger.getLogger(class_);
	}

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse resp) throws Exception
	{
		logger.info("in " + this.getClass());
		final ActionErrors errors = new ActionErrors();
		final ActionErrors errors2 = new ActionErrors();
		ActionForward forward = new ActionForward();
		final User user = (User) req.getSession().getAttribute("user");
		final HashMap<String, String> mapSearchCriteria = new HashMap<String, String>();
		final SearchCommitmentForm searchCommitmentForm = (SearchCommitmentForm) form;
		try
		{
			if (searchCommitmentForm.getComm_ref() != null && !"".equals(searchCommitmentForm.getComm_ref()))
			{
				mapSearchCriteria.put("comm_ref", searchCommitmentForm.getComm_ref());
			}
			else if (req.getSession().getAttribute("comm_ref") != null && !"".equals((String) req.getSession().getAttribute("comm_ref")))
			{
				mapSearchCriteria.put("comm_ref", req.getSession().getAttribute("comm_ref").toString());
			}
			if (searchCommitmentForm.getComm_orgname() != null && !"".equals(searchCommitmentForm.getComm_orgname()))
			{
				mapSearchCriteria.put("comm_orgname", searchCommitmentForm.getComm_orgname());
			}
			else if (req.getSession().getAttribute("comm_orgname") != null && !"".equals((String) req.getSession().getAttribute("comm_orgname")))
			{
				mapSearchCriteria.put("comm_orgname", req.getSession().getAttribute("comm_orgname").toString());
			}
			if (searchCommitmentForm.getComm_ownername() != null && !"".equals(searchCommitmentForm.getComm_ownername()))
			{
				mapSearchCriteria.put("comm_ownername", searchCommitmentForm.getComm_ownername());
			}
			else if (req.getSession().getAttribute("comm_ownername") != null && !"".equals((String) req.getSession().getAttribute("comm_ownername")))
			{
				mapSearchCriteria.put("comm_ownername", req.getSession().getAttribute("comm_ownername").toString());
			}
			if (searchCommitmentForm.getComm_status() != null && !"".equals(searchCommitmentForm.getComm_status()))
			{
				mapSearchCriteria.put("comm_status", searchCommitmentForm.getComm_status());
			}
			else if (req.getSession().getAttribute("comm_status") != null && !"".equals((String) req.getSession().getAttribute("comm_status")))
			{
				mapSearchCriteria.put("comm_status", (String) req.getSession().getAttribute("comm_status"));
			}
			if (searchCommitmentForm.getComm_orgmatchcode() != null && !"".equals(searchCommitmentForm.getComm_orgmatchcode()))
			{
				mapSearchCriteria.put("comm_orgmatchcode", searchCommitmentForm.getComm_orgmatchcode());
			}
			if (searchCommitmentForm.getComm_comment() != null && !"".equals(searchCommitmentForm.getComm_comment()))
			{
				mapSearchCriteria.put("comm_comment", searchCommitmentForm.getComm_comment());
			}
			if (searchCommitmentForm.getComm_budgetyear() != null && !"".equals(searchCommitmentForm.getComm_budgetyear()))
			{
				mapSearchCriteria.put("comm_budgetyear", searchCommitmentForm.getComm_budgetyear());
			}
			if (mapSearchCriteria.isEmpty())
			{
				errors2.add("NoSearchCriteriaGiven", new ActionError("error.noSearchCriteriaGiven"));
			}
			else
			{
				req.getSession().setAttribute("collFoundCommitments", (Object) CommitmentDB.searchCommitmentsWithSearchCriteria(mapSearchCriteria, (User) user, (String) ((String) req.getSession().getAttribute("dateformatType"))));
			}
			req.getSession().removeAttribute("comm_orgname");
			req.getSession().removeAttribute("comm_ref");
			req.getSession().removeAttribute("comm_ownername");
			req.getSession().removeAttribute("comm_status");
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			errors.add("error.project.noFound", new ActionError("error.project.noFound"));
			this.saveErrors(req, errors);
		}
		if (!errors2.isEmpty())
		{
			this.saveErrors(req, errors2);
		}
		forward = mapping.findForward("success");
		return forward;
	}
}