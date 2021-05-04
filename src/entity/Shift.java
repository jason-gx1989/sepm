package entity;

import java.sql.Date;

public class Shift {

	private int id;
//	private Date startTime;
//	private Date endTime;
	private Date startTime;
	private Date endTime;
	private double duration;
	private String location;
	private int staffAllocated;// 外键，指向staff
	private int status;// 状态：0--初始，1--已分配，2--接受，3--拒绝，4--紧急取消
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Date getStartTime() {
		return startTime;
	}

	public void setStartTime(java.sql.Date startTime) {
		this.startTime = startTime;
	}

	public java.sql.Date getEndTime() {
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
