package entity;

import java.sql.Date;

public class Shift {

	private int id;
	private Date startTime;
	private Date endTime;
	private double duration;
	private String location;
	private int staffAllocated;
	private int status;		// 0 - initial, 1 - allocated, 2 - accepted, 3 - rejected, 4 - cancelled
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.sql.Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.sql.Date endTime) {
		this.endTime = endTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStaffAllocated() {
		return staffAllocated;
	}

	public void setStaffAllocated(int staffAllocated) {
		this.staffAllocated = staffAllocated;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
