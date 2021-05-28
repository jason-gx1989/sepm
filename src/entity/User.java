package entity;

import java.util.Date;

public class User {

	private int id;
	private String fullName;
	private String password;
	private int isPasswordUpdated;// 0 - no, 1 - yes
	private String mobileNumber;
	private String email;
	private Date createTIme;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsPasswordUpdated() {
		return isPasswordUpdated;
	}

	public void setIsPasswordUpdated(int isPasswordUpdated) {
		this.isPasswordUpdated = isPasswordUpdated;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTIme() {
		return createTIme;
	}

	public void setCreateTIme(Date createTIme) {
		this.createTIme = createTIme;
	}

}
