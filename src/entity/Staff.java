package entity;

public class Staff extends User {

	private Double workHourLimit;
	private String preferredName;
	private String homeAddress;

	public Double getWorkHourLimit() {
		return workHourLimit;
	}

	public void setWorkHourLimit(Double workHourLimit) {
		this.workHourLimit = workHourLimit;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

}
