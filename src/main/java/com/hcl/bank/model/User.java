package com.hcl.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstname=" + firstname + ", last_name="
				+ last_name + ", email=" + email + ", city=" + city + ", state=" + state + ", pancard=" + pancard
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", getUserId()=" + getUserId()
				+ ", getUsername()=" + getUsername() + ", getFirstname()=" + getFirstname() + ", getLast_name()="
				+ getLast_name() + ", getEmail()=" + getEmail() + ", getCity()=" + getCity() + ", getState()="
				+ getState() + ", getPancard()=" + getPancard() + ", getPassword()=" + getPassword()
				+ ", getPhonenumber()=" + getPhonenumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "user_name")
	private String username;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "email")
	private String email;

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pan_card")
	private String pancard;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_number")
	private long phonenumber;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

}
