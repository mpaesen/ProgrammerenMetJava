package be.ibsbe.isis.project.database;

import be.ibsbe.database.DatabaseConnectionController;
import be.ibsbe.database.asw.AswDataHandler;
import be.ibsbe.isis.Constants;
import be.ibsbe.isis.dataobject.AdminSettingsSingleton;
import be.ibsbe.isis.dataobject.User;
import be.ibsbe.isis.numeration.database.NumerationDB;
import be.ibsbe.isis.organisation.database.OrganisationDB;
import be.ibsbe.isis.organisation.database.PersonDB;
import be.ibsbe.isis.organisation.dataobject.Organisation;
import be.ibsbe.isis.organisation.dataobject.Person;
import be.ibsbe.isis.project.database.ProjectDB;
import be.ibsbe.isis.project.database.PurchaseOrderDB;
import be.ibsbe.isis.project.dataobject.Commitment;
import be.ibsbe.isis.project.dataobject.PurchaseOrderHeader;
import be.ibsbe.isis.selectiontable.dataobject.SelectionTableSingleton;
import be.ibsbe.isis.workflow.database.WorkflowLogDB;
import be.ibsbe.isis.workflow.dataobject.WorkflowLog;
import be.ibsbe.utilities.DataTypeSwitch;
import be.ibsbe.utilities.General;
import be.ibsbe.utilities.SqlManipulations;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CommitmentDB
{
	static Logger logger;
	static/* synthetic */Class class$0;

	static
	{
		Class class_;
		class_ = class$0;
		if (class_ == null)
		{
			try
			{
				class_ = CommitmentDB.class$0 = Class.forName("be.ibsbe.isis.project.database.CommitmentDB");
			}
			catch (final ClassNotFoundException v1)
			{
				throw new NoClassDefFoundError(v1.getMessage());
			}
		}
		logger = Logger.getLogger(class_);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static String getMaxReference(final Connection connection) throws Exception
	{
		logger.debug("in CommitmentDB.getMaxReference(Project project)");
		PreparedStatement preparestatement = null;
		ResultSet result = null;
		String ref = "0";
		try
		{
			try
			{
				preparestatement = connection.prepareStatement("select max(comm_ref) from commitment");
				result = preparestatement.executeQuery();
				if (result.next())
				{
					ref = result.getString(1);
				}
				if (ref == null)
				{
					ref = "0";
				}
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getMaxReference", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparestatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparestatement);
		return ref;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateStatus(final String commitment_id, final String commitment_status) throws Exception
	{
		logger.debug("in CommitmentDB.updateStatus");
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				CommitmentDB.updateStatus(commitment_id, commitment_status, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.updateStatus", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateStatus(final String commitment_id, final String commitment_status, final Connection connection) throws Exception
	{
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				preparedStatement = connection.prepareStatement("update Commitment set comm_status=? where comm_id=?");
				preparedStatement.setString(1, commitment_status);
				preparedStatement.setString(2, commitment_id);
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.updateStatus", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateIsInBudget(final String commitment_id, final boolean isInBudget) throws Exception
	{
		logger.debug("in CommitmentDB.updateIsInBudget");
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				CommitmentDB.updateIsInBudget(commitment_id, isInBudget, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.updateIsInBudget", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateIsInBudget(final String commitment_id, final boolean isInBudget, final Connection connection) throws Exception
	{
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				logger.debug("sql in updateIsInBudget=update Commitment set comm_isInBudget=? where comm_id=?");
				preparedStatement = connection.prepareStatement("update Commitment set comm_isInBudget=? where comm_id=?");
				preparedStatement.setBoolean(1, isInBudget);
				preparedStatement.setString(2, commitment_id);
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.updateIsInBudget", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static boolean getExtraApproval(final String commitment_id) throws Exception
	{
		logger.debug("in CommitmentDB.getExtraApproval");
		boolean inheritApproval = false;
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				inheritApproval = CommitmentDB.getExtraApproval(commitment_id, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getExtraApproval", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
		return inheritApproval;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static boolean getExtraApproval(final String commitment_id, final Connection connection) throws Exception
	{
		PreparedStatement preparedStatement = null;
		final boolean inheritApproval = false;
		try
		{
			try
			{
				logger.debug("sql in getExtraApproval=select comm_inheritApproval from Commitment where comm_id=?");
				preparedStatement = connection.prepareStatement("select comm_inheritApproval from Commitment where comm_id=?");
				preparedStatement.setBoolean(1, inheritApproval);
				preparedStatement.setString(2, commitment_id);
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getExtraApproval", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
		return inheritApproval;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateExtraApproval(final String commitment_id, final boolean extraApproval) throws Exception
	{
		logger.debug("in CommitmentDB.updateExtraApproval");
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				CommitmentDB.updateExtraApproval(commitment_id, extraApproval, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.updateExtraApproval", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateExtraApproval(final String commitment_id, final boolean extraApproval, final Connection connection) throws Exception
	{
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				logger.debug("sql in updateExtraApproval=update Commitment set comm_inheritApproval=? where comm_id=?");
				preparedStatement = connection.prepareStatement("update Commitment set comm_inheritApproval=? where comm_id=?");
				preparedStatement.setBoolean(1, extraApproval);
				preparedStatement.setString(2, commitment_id);
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.updateInheritApproval", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
	}

	public static void updateOrg(final String commId, final String orgId, PreparedStatement preparedStatement, final Connection connection) throws Exception
	{
		try
		{
			preparedStatement = connection.prepareStatement("update Commitment set comm_orgid=? where comm_id=?");
			preparedStatement.setString(1, orgId);
			preparedStatement.setString(2, commId);
			preparedStatement.executeUpdate();
			preparedStatement.clearParameters();
		}
		catch (final Exception e)
		{
			logger.error("Error in method CommitmentDB.updateOrg", e);
			throw e;
		}
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void insert(final Commitment commitment, final String dateFormat) throws Exception
	{
		Connection connection = null;
		boolean aswEnabled = false;
		final AdminSettingsSingleton adminSettingsSingleton = AdminSettingsSingleton.getInstance();
		try
		{
			try
			{
				aswEnabled = adminSettingsSingleton.get((Object) "aswStatus").equals("on");
				connection = DatabaseConnectionController.createConnection();
				CommitmentDB.insert(commitment, aswEnabled, dateFormat, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.insert", e);
				throw e;
			}
			final Object var6_8 = null;
		}
		catch (final Throwable var7_6)
		{
			final Object var6_7 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var7_6;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void insert(final Commitment commitment, final boolean aswEnabled, final String dateFormat, final Connection connection) throws Exception
	{
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				preparedStatement = connection
						.prepareStatement("insert into Commitment(comm_id, comm_ref, comm_orgid, comm_status,comm_comment,comm_budget, comm_currency,comm_department,comm_bu,comm_supplier,comm_category,comm_subcategory,comm_opercategory,comm_motivation,comm_proposalid,comm_creationdate, comm_endperiod, comm_startperiod, comm_ownerid, comm_locknr, comm_isActive,comm_versionstatus,comm_versiontype,comm_versionnr,comm_condition,comm_isInBudget,comm_inheritApproval,comm_budgetyear,comm_type,comm_depreciation_legal,comm_depreciation_ifrs,comm_notificationpersid,comm_projType,comm_custref,comm_initialbudget,comm_manualbudget) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, commitment.getComm_id());
				if (aswEnabled)
				{
					final String companyCode = OrganisationDB.getCompanyCodeForOneOrganisation((String) commitment.getComm_orgid(), (Connection) connection);
					preparedStatement.setString(2, AswDataHandler.getNewReference((int) 802, (String) companyCode));
				}
				else
				{
					preparedStatement.setString(2, NumerationDB.getNewReference((String) "commitment", (int) 9));
				}
				preparedStatement.setString(3, commitment.getComm_orgid() != null ? commitment.getComm_orgid() : "");
				preparedStatement.setString(4, commitment.getComm_status() != null ? commitment.getComm_status() : "");
				preparedStatement.setString(5, commitment.getComm_comment() != null ? commitment.getComm_comment() : "");
				preparedStatement.setBigDecimal(6, commitment.getComm_budget());
				preparedStatement.setString(7, commitment.getComm_currency() != null ? commitment.getComm_currency() : "");
				preparedStatement.setString(8, commitment.getComm_department() != null ? commitment.getComm_department() : "");
				preparedStatement.setString(9, commitment.getComm_bu() != null ? commitment.getComm_bu() : "");
				preparedStatement.setString(10, commitment.getComm_supplier() != null ? commitment.getComm_supplier() : "");
				preparedStatement.setString(11, commitment.getComm_category() != null ? commitment.getComm_category() : "");
				preparedStatement.setString(12, commitment.getComm_subcategory() != null ? commitment.getComm_subcategory() : "");
				preparedStatement.setString(13, commitment.getComm_opercategory() != null ? commitment.getComm_opercategory() : "");
				preparedStatement.setString(14, commitment.getComm_motivation() != null ? commitment.getComm_motivation() : "");
				preparedStatement.setString(15, commitment.getComm_proposalid() != null ? commitment.getComm_proposalid() : "");
				preparedStatement.setDate(16, commitment.getComm_creationdate() != null && !commitment.getComm_creationdate().equals("") ? DataTypeSwitch.stringToSqlDate((String) commitment.getComm_creationdate(), (String) dateFormat) : null);
				preparedStatement.setString(17, commitment.getComm_endperiod() != null ? commitment.getComm_endperiod() : "");
				preparedStatement.setString(18, commitment.getComm_startperiod() != null ? commitment.getComm_startperiod() : "");
				preparedStatement.setString(19, commitment.getComm_ownerid() != null ? commitment.getComm_ownerid() : "");
				preparedStatement.setInt(20, commitment.getComm_locknr());
				preparedStatement.setBoolean(21, commitment.isComm_isactive());
				preparedStatement.setString(22, commitment.getComm_versionstatus() != null ? commitment.getComm_versionstatus() : "");
				preparedStatement.setString(23, commitment.getComm_versiontype() != null ? commitment.getComm_versiontype() : "");
				preparedStatement.setString(24, commitment.getComm_versionnr() != null ? commitment.getComm_versionnr() : "");
				preparedStatement.setString(25, commitment.getComm_condition() != null ? commitment.getComm_condition() : "");
				preparedStatement.setBoolean(26, false);
				preparedStatement.setBoolean(27, commitment.isComm_extraApproval());
				preparedStatement.setString(28, commitment.getComm_budgetyear());
				preparedStatement.setString(29, commitment.getComm_type());
				preparedStatement.setBigDecimal(30, commitment.getComm_depreciation_legal());
				preparedStatement.setBigDecimal(31, commitment.getComm_depreciation_ifrs());
				preparedStatement.setString(32, commitment.getComm_notificationpersid());
				preparedStatement.setString(33, commitment.getComm_projType());
				preparedStatement.setString(34, commitment.getComm_custref());
				preparedStatement.setBigDecimal(35, commitment.getComm_initialbudget());
				preparedStatement.setBigDecimal(36, commitment.getComm_manualbudget());
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
				CommitmentDB.writeSR(commitment, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.insert", e);
				throw e;
			}
			final Object var6_9 = null;
		}
		catch (final Throwable var7_7)
		{
			final Object var6_8 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var7_7;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void update(final Commitment commitment, final String dateFormat) throws Exception
	{
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				CommitmentDB.update(commitment, dateFormat, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.insert", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void update(final Commitment commitment, final String dateFormat, final Connection connection) throws Exception
	{
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				logger.debug("SQL in update:update Commitment set comm_ref=?, comm_orgid=?, comm_status=?, comm_comment=?, comm_budget=?, comm_currency=?, comm_department=?, comm_bu=?, comm_supplier=?, comm_category=?, comm_subcategory=?, comm_opercategory=?, comm_motivation=?, comm_proposalid=?, comm_creationdate=?, comm_endperiod=?, comm_startperiod=?, comm_ownerid=?, comm_locknr=?, comm_isActive=?, comm_versionstatus=?, comm_versiontype=?, comm_versionnr=?, comm_condition=?, comm_isInBudget=?, comm_inheritApproval=?, comm_budgetyear=?, comm_type=?,comm_depreciation_legal=?,comm_depreciation_ifrs=?,comm_notificationpersid=?,comm_projType=?, comm_custref=?,comm_initialbudget=?,comm_manualbudget=? where comm_id=?");
				preparedStatement = connection
						.prepareStatement("update Commitment set comm_ref=?, comm_orgid=?, comm_status=?, comm_comment=?, comm_budget=?, comm_currency=?, comm_department=?, comm_bu=?, comm_supplier=?, comm_category=?, comm_subcategory=?, comm_opercategory=?, comm_motivation=?, comm_proposalid=?, comm_creationdate=?, comm_endperiod=?, comm_startperiod=?, comm_ownerid=?, comm_locknr=?, comm_isActive=?, comm_versionstatus=?, comm_versiontype=?, comm_versionnr=?, comm_condition=?, comm_isInBudget=?, comm_inheritApproval=?, comm_budgetyear=?, comm_type=?,comm_depreciation_legal=?,comm_depreciation_ifrs=?,comm_notificationpersid=?,comm_projType=?, comm_custref=?,comm_initialbudget=?,comm_manualbudget=? where comm_id=?");
				preparedStatement.setString(1, commitment.getComm_ref() != null ? commitment.getComm_ref() : "");
				preparedStatement.setString(2, commitment.getComm_orgid() != null ? commitment.getComm_orgid() : "");
				preparedStatement.setString(3, commitment.getComm_status() != null ? commitment.getComm_status() : "");
				preparedStatement.setString(4, commitment.getComm_comment() != null ? commitment.getComm_comment() : "");
				preparedStatement.setBigDecimal(5, commitment.getComm_budget());
				preparedStatement.setString(6, commitment.getComm_currency() != null ? commitment.getComm_currency() : "");
				preparedStatement.setString(7, commitment.getComm_department() != null ? commitment.getComm_department() : "");
				preparedStatement.setString(8, commitment.getComm_bu() != null ? commitment.getComm_bu() : "");
				preparedStatement.setString(9, commitment.getComm_supplier() != null ? commitment.getComm_supplier() : "");
				preparedStatement.setString(10, commitment.getComm_category() != null ? commitment.getComm_category() : "");
				preparedStatement.setString(11, commitment.getComm_subcategory() != null ? commitment.getComm_subcategory() : "");
				preparedStatement.setString(12, commitment.getComm_opercategory() != null ? commitment.getComm_opercategory() : "");
				preparedStatement.setString(13, commitment.getComm_motivation() != null ? commitment.getComm_motivation() : "");
				preparedStatement.setString(14, commitment.getComm_proposalid() != null ? commitment.getComm_proposalid() : "");
				preparedStatement.setDate(15, commitment.getComm_creationdate() != null && !commitment.getComm_creationdate().equals("") ? DataTypeSwitch.stringToSqlDate((String) commitment.getComm_creationdate(), (String) dateFormat) : null);
				preparedStatement.setString(16, commitment.getComm_endperiod() != null ? commitment.getComm_endperiod() : "");
				preparedStatement.setString(17, commitment.getComm_startperiod() != null ? commitment.getComm_startperiod() : "");
				preparedStatement.setString(18, commitment.getComm_ownerid() != null ? commitment.getComm_ownerid() : "");
				preparedStatement.setInt(19, commitment.getComm_locknr());
				preparedStatement.setBoolean(20, commitment.isComm_isactive());
				preparedStatement.setString(21, commitment.getComm_versionstatus() != null ? commitment.getComm_versionstatus() : "");
				preparedStatement.setString(22, commitment.getComm_versiontype() != null ? commitment.getComm_versiontype() : "");
				preparedStatement.setString(23, commitment.getComm_versionnr() != null ? commitment.getComm_versionnr() : "");
				preparedStatement.setString(24, commitment.getComm_condition() != null ? commitment.getComm_condition() : "");
				preparedStatement.setBoolean(25, commitment.isComm_isInBudget());
				preparedStatement.setBoolean(26, commitment.isComm_extraApproval());
				preparedStatement.setString(27, commitment.getComm_budgetyear());
				preparedStatement.setString(28, commitment.getComm_type());
				preparedStatement.setBigDecimal(29, commitment.getComm_depreciation_legal());
				preparedStatement.setBigDecimal(30, commitment.getComm_depreciation_ifrs());
				preparedStatement.setString(31, commitment.getComm_notificationpersid());
				preparedStatement.setString(32, commitment.getComm_projType());
				preparedStatement.setString(33, commitment.getComm_custref());
				preparedStatement.setBigDecimal(34, commitment.getComm_initialbudget());
				preparedStatement.setBigDecimal(35, commitment.getComm_manualbudget());
				preparedStatement.setString(36, commitment.getComm_id());
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
				CommitmentDB.deleteSalesrepsOfCommitment(commitment.getComm_id(), connection);
				CommitmentDB.writeSR(commitment, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.update", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static String getCommitmentRef(final String comm_id) throws Exception
	{
		String commitmentRef = null;
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				commitmentRef = CommitmentDB.getCommitmentRef(comm_id, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getCommitmentRef", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
		return commitmentRef;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static String getCommitmentRef(final String comm_id, final Connection connection) throws Exception
	{
		String commitmentRef = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				preparedStatement = connection.prepareStatement("select comm_ref from Commitment where comm_id=?");
				preparedStatement.setString(1, comm_id);
				result = preparedStatement.executeQuery();
				while (result.next())
				{
					commitmentRef = result.getString("comm_ref");
				}
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getCommitmentRef", e);
				throw e;
			}
			final Object var6_8 = null;
		}
		catch (final Throwable var7_6)
		{
			final Object var6_7 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var7_6;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return commitmentRef;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static BigDecimal getSumOfCommitmentBudgets(final String project_id) throws Exception
	{
		BigDecimal sum = new BigDecimal("0");
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				sum = CommitmentDB.getSumOfCommitmentBudgets(project_id, connection);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getSumOfCommitmentBudgets", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
		return sum;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static BigDecimal getSumOfCommitmentBudgets(final String project_id, final Connection connection) throws Exception
	{
		BigDecimal sum = new BigDecimal("0");
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		StringBuffer sqlBuf = null;
		try
		{
			try
			{
				sqlBuf = new StringBuffer("select comm_budget from Commitment where comm_proposalid=? and comm_isActive=? and comm_status in (");
				sqlBuf.append("?,?)");
				logger.debug("sql in getSumOfCommitmentBudgets=" + sqlBuf.toString());
				preparedStatement = connection.prepareStatement(sqlBuf.toString());
				preparedStatement.setString(1, project_id);
				preparedStatement.setBoolean(2, true);
				preparedStatement.setString(3, "30");
				preparedStatement.setString(4, "70");
				result = preparedStatement.executeQuery();
				do
				{
					if (!result.next())
					{
						logger.debug("voor projectid " + project_id + " is de som van de commitments " + sum);
						break;
					}
					sum = sum.add(result.getBigDecimal("comm_budget"));
				}
				while (true);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getSumOfCommitmentBudgets", e);
				throw e;
			}
			final Object var7_9 = null;
		}
		catch (final Throwable var8_7)
		{
			final Object var7_8 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var8_7;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return sum;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static Commitment getCommitmentWithCommId(final String comm_id, final User user, final String dateFormat) throws Exception
	{
		Commitment commitment = null;
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				commitment = CommitmentDB.getCommitmentWithCommId(comm_id, user, connection, dateFormat);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getCommitmenWithCommIdt", e);
				throw e;
			}
			final Object var6_8 = null;
		}
		catch (final Throwable var7_6)
		{
			final Object var6_7 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var7_6;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
		return commitment;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static Commitment getCommitmentWithCommId(final String comm_id, final User user, final Connection connection, final String dateFormat) throws Exception
	{
		Commitment commitment = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				preparedStatement = connection.prepareStatement("select * from Commitment where comm_id=?");
				preparedStatement.setString(1, comm_id);
				result = preparedStatement.executeQuery();
				if (result.next())
				{
					commitment = CommitmentDB.readCommitment(result, user, true, connection, dateFormat);
					Set tmpSet = new TreeSet<Commitment>();
					tmpSet.add(commitment);
					tmpSet = CommitmentDB.getReadOrWriteCommitments(tmpSet, user, dateFormat, connection);
					commitment = tmpSet.isEmpty() ? null : (Commitment) tmpSet.iterator().next();
				}
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getCommitmentWithCommId", e);
				throw e;
			}
			final Object var8_11 = null;
		}
		catch (final Throwable var9_9)
		{
			final Object var8_10 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var9_9;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return commitment;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static Set getCommitmentsForProposal(final String proj_id, final String comm_selectedbudgetyear, final User user, final String dateFormat) throws Exception
	{
		Set set = null;
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				set = CommitmentDB.getCommitmentsForProposal(proj_id, comm_selectedbudgetyear, user, connection, dateFormat);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getCommitmentsForProposal", e);
				throw e;
			}
			final Object var7_9 = null;
		}
		catch (final Throwable var8_7)
		{
			final Object var7_8 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var8_7;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
		return set;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static boolean hasProposalCommitments(final String proj_id, final User user, final Connection connection) throws Exception
	{
		int number = 0;
		boolean hasCommitments = false;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				preparedStatement = connection.prepareStatement("select count(*) from Commitment where comm_proposalid=? and comm_isActive=1");
				preparedStatement.setString(1, proj_id);
				result = preparedStatement.executeQuery();
				if (result.next())
				{
					number = result.getInt(1);
				}
				hasCommitments = number != 0;
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getNumberOfCommitmentsForProposal", e);
				throw e;
			}
			final Object var8_10 = null;
		}
		catch (final Throwable var9_8)
		{
			final Object var8_9 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var9_8;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return hasCommitments;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static Set getCommitmentsForProposal(final String proj_id, final String comm_selectedbudgetyear, final User user, final Connection connection, final String dateFormat) throws Exception
	{
		Set setCommitments = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				setCommitments = new TreeSet<Commitment>();
				final StringBuffer sqlBuf = new StringBuffer("select * from Commitment where comm_proposalid=? and comm_isActive=1");
				if (comm_selectedbudgetyear != null && comm_selectedbudgetyear.trim().length() != 0)
				{
					sqlBuf.append(" AND comm_budgetyear like ?");
				}
				preparedStatement = connection.prepareStatement(sqlBuf.toString());
				preparedStatement.setString(1, proj_id);
				if (comm_selectedbudgetyear != null && comm_selectedbudgetyear.trim().length() != 0)
				{
					preparedStatement.setString(2, comm_selectedbudgetyear);
				}
				result = preparedStatement.executeQuery();
				do
				{
					if (!result.next())
					{
						setCommitments = CommitmentDB.getReadOrWriteCommitments(setCommitments, user, dateFormat, connection);
						break;
					}
					setCommitments.add(CommitmentDB.readCommitment(result, user, true, connection, dateFormat));
				}
				while (true);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.getCommitmentsForProposal", e);
				throw e;
			}
			final Object var9_12 = null;
		}
		catch (final Throwable var10_10)
		{
			final Object var9_11 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var10_10;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return setCommitments;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateBudgets(final Commitment commitment, final User user) throws Exception
	{
		logger.debug("in updateBudget");
		Connection connection = null;
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				CommitmentDB.updateBudgets(commitment, connection, user);
			}
			catch (final Exception e)
			{
				logger.error("Error in method ProjectDB.updateBudget", e);
				throw e;
			}
			final Object var4_6 = null;
		}
		catch (final Throwable var5_4)
		{
			final Object var4_5 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var5_4;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void updateBudgets(final Commitment commitment, final Connection connection, final User user) throws Exception
	{
		PreparedStatement preparedStatement = null;
		try
		{
			try
			{
				preparedStatement = connection.prepareStatement("update Commitment set comm_initialbudget=?, comm_budget=?, comm_manualbudget=? where comm_id = ?");
				logger.debug("sql in ProjectDB.updateBudget(proj, conn) = update Commitment set comm_initialbudget=?, comm_budget=?, comm_manualbudget=? where comm_id = ?");
				logger.debug((Object) ("budget=" + commitment.getComm_budget()));
				logger.debug((Object) ("projectid=" + commitment.getComm_id()));
				preparedStatement.setBigDecimal(1, commitment.getComm_initialbudget());
				preparedStatement.setBigDecimal(2, commitment.getComm_budget());
				preparedStatement.setBigDecimal(3, commitment.getComm_manualbudget());
				preparedStatement.setString(4, commitment.getComm_id());
				preparedStatement.executeUpdate();
				preparedStatement.clearParameters();
			}
			catch (final Exception e)
			{
				logger.error("Error in method ProjectDB.updateBudget", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((PreparedStatement) preparedStatement);
	}

	public static Commitment readCommitment(final ResultSet result, final User user, final boolean withDetails, final Connection connection, final String dateFormat) throws SQLException, Exception
	{
		HashMap mapSelectionTable = null;
		StringBuffer buf = null;
		mapSelectionTable = (HashMap) SelectionTableSingleton.getInstance().get((Object) user.getLanguage());
		Commitment commitment = null;
		try
		{
			commitment = new Commitment();
			commitment.setComm_id(result.getString("comm_id") != null ? result.getString("comm_id").trim() : "");
			commitment.setComm_ref(result.getString("comm_ref") != null ? result.getString("comm_ref").trim() : "");
			commitment.setComm_custref(result.getString("comm_custref") != null ? result.getString("comm_custref").trim() : "");
			commitment.setComm_orgid(result.getString("comm_orgid") != null ? result.getString("comm_orgid").trim() : "");
			commitment.setComm_ownerid(result.getString("comm_ownerid") != null ? result.getString("comm_ownerid").trim() : "");
			commitment.setComm_notificationpersid(result.getString("comm_notificationpersid") != null ? result.getString("comm_notificationpersid").trim() : "");
			if (withDetails && commitment.getComm_notificationpersid() != null && commitment.getComm_notificationpersid().length() != 0)
			{
				commitment.setComm_notificationpersname(PersonDB.getName((String) commitment.getComm_notificationpersid(), (Connection) connection));
			}
			if (withDetails && commitment.getComm_orgid() != null && commitment.getComm_orgid().length() != 0)
			{
				commitment.setComm_orgname(OrganisationDB.getOrgName((String) commitment.getComm_orgid(), (String) user.getLanguage(), (Connection) connection));
			}
			if (withDetails && commitment.getComm_ownerid() != null && commitment.getComm_ownerid().length() != 0)
			{
				commitment.setComm_ownername(PersonDB.getName((String) commitment.getComm_ownerid(), (Connection) connection));
			}
			buf = new StringBuffer();
			buf.append("workflowStatus");
			buf.append("/");
			buf.append(result.getString("comm_status") != null ? result.getString("comm_status").trim() : "");
			commitment.setComm_status(result.getString("comm_status") != null ? result.getString("comm_status").trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_statustrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_statustrans(commitment.getComm_status());
			}
			buf = new StringBuffer();
			buf.append("projectCategory");
			buf.append("/");
			buf.append(result.getString("comm_category") != null ? result.getString("comm_category").trim() : "");
			commitment.setComm_category(result.getString("comm_category") != null ? result.getString("comm_category").trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_categorytrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_categorytrans(commitment.getComm_category());
			}
			buf = new StringBuffer();
			buf.append("projectSubCategory");
			buf.append("/");
			buf.append(result.getString("comm_subcategory") != null ? result.getString("comm_subcategory").trim() : "");
			commitment.setComm_subcategory(result.getString("comm_subcategory") != null ? result.getString("comm_subcategory").trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_subcategorytrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_subcategorytrans(commitment.getComm_subcategory());
			}
			commitment.setComm_projType(result.getString("comm_projType") != null ? result.getString("comm_projType").trim() : "");
			commitment.setComm_type(result.getString("comm_type") != null ? result.getString("comm_type").trim() : "");
			buf = new StringBuffer();
			buf.append("comm_type");
			buf.append("/");
			buf.append(commitment.getComm_type());
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_typeTrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_typeTrans(commitment.getComm_type());
			}
			buf = new StringBuffer();
			buf.append("projectOperCategory");
			buf.append("/");
			buf.append(result.getString("comm_opercategory") != null ? result.getString("comm_opercategory").trim() : "");
			commitment.setComm_opercategory(result.getString("comm_opercategory") != null ? result.getString("comm_opercategory").trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_opercategorytrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_opercategorytrans(commitment.getComm_opercategory());
			}
			commitment.setComm_comment(result.getString("comm_comment") != null ? result.getString("comm_comment").trim() : "");
			commitment.setComm_creationdate(result.getString("comm_creationdate") != null ? DataTypeSwitch.sqlDateToString((Date) result.getDate("comm_creationdate"), (String) dateFormat) : "");
			commitment.setComm_ownerdn(result.getString("comm_ownerdn") != null ? result.getString("comm_ownerdn").trim() : "");
			commitment.setComm_ownercn(result.getString("comm_ownercn") != null ? result.getString("comm_ownercn").trim() : "");
			commitment.setComm_motivation(result.getString("comm_motivation") != null ? result.getString("comm_motivation").trim() : "");
			commitment.setComm_isInBudget(result.getBoolean("comm_isInBudget"));
			commitment.setComm_extraApproval(result.getBoolean("comm_inheritApproval"));
			commitment.setComm_endperiod(result.getString("comm_endperiod") != null ? result.getString("comm_endperiod").trim() : "");
			buf = new StringBuffer();
			buf.append("month");
			buf.append("/");
			buf.append(commitment.getComm_endmonth() != null ? commitment.getComm_endmonth().trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_endmonthtrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_endmonthtrans(commitment.getComm_endmonth());
			}
			commitment.setComm_startperiod(result.getString("comm_startperiod") != null ? result.getString("comm_startperiod").trim() : "");
			buf = new StringBuffer();
			buf.append("month");
			buf.append("/");
			buf.append(commitment.getComm_startmonth() != null ? commitment.getComm_startmonth().trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_startmonthtrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_startmonthtrans(commitment.getComm_startmonth());
			}
			buf = new StringBuffer();
			buf.append("currency");
			buf.append("/");
			buf.append(result.getString("comm_currency") != null ? result.getString("comm_currency").trim() : "");
			commitment.setComm_currency(result.getString("comm_currency") != null ? result.getString("comm_currency").trim() : "");
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_currencytrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_currencytrans(commitment.getComm_currency());
			}
			commitment.setComm_supplier(result.getString("comm_supplier") != null ? result.getString("comm_supplier").trim() : "");
			if (withDetails && commitment.getComm_supplier() != null && !commitment.getComm_supplier().equalsIgnoreCase(""))
			{
				commitment.setComm_suppliername(OrganisationDB.getOrgName((String) commitment.getComm_supplier(), (String) user.getLanguage(), (Connection) connection));
				commitment.setComm_supplierref(OrganisationDB.getOrgCustCode((String) commitment.getComm_supplier(), (Connection) connection));
			}
			commitment.setComm_condition(result.getString("comm_condition") != null ? result.getString("comm_condition").trim() : "");
			commitment.setComm_budget(result.getBigDecimal("comm_budget") != null ? result.getBigDecimal("comm_budget") : new BigDecimal("0"));
			commitment.setComm_initialbudget(result.getBigDecimal("comm_initialbudget") != null ? result.getBigDecimal("comm_initialbudget") : new BigDecimal("0"));
			commitment.setComm_manualbudget(result.getBigDecimal("comm_manualbudget") != null ? result.getBigDecimal("comm_manualbudget") : new BigDecimal("0"));
			commitment.setComm_locknr(result.getInt("comm_locknr"));
			commitment.setComm_isactive(result.getBoolean("comm_isActive"));
			commitment.setComm_department(result.getString("comm_department") != null ? result.getString("comm_department").trim() : "");
			buf = new StringBuffer();
			buf.append("projDepartment");
			buf.append("/");
			buf.append(commitment.getComm_department());
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_departmenttrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_departmenttrans(commitment.getComm_department());
			}
			commitment.setComm_bu(result.getString("comm_bu") != null ? result.getString("comm_bu").trim() : "");
			buf = new StringBuffer();
			buf.append("projBusinessUnit");
			buf.append("/");
			buf.append(commitment.getComm_bu());
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_butrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_butrans(commitment.getComm_bu());
			}
			commitment.setComm_supplier(result.getString("comm_supplier") != null ? result.getString("comm_supplier").trim() : "");
			commitment.setComm_proposalid(result.getString("comm_proposalid") != null ? result.getString("comm_proposalid").trim() : "");
			if (withDetails && commitment.getComm_proposalid() != null && commitment.getComm_proposalid().length() != 0)
			{
				commitment.setComm_proposalref(ProjectDB.getProjectRef((String) commitment.getComm_proposalid(), (Connection) connection));
			}
			commitment.setComm_versionstatus(result.getString("comm_versionstatus") != null ? result.getString("comm_versionstatus").trim() : "");
			commitment.setComm_versiontype(result.getString("comm_versiontype") != null ? result.getString("comm_versiontype").trim() : "");
			commitment.setComm_versionnr(result.getString("comm_versionnr") != null ? result.getString("comm_versionnr").trim() : "");
			commitment.setComm_salesreps(CommitmentDB.getCommitmentSalesRepInfo(commitment.getComm_id(), connection));
			commitment.setComm_budgetyear(result.getString("comm_budgetyear") != null ? result.getString("comm_budgetyear") : "");
			commitment.setComm_depreciation_legal(result.getBigDecimal("comm_depreciation_legal"));
			commitment.setComm_depreciation_ifrs(result.getBigDecimal("comm_depreciation_ifrs"));
		}
		catch (final SQLException e)
		{
			logger.error("SQLException in readCommitment", e);
			throw e;
		}
		catch (final Exception e)
		{
			logger.error("Exception in readCommitment", e);
			throw e;
		}
		return commitment;
	}

	/*
	 * Unable to fully structure code
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 * Lifted jumps to return sites
	 */
	public static Set searchCommitmentsWithSearchCriteria(final HashMap mapSearchCriteria, final User user, final String dateFormat) throws Exception {
       connection = null;
       preparedStatement = null;
       result = null;
       setCommitments = new TreeSet<Commitment>();
       paramCount = 1;
       sqlBuf = null;
       listFoundOrgIds = null;
       listFoundOrgIds2 = null;
       listFoundOwnerIds = null;
       try {
           block29 : {
               try {
                   connection = DatabaseConnectionController.createConnection();
                   connection.setAutoCommit(false);
                   sqlBuf = new StringBuffer("select * from Commitment where comm_isActive = 1");
                   if (mapSearchCriteria.containsKey("comm_ref")) {
                       sqlBuf.append(" AND comm_ref LIKE ? ");
                   }
                   if (!mapSearchCriteria.containsKey("comm_ownername")) break block29;
                   listFoundOwnerIds = new ArrayList<String>();
                   map = new HashMap<String, V>();
                   map.put("pers_lastname", mapSearchCriteria.get("comm_ownername"));
                   setPersons = PersonDB.searchPersons(map, (User)user, (boolean)false, (String)dateFormat);
                   if (setPersons.isEmpty()) ** GOTO lbl27
                   sqlBuf.append(" AND comm_ownerid in (");
                   iter = setPersons.iterator();
                   tmpPerson = null;
                   ** GOTO lbl38
lbl27: // 1 sources:
                   var19_21 = setCommitments;
                   var17_24 = null;
                   DatabaseConnectionController.closeResources((ResultSet)result, (PreparedStatement)preparedStatement, (Connection)connection);
                   return var19_21;
               }
               catch (final Exception e) {
                   CommitmentDB.logger.error("Error in method ProjectDB.searchProjectsWithSearchCriteria", e);
                   connection.rollback();
                   throw e;
               }
lbl-1000: // 1 sources:
               {
                   tmpPerson = (Person)iter.next();
                   listFoundOwnerIds.add(tmpPerson.getPers_id());
lbl38: // 2 sources:
                   ** while (iter.hasNext())
               }
lbl39: // 1 sources:
               if (!listFoundOwnerIds.isEmpty()) {
                   i = 0;
                   while (i < listFoundOwnerIds.size() - 1) {
                       sqlBuf.append("?,");
                       ++i;
                   }
                   sqlBuf.append("?)");
               }
           }
           if (!mapSearchCriteria.containsKey("comm_orgname")) ** GOTO final lbl72
           listFoundOrgIds = new ArrayList<String>();
           map = new HashMap<K, V>();
           map.put("org_name", mapSearchCriteria.get("comm_orgname"));
           setOrganisations = OrganisationDB.searchOrganisations((Connection)connection, map, (User)user, (boolean)false);
           if (setOrganisations.isEmpty()) ** GOTO lbl57
           sqlBuf.append(" AND comm_orgid in (");
           iter = setOrganisations.iterator();
           tmpOrg = null;
           ** GOTO lbl64
lbl57: // 1 sources:
           var19_22 = setCommitments;
           var17_25 = null;
           DatabaseConnectionController.closeResources((ResultSet)result, (PreparedStatement)preparedStatement, (Connection)connection);
           return var19_22;
lbl-1000: // 1 sources:
           {
               tmpOrg = (Organisation)iter.next();
               listFoundOrgIds.add(tmpOrg.getOrg_id());
lbl64: // 2 sources:
               ** while (iter.hasNext())
           }
lbl65: // 1 sources:
           if (!listFoundOrgIds.isEmpty()) {
               i = 0;
               while (i < listFoundOrgIds.size() - 1) {
                   sqlBuf.append("?,");
                   ++i;
               }
               sqlBuf.append("?)");
           }
lbl72: // 4 sources:
           if (!mapSearchCriteria.containsKey("comm_orgmatchcode")) ** GOTO final lbl97
           listFoundOrgIds2 = new ArrayList<String>();
           map = new HashMap<K, V>();
           map.put("org_matchcode", mapSearchCriteria.get("comm_orgmatchcode"));
           setOrganisations = OrganisationDB.searchOrganisations((Connection)connection, map, (User)user, (boolean)false);
           if (setOrganisations.isEmpty()) ** GOTO lbl82
           sqlBuf.append(" AND comm_orgid in (");
           iter = setOrganisations.iterator();
           tmpOrg = null;
           ** GOTO lbl89
lbl82: // 1 sources:
           var19_23 = setCommitments;
           var17_26 = null;
           DatabaseConnectionController.closeResources((ResultSet)result, (PreparedStatement)preparedStatement, (Connection)connection);
           return var19_23;
lbl-1000: // 1 sources:
           {
               tmpOrg = (Organisation)iter.next();
               listFoundOrgIds2.add(tmpOrg.getOrg_id());
lbl89: // 2 sources:
               ** while (iter.hasNext())
           }
lbl90: // 1 sources:
           if (!listFoundOrgIds2.isEmpty()) {
               i = 0;
               while (i < listFoundOrgIds2.size() - 1) {
                   sqlBuf.append("?,");
                   ++i;
               }
               sqlBuf.append("?)");
           }
lbl97: // 4 sources:
           if (mapSearchCriteria.containsKey("comm_status")) {
               sqlBuf.append(" AND comm_status = ?");
           }
           if (mapSearchCriteria.containsKey("comm_budgetyear")) {
               sqlBuf.append(" AND comm_budgetyear like ?");
           }
           if (mapSearchCriteria.containsKey("comm_comment")) {
               sqlBuf.append(" AND UPPER(comm_comment) like ?");
           }
           CommitmentDB.logger.debug((Object)("sql in searchprojects = " + sqlBuf.toString()));
           preparedStatement = connection.prepareStatement(sqlBuf.toString());
           if (mapSearchCriteria.containsKey("comm_ref")) {
               preparedStatement.setString(paramCount, "%" + (String)mapSearchCriteria.get("comm_ref") + "%");
               ++paramCount;
           }
           if (mapSearchCriteria.containsKey("comm_ownername")) {
               i = 0;
               while (i < listFoundOwnerIds.size()) {
                   preparedStatement.setString(paramCount, (String)listFoundOwnerIds.get(i));
                   ++paramCount;
                   ++i;
               }
           }
           if (mapSearchCriteria.containsKey("comm_orgname")) {
               i = 0;
               while (i < listFoundOrgIds.size()) {
                   preparedStatement.setString(paramCount, (String)listFoundOrgIds.get(i));
                   ++paramCount;
                   ++i;
               }
           }
           if (mapSearchCriteria.containsKey("comm_orgmatchcode")) {
               i = 0;
               while (i < listFoundOrgIds2.size()) {
                   preparedStatement.setString(paramCount, (String)listFoundOrgIds2.get(i));
                   ++paramCount;
                   ++i;
               }
           }
           if (mapSearchCriteria.containsKey("comm_status")) {
               preparedStatement.setString(paramCount, (String)mapSearchCriteria.get("comm_status"));
               ++paramCount;
           }
           if (mapSearchCriteria.containsKey("comm_budgetyear")) {
               preparedStatement.setString(paramCount, "%" + (String)mapSearchCriteria.get("comm_budgetyear") + "%");
               ++paramCount;
           }
           if (mapSearchCriteria.containsKey("comm_comment")) {
               preparedStatement.setString(paramCount, "%" + ((String)mapSearchCriteria.get("comm_comment")).toUpperCase() + "%");
               ++paramCount;
           }
           result = preparedStatement.executeQuery();
           preparedStatement.clearParameters();
           while (result.next()) {
               setCommitments.add((Commitment)CommitmentDB.readCommitment(result, user, true, connection, dateFormat));
           }
           CommitmentDB.logger.info((Object)("number commitments found : " + setCommitments.size()));
           setCommitments = CommitmentDB.getReadOrWriteCommitments(setCommitments, user, dateFormat, connection);
           CommitmentDB.logger.info((Object)("number commitments found after SR : " + setCommitments.size()));
           connection.commit();
           var17_28 = null;
       }
       catch (final Throwable var18_29) {
           var17_27 = null;
           DatabaseConnectionController.closeResources((ResultSet)result, (PreparedStatement)preparedStatement, (Connection)connection);
           throw var18_29;
       }
       DatabaseConnectionController.closeResources((ResultSet)result, (PreparedStatement)preparedStatement, (Connection)connection);
       return setCommitments;
   }

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void setCommitmentInactive(final String[] arrCommitments) throws Exception
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		final StringBuffer buf = new StringBuffer("update Commitment set comm_isActive = 0 where comm_id in (");
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				preparedStatement = SqlManipulations.fillTheInClause((Connection) connection, (String[]) arrCommitments, (StringBuffer) buf);
				preparedStatement.executeUpdate();
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.setCommitmentInactive", e);
				throw e;
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static Set searchAllCommitments(final User user, final String dateFormat) throws Exception
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Set setCommitments = new TreeSet<Commitment>();
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				preparedStatement = connection.prepareStatement("select * from Commitment where comm_isActive=1");
				result = preparedStatement.executeQuery();
				preparedStatement.clearParameters();
				do
				{
					if (!result.next())
					{
						setCommitments = CommitmentDB.getReadOrWriteCommitments(setCommitments, user, dateFormat, connection);
						break;
					}
					setCommitments.add(CommitmentDB.readCommitment(result, user, true, connection, dateFormat));
				}
				while (true);
			}
			catch (final Exception e)
			{
				logger.error("Error in method ProjectDB.searchAllProjects", e);
				throw e;
			}
			final Object var7_9 = null;
		}
		catch (final Throwable var8_7)
		{
			final Object var7_8 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement, (Connection) connection);
			throw var8_7;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement, (Connection) connection);
		return setCommitments;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static Set searchCommitmentsWithFirstCharacter(final String letter, final User user, final String proposal_id, final String dateFormat) throws Exception
	{
		logger.debug("in searchCommitmentsWithFirstCharacter(String letter, User user, String proposal_id)");
		Connection connection = null;
		Set setCommitments = new TreeSet();
		try
		{
			try
			{
				connection = DatabaseConnectionController.createConnection();
				setCommitments = CommitmentDB.searchCommitmentsWithFirstCharacter(connection, letter, user, proposal_id, dateFormat);
			}
			catch (final Exception e)
			{
				logger.error("Error in method ProjectDB.in searchCommitmentsWithFirstCharacter(String letter, User user, String proposal_id)", e);
				throw e;
			}
			final Object var7_9 = null;
		}
		catch (final Throwable var8_7)
		{
			final Object var7_8 = null;
			DatabaseConnectionController.closeResources((Connection) connection);
			throw var8_7;
		}
		DatabaseConnectionController.closeResources((Connection) connection);
		return setCommitments;
	}

	private static Set searchCommitmentsWithFirstCharacter(final Connection connection, final String letter, final User user, final String filter, final String dateFormat) throws Exception
	{
		Set setCommitments = null;
		setCommitments = Constants.listAlphabetWithoutSymbol.contains(letter.toUpperCase()) || Constants.listAlphabetWithoutSymbol.contains(letter.toLowerCase()) ? CommitmentDB.searchCommitmentsWithFirstLetter(connection, letter, user, filter, dateFormat) : CommitmentDB
				.searchCommitmentsWithFirstSymbol(connection, user, filter, dateFormat);
		return setCommitments;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	private static Set searchCommitmentsWithFirstLetter(final Connection connection, final String firstLetter, final User user, final String proposal_id, final String dateFormat) throws Exception
	{
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Set setCommitments = new TreeSet<Commitment>();
		try
		{
			try
			{
				if (proposal_id == null)
				{
					preparedStatement = connection.prepareStatement("select * from Commitment where (comm_ref like ? or comm_ref like ?) and comm_isActive=1");
					preparedStatement.setString(1, String.valueOf(firstLetter.toLowerCase()) + "%");
					preparedStatement.setString(2, String.valueOf(firstLetter.toUpperCase()) + "%");
				}
				else
				{
					final StringBuffer sqlBuf = new StringBuffer("select * from Commitment where (comm_ref like ? or comm_ref like ?) and comm_isActive=1");
					sqlBuf.append(" and comm_proposalid=?");
					preparedStatement = connection.prepareStatement(sqlBuf.toString());
					preparedStatement.setString(1, String.valueOf(firstLetter.toLowerCase()) + "%");
					preparedStatement.setString(2, String.valueOf(firstLetter.toUpperCase()) + "%");
					preparedStatement.setString(3, proposal_id);
				}
				result = preparedStatement.executeQuery();
				preparedStatement.clearParameters();
				do
				{
					if (!result.next())
					{
						setCommitments = CommitmentDB.getReadOrWriteCommitments(setCommitments, user, dateFormat, connection);
						break;
					}
					setCommitments.add(CommitmentDB.readCommitment(result, user, true, connection, dateFormat));
				}
				while (true);
			}
			catch (final Exception e)
			{
				logger.error("Error in method CommitmentDB.searchCommitmentsWithFirstLetter", e);
				throw e;
			}
			final Object var9_12 = null;
		}
		catch (final Throwable var10_10)
		{
			final Object var9_11 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var10_10;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return setCommitments;
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	private static Set searchCommitmentsWithFirstSymbol(final Connection connection, final User user, final String proposal_id, final String dateFormat) throws Exception
	{
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Set setCommitments = new TreeSet<Commitment>();
		try
		{
			try
			{
				final StringBuffer buf = new StringBuffer("select * from Commitment where comm_isActive = 1");
				buf.append(SqlManipulations.create_NotLike_Stmt((ArrayList) Constants.listAlphabetWithoutSymbol, (String) "comm_ref", (boolean) true));
				buf.append(" and comm_isActive=1");
				if (proposal_id != null)
				{
					buf.append(" and comm_proposalid=?");
				}
				preparedStatement = connection.prepareStatement(buf.toString());
				logger.debug("sql in searchProjectsWithFirstSymbol=" + buf.toString());
				if (proposal_id != null)
				{
					preparedStatement.setString(1, proposal_id);
				}
				result = preparedStatement.executeQuery();
				preparedStatement.clearParameters();
				do
				{
					if (!result.next())
					{
						setCommitments = CommitmentDB.getReadOrWriteCommitments(setCommitments, user, dateFormat, connection);
						break;
					}
					setCommitments.add(CommitmentDB.readCommitment(result, user, true, connection, dateFormat));
				}
				while (true);
			}
			catch (final SQLException e)
			{
				logger.error("Error in method CommitmentDB.searchCommitmentsWithFirstSymbol", e);
				throw e;
			}
			final Object var8_11 = null;
		}
		catch (final Throwable var9_9)
		{
			final Object var8_10 = null;
			DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
			throw var9_9;
		}
		DatabaseConnectionController.closeResources((ResultSet) result, (PreparedStatement) preparedStatement);
		return setCommitments;
	}

	private static Set getReadOrWriteCommitments(final Set setTmpCommitments, final User user, final String dateFormat, final Connection connection) throws Exception
	{
		TreeSet<Commitment> setCommitments;
		setCommitments = new TreeSet<Commitment>();
		Commitment commitment = null;
		try
		{
			int counter = 0;
			final Iterator iteratorTmpCommitments = setTmpCommitments.iterator();
			while (iteratorTmpCommitments.hasNext())
			{
				commitment = (Commitment) iteratorTmpCommitments.next();
				++counter;
				final Iterator iter = commitment.getComm_salesreps().iterator();
				while (iter.hasNext())
				{
					final String sr_comm = (String) iter.next();
					commitment.setComm_isEditable(true);
					if (user.getListAuthorSRs().contains(sr_comm))
					{
						commitment.setComm_isEditable(true);
						setCommitments.add(commitment);
						++counter;
						break;
					}
					if (!user.getListReaderSRs().contains(sr_comm))
						continue;
					commitment.setComm_isEditable(false);
					setCommitments.add(commitment);
					++counter;
				}
				if (setCommitments.contains((Object) commitment))
				{
					commitment.setComm_isRemovable(true);
					if (PurchaseOrderDB.hasCommitmentPurchaseOrders((String) commitment.getComm_id(), (User) user, (Connection) connection))
					{
						commitment.setComm_isRemovable(false);
					}
					if (commitment.isComm_isEditable())
					{
						if (user.isInRole("role12"))
						{
							commitment.setComm_isEditable(true);
						}
						else if (be.ibsbe.isis.workflow.Constants.LIST_CODES_DELETE_OR_EDIT_ALLOWED.contains(commitment.getComm_status()))
						{
							commitment.setComm_isEditable(true);
						}
						else if (be.ibsbe.isis.workflow.Constants.LIST_CODES_DELETE_OR_EDIT_NOT_ALLOWED.contains(commitment.getComm_status()))
						{
							commitment.setComm_isEditable(false);
							commitment.setComm_isRemovable(false);
						}
					}
					logger.debug((Object) ("commitment " + commitment.getComm_ref() + " (status " + commitment.getComm_statustrans() + ") editable=" + commitment.isComm_isEditable() + " / removable=" + commitment.isComm_isRemovable()));
				}
				if (counter < 200)
				{
					continue;
				}
				break;
			}
		}
		catch (final Exception e)
		{
			logger.error("Exception in getReadOrWriteProjects");
			throw e;
		}
		return setCommitments;
	}

	public static Set getCommitmentSalesRepInfo(final String commitmentId, final Connection connection) throws Exception
	{
		final TreeSet<String> setSRs = new TreeSet<String>();
		final PreparedStatement preparedStatement = connection.prepareStatement("select * from commitmentsr where commsr_commid = ?");
		preparedStatement.setString(1, commitmentId);
		final ResultSet result = preparedStatement.executeQuery();
		while (result.next())
		{
			setSRs.add(result.getString("commsr_srid"));
		}
		return setSRs;
	}

	private static void writeSR(final Commitment commitment, final Connection connection) throws Exception
	{
		PreparedStatement pst = null;
		final AdminSettingsSingleton adminSettingsSingleton = AdminSettingsSingleton.getInstance();
		commitment.getComm_salesreps().addAll((ArrayList) adminSettingsSingleton.get((Object) "adminSalesreps"));
		pst = connection.prepareStatement("insert into commitmentsr (commsr_id,commsr_srid,commsr_commid) values (?,?,?)");
		final Iterator iter = commitment.getComm_salesreps().iterator();
		while (iter.hasNext())
		{
			pst.setString(1, General.createUniqueFileName());
			pst.setString(2, (String) iter.next());
			pst.setString(3, commitment.getComm_id());
			pst.executeUpdate();
			pst.clearParameters();
		}
	}

	private static void deleteSalesrepsOfCommitment(final String commitmentId, final Connection connection) throws Exception
	{
		try
		{
			final PreparedStatement pst = connection.prepareStatement("delete from commitmentsr where commsr_commid = ?");
			pst.setString(1, commitmentId);
			pst.executeUpdate();
		}
		catch (final Exception e)
		{
			logger.error("Error in method CampaignDB.deleteSalesrepsOfCampaign", e);
			throw e;
		}
	}

	/*
	 * Enabled aggressive block sorting
	 * Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation
	 */
	public static void closeHeader(final Commitment commitment, final User user, final String dateFormat) throws Exception
	{
		Connection conn = null;
		try
		{
			try
			{
				conn = DatabaseConnectionController.createConnection();
				CommitmentDB.closeHeader(commitment, user, dateFormat, conn);
			}
			catch (final Exception var4_4)
			{
			}
			final Object var5_7 = null;
		}
		catch (final Throwable var6_5)
		{
			final Object var5_6 = null;
			DatabaseConnectionController.closeResources((Connection) conn);
			throw var6_5;
		}
		DatabaseConnectionController.closeResources((Connection) conn);
	}

	public static void closeHeader(final Commitment commitment, final User user, final String dateFormat, final Connection connection) throws Exception
	{
		final HashMap mapSelectionTable = (HashMap) SelectionTableSingleton.getInstance().get((Object) user.getLanguage());
		try
		{
			commitment.setComm_status("70");
			final StringBuffer buf = new StringBuffer();
			buf.append("workflowStatus");
			buf.append("/");
			buf.append(commitment.getComm_status());
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_statustrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_statustrans(commitment.getComm_status());
			}
			CommitmentDB.updateStatus(commitment.getComm_id(), commitment.getComm_status(), connection);
			final Set purchaseOrders = PurchaseOrderDB.getPurchaseOrdersForCommitment((String) commitment.getComm_id(), (String) null, (boolean) false, (User) user, (String) dateFormat);
			final Iterator it = purchaseOrders.iterator();
			while (it.hasNext())
			{
				final PurchaseOrderHeader poh = (PurchaseOrderHeader) it.next();
				if (poh.isPoh_isApproved())
				{
					PurchaseOrderDB.closeHeader((PurchaseOrderHeader) poh, (User) user, (String) dateFormat, (Connection) connection);
					continue;
				}
				throw new Exception("Not All PurchaseOrders Have Status Approved...");
			}
			final WorkflowLog log = new WorkflowLog("key");
			int transactionnumber = WorkflowLogDB.getTransactionNr((String) "commitment", (String) commitment.getComm_id());
			log.setWfl_objecttype("commitment");
			log.setWfl_objectid(commitment.getComm_id());
			log.setWfl_uid(user.getUid());
			log.setWfl_answer(commitment.getComm_status());
			log.setWfl_comment("");
			log.setWfl_date(new Timestamp(System.currentTimeMillis()));
			log.setWfl_transactionnr(++transactionnumber);
			WorkflowLogDB.insert((WorkflowLog) log);
			connection.commit();
		}
		catch (final Exception e)
		{
			logger.info("error in closeHeader", e);
			connection.rollback();
			commitment.setComm_status("30");
			final StringBuffer buf = new StringBuffer();
			buf.append("workflowStatus");
			buf.append("/");
			buf.append(commitment.getComm_status());
			if (mapSelectionTable.get(buf.toString()) != null && !"".equals(mapSelectionTable.get(buf.toString())))
			{
				commitment.setComm_statustrans((String) mapSelectionTable.get(buf.toString()));
			}
			else
			{
				commitment.setComm_statustrans(commitment.getComm_status());
			}
			throw e;
		}
	}
}
