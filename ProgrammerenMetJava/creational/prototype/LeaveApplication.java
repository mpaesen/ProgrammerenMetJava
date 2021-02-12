package creational.prototype;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveApplication implements Cloneable {

	private String reason;
	private Date startDate;
	private Date endDate;
	private Approver approver;

	public LeaveApplication(
			String reason, Date startDate, Date endDate, Approver approver){

		this.reason = reason;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approver = approver;
	}

	public LeaveApplication clone(){

		Approver copyApprover = new Approver(
			approver.getName(), approver.getDesignation());
		LeaveApplication copyApplication = new LeaveApplication(
			reason, ((Date)startDate.clone()), ((Date)endDate.clone()), copyApprover);
		return copyApplication;
	}

	public String toString(){
		return "[Leave Application:" + reason + "," + toString(startDate)
			+ "," + toString(endDate) + approver + "]";
	}

	private String toString(Date date){

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
		return format.format(date);
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Approver getApprover() {
		return approver;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}
}