package as400test;

import com.ibm.as400.access.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Enumeration;

public class LoadJobsWithMsgw
{

	public static void main(final String[] args)
	{
		final LoadJobsWithMsgw loadjobswithmsgw = new LoadJobsWithMsgw();
		loadjobswithmsgw.loadem();
	}

	public void loadem()
	{
		final AS400 as400 = new AS400("bei5dev.ibsbe.be", "AIDA", "AIDA2009");
		final JobList joblist = new JobList(as400);
		final String myselect = "MSGW";
		try
		{
			joblist.addJobSelectionCriteria(JobList.SELECTION_PRIMARY_JOB_STATUS_ACTIVE, Boolean.TRUE);

			joblist.addJobSelectionCriteria(JobList.SELECTION_ACTIVE_JOB_STATUS, myselect);

		}
		catch (final PropertyVetoException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Enumeration list;
		try
		{
			list = joblist.getJobs();
			while (list.hasMoreElements())
			{
				final Job j = (Job) list.nextElement();
				//System.out.println(j.getStatus().equals(j.ACTIVE_JOB_STATUS_WAIT_MESSAGE));
				System.out.println(j.getName() + " | " + j.getUser() + " | " + j.getNumber() + " | " + j.getStatus());
			}
		}
		catch (final AS400SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (final ErrorCompletingRequestException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (final InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (final IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (final ObjectDoesNotExistException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
