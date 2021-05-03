package com.hcl.bank.dto;

import javax.validation.constraints.Email;

public class UserDTO {
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", password=" + password + ", email=" + email + ", username=" + username
				+ ", firstname=" + firstname + ", last_name=" + last_name + ", city=" + city + ", state=" + state
				+ ", pancard=" + pancard + ", phonenumber=" + phonenumber + "]";
	}

	private Integer userId;
	private String password;
	@Email
	private String email;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private String username;
	private String firstname;
	private String last_name;
	private String city;
	private String state;
	private String pancard;
	private long phonenumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

}
